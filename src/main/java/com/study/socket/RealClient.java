package com.study.socket;

import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class RealClient {

    public static void main(String[] args) {
        RealClient realClient = new RealClient();
        Socket socket = null;
        Socket machineSideSocket = null;
        Socket netSideSocket = null;
        try {
            //socket = new Socket("192.168.11.10", 502);
            netSideSocket = new Socket("192.168.11.11", 503);
            //machineSideSocket = new Socket("192.168.11.12", 503);
        } catch (IOException e) {
            System.out.println("出错了");
        }
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String faultCsvName = "PMSFC_001_FaultLog_" +df.format(date) + ".csv";
//        for (int i = 0; i < 1; i++) {
//            String position = Integer.toHexString(i);
//            while(position.length() < 4) {
//                position = "0" + position;
//            }
//            String dspCsvName = "data/PMSFC_001_dsp_netSide_" + i + ".csv";
//            realClient.dealDsp(netSideSocket, position, dspCsvName);
//        }

        realClient.dealDsp(netSideSocket, "0012", "123.csv");

        //realClient.dealFault(socket, faultCsvName, netSideSocket, machineSideSocket);
    }

    public boolean dealDsp(Socket socket, String position, String dspCsvName) {
        boolean result = false;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("Dsp.txt");
            byte[] bytes = new byte[1024];
            int len = 0;
            String title = "";
            while ((len = fileInputStream.read(bytes)) != -1) {
                title += new String(bytes, 0, len);
            }
            fileInputStream.close();
            result = createCSV(dspCsvName, title);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            final InputStream inputStream = socket.getInputStream();

            byte[][] realHead = new byte[1000][66];
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        try {
                            inputStream.read(realHead[i]);
                            System.out.println(i + "---" + bytesToHex(realHead[i], 66));
                        } catch (IOException e) {
                            System.out.println("出错了" + e.getMessage());
                        }
                    }
                    for (int i = 0; i < 1000; i++) {
                        try {
                            inputStream.read(realHead[i]);
                            System.out.println(i + "---" + bytesToHex(realHead[i], 66));
                        } catch (IOException e) {
                            System.out.println("出错了" + e.getMessage());
                        }
                    }
                    countDownLatch.countDown();
                }
            }).start();
            String ss = "a900" + position + "010101010101";
            outputStream.write(hexToByteArray(ss));
            outputStream.write(hexToByteArray(ss));
            outputStream.flush();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                System.out.println("countDownLatch出错了" + e.getMessage());
            }

            StringBuilder stringBuilder = new StringBuilder("");
            String realHeadStr = "a900";
            for (int i = 0; i < 1000; i++) {
                String readHeadStr = bytesToHex(realHead[i], 2);
                if (realHeadStr.equals(readHeadStr)) {
                    stringBuilder.append((i + 1) + "").append(",");
                    for (int j = 2; j < 66; j += 2) {
                        int print = readInt(realHead[i][j], realHead[i][j + 1]);
                        stringBuilder.append(print + "").append(",");
                    }
                    stringBuilder.append("\n");
                }
            }
            OutputStream outputStream1 = new FileOutputStream(dspCsvName, true);
            outputStream1.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            outputStream1.flush();
            outputStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    public boolean dealFault(Socket socket, String csvName, Socket netSideSocket, Socket machineSideSocket) {
        boolean result = false;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();

            // 创建csv文件
            String title = readFromFile("FaultTitle.txt");
            if ("".equals(title)) {
                return false;
            } else {
            }
            result = createCSV(csvName, title);
            if (!result) {
                return false;
            }

            StringBuilder transform = new StringBuilder("");

            Map<String,Integer> netSideMap = new HashMap<>();
            Map<String,Integer> machineSideMap = new HashMap<>();

            long id = 1;
            String position = "001d"; // 储存当前故障次数的寄存器所在的位置 0~199
            int faultTotal = queryValueByPosition(outputStream, inputStream, position);
            if (faultTotal < 0 || faultTotal >199) {
                System.out.println("储存当前故障次数的寄存器中的值不合要求");
                return false;
            }
            for (int i = 0; i <= faultTotal; i++) {
                int[] faults = new int[106];
                result = dealOneFault(outputStream, inputStream, faults, netSideMap, machineSideMap, transform, i);
                if (!result) {
                    return false;
                }
            }


            // 历史故障记录将写入csv文件
            result = writeToFile(csvName, transform.toString());
            if (!result) {
                return false;
            }

            /*
            // 处理网侧录播
            for (Map.Entry<String, Integer> entry: netSideMap.entrySet()) {
                String name = entry.getKey();
                int value = entry.getValue();
                String place = Integer.toHexString(value);
                while(place.length() < 4) {
                    place = "0" + place;
                }
                String dspCsvName = netSideDspFilePrefix + name + "_" + value + ".csv";
                // 创建csv文件
                if (currentNetSideDspCsvTitle == null) {
                    // 从文件中获取csvTitle，并创建csv文件
                    String title = readFromFile(netSideDspCsvTitle);
                    if ("".equals(title)) {
                        return false;
                    } else {
                        currentNetSideDspCsvTitle = title;
                    }
                }
                result = createCSV(dspCsvName, currentNetSideDspCsvTitle);
                if (!result) {
                    return false;
                }

                result = dealDsp(netSideSocket, place, dspCsvName);
                if (!result) {
                    return false;
                }
            }

            // 处理机侧录播
            for (Map.Entry<String, Integer> entry: machineSideMap.entrySet()) {
                String name = entry.getKey();
                int value = entry.getValue();
                String place = Integer.toHexString(value);
                while(place.length() < 4) {
                    place = "0" + place;
                }
                String dspCsvName = manchineSideDspFilePrefix + name + "_" + value + ".csv";
                // 创建csv文件
                if (currentManchineSideDspCsvTitle == null) {
                    // 从文件中获取csvTitle，并创建csv文件
                    String title = readFromFile(manchineSideDspCsvTitle);
                    if ("".equals(title)) {
                        return false;
                    } else {
                        currentManchineSideDspCsvTitle = title;
                    }
                }
                result = createCSV(dspCsvName, currentManchineSideDspCsvTitle);
                if (!result) {
                    return false;
                }

                result = dealDsp(machineSideSocket, place, dspCsvName);
                if (!result) {
                    return false;
                }
            }

            */
        } catch (Exception e) {
            System.out.println("请求历史故障数据失败");
            return false;
        }
        System.out.println("请求历史故障数据完成");
        return true;
    }

    public boolean dealOneFault(OutputStream outputStream, InputStream inputStream, int [] faults, Map<String,Integer> netSideMap, Map<String,Integer> machineSideMap, StringBuilder transform, int faultNumber) throws IOException {
        boolean result = false;

        String hex= Integer.toHexString(faultNumber);
        while(hex.length() < 4) {
            hex = "0" + hex;
        }
        // 在输入历史故障查询次数对应的000d寄存器中写入需要查询的第一次历史故障0000
        result = writeCommand("000d", hex, outputStream, inputStream);
        if(!result) {
            return false;
        }

        // 在控制字0000中写入历史故障查询跳转命令00af
        result = writeCommand("0000", "00af", outputStream, inputStream);
        if(!result) {
            return false;
        }

        //230 6a  560，106
        // 从560开始，读取106个寄存器中的值
        String command = "00000000000001040230006a";
        outputStream.write(hexToByteArray(command));
        outputStream.flush();


        result = analysisFaultPackage(inputStream, faults);
        if(!result) {
            return false;
        }
        // 添加当前故障统计次数 6
        int code = faults[6] + 1;
        transform.append(code + "").append(",");

        // 添加故障发生日期 0~2
        String dateStr = "";
        if (faults[0] != 255) { // 如果时间正常，则拼接年前缀。
            dateStr += "20";
        }
        dateStr += String.format("%02d", faults[0])
                + "-" + String.format("%02d", faults[1]) + "-" + String.format("%02d", faults[2]);
        transform.append(dateStr).append(",");

        // 添加故障发生时间 3~5
        String timeStr = String.format("%02d", faults[3]) + ":" + String.format("%02d", faults[4])
                + ":" + String.format("%02d", faults[5]);
        transform.append(timeStr).append(",");


        // 将网侧故障序号和机侧故障编号记录到map中
        String timeStrFile = String.format("%02d", faults[3]) + "-" + String.format("%02d", faults[4])
                + "-" + String.format("%02d", faults[5]);
        String key = dateStr + "_" + timeStrFile + "_" + code;
        // 网侧故障序号 584
        int netSideOrderNumber = faults[24];
        if (netSideOrderNumber != 65535) {
            netSideMap.put(key,netSideOrderNumber);
        }
        // 机侧故障编号 626
        int machineSideNumber = faults[66];
        if (machineSideNumber != 65535) {
            machineSideMap.put(key,machineSideNumber);
        }


        /**
         * 网侧主状态字,网侧故障字1,网侧故障字2,网侧故障字3,
         * 网侧直流侧电压,电网无功电流,电网有功电流,网侧有功功率,
         * 电网电压Vab,电网电压Vbc,网侧电网频率,网侧无功功率,
         * 网侧电流Ia,网侧电流Ib,网侧电流Ic,网侧硬件保护类型,
         * 网侧LVRT类型,网侧故障序号,网侧辅助状态字,网侧运行状态,
         * 网侧运行状态解析,主控通讯控制字,主控节点控制字,网侧风扇转速
         */
        // 添加网侧参数24个 31 = 7 + 24
        for (int j = 7; j < 31; j++) {
            transform.append(faults[j] + "").append(",");
        }

        /**
         * 机侧主状态字,机侧故障字1,机侧故障字2,机侧故障字3,
         * 机侧直流侧电压,转子无功电流Iq,转子有功电流Id,定子有功功率,
         * 电网电压Uab,定子电压Uab,电机转速,备用
         * 转子K相电流,转子L相电流,转子M相电流,机侧硬件保护类型,
         * 移相补偿角,机侧LVRT类型,总并网U相电流,总并网V相电流,
         * 总并网W相电流,机侧故障编号,机侧辅助状态字,机侧运行状态,
         * 机侧运行状态解析
         */
        // 添加机侧参数25个,网侧和机侧之间还有4个无用参数和9个其他参数。45 = 32 + 13，70 = 45 + 25
        for (int j = 45; j < 70; j++) {
            transform.append(faults[j] + "").append(",");
        }

        /**
         * 主要故障类,通讯故障节点,监控节点故障字1,监控节点故障字2,
         * 主控给定转矩,当前转矩,定子有功功率,系统总有功功率,
         * 系统总无功功率,停机路径,网侧有功功率,总并网无功功率,
         * 网侧无功功率,ARM控制字,发电机转速,首发故障码,
         * 主控无功给定,系统准备状态字,系统控制成功标志,主进程失败标志,
         * 机侧风扇转速rpm,网侧模块最高温度*100℃,机侧模块最高温度*100℃,功率柜环境最高温度*100℃,
         * 并网柜环境最高温度*100℃
         */
        //添加参数25个，中间11个无用参数。81 = 70 + 11，106 = 81 + 25
        for (int j = 81; j < 106; j++) {
            transform.append(faults[j] + "").append(",");
        }

        /**
         * Crowbar电阻环境温度*100℃,塔筒环境温度*100℃,电抗器线包最大温度*100℃
         */
        //中间3个无用参数。34 = 31 + 3，37 = 34 + 3
        for (int j = 34; j < 37; j++) {
            transform.append(faults[j] + "").append(",");
        }
        /**
         * 水冷系统故障字,水冷系统状态字,进水口压力*100Bar,出水口压力*100Bar,进水口温度*100℃,出水口温度*100℃
         */
        //中间1个无用参数。38 = 37 + 1，44 = 38 + 6
        for (int j = 38; j < 44; j++) {
            transform.append(faults[j] + "").append(",");
        }
        //中间1个无用参数 45 = 44 + 1

        transform.append("\n");

        return true;
    }

    public String readFromFile(String fileName) {
        InputStream inputStream = null;
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            inputStream = new FileInputStream(fileName);
            byte [] bytes = new byte[1024];
            int length = 0;
            while((length = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes,0,length));
            }
        } catch (FileNotFoundException e) {
            System.out.println("从{}文件中读取内容失败{}"+ fileName + e);
            stringBuilder = new StringBuilder("");
        } catch (IOException e) {
            System.out.println("从{}文件中读取内容失败{}"+ fileName + e);
            stringBuilder = new StringBuilder("");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("从{}文件中读取内容失败{}"+ fileName + e);
                    stringBuilder = new StringBuilder("");
                }
            }
        }
        return stringBuilder.toString();
    }
    public boolean writeToFile(String fileName, String str) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName, true);
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            System.out.println(("将文本写入{}文件失败{}" + fileName + e));

            return false;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println(("将文本写入{}文件失败{}" + fileName + e));
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 读取所有的历史事件，并储存到csv文件中
     * @return 操作是否成功。true:操作成功。 false:操作失败
     */
    public boolean dealEventSpecific(Socket socket) {
        boolean result = false;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();


            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String csvName = "PMSFC_001_EventLog_" +df.format(date) + ".csv";
            String title = "序号,日期/时间,事件代码";
            result = createCSV(csvName, title);
            if (!result) {
                return false;
            }

            long id = 1;
            String position = "02ac";
            int flashTotal = queryValueByPosition(outputStream, inputStream, position);
            if (flashTotal == -1) {
                return false;
            }
            if (flashTotal > 800) { // 最大800页
                flashTotal = 800;
            }
            for (int i = 1; i <= flashTotal; i++) {
                String hex= Integer.toHexString(i);
                while(hex.length() < 4) {
                    hex = "0" + hex;
                }
                // 在当前查询Flash页面02ad寄存器中写入需要查询的Flash页面0001
                result = writeCommand("02ad", hex, outputStream, inputStream);
                if (!result) {
                    return false;
                }
                // 在控制字0000中写入日志查询命令0081
                result = writeCommand("0000", "0081", outputStream, inputStream);
                if (!result) {
                    return false;
                }

                try { // 经少量测试休眠不休眠一样的
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // log.info("线程休眠失败：{}", e.getMessage());
                    return false;
                }

                // 读取当前查询Flash页面中的全部数据
                result = queryOneFlashEvent(outputStream, inputStream, csvName, id);
                if (!result) {
                    return false;
                }

                id += 512;
            }
        } catch (Exception e) {
            // log.info("请求历史事件数据失败：{}", e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 根据csv文件名称创建csv文件，并写入表头字段。
     * @param csvName csv文件名称
     * @return 操作是否成功。true:操作成功。 false:操作失败
     */
    public boolean createCSV(String csvName, String title) {
        boolean result = false;
        // 新建csv文件时写入表头字段。
        byte[] bom = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        FileOutputStream csvFileOutputStream = null;
        try {
            csvFileOutputStream = new FileOutputStream(csvName);
            // 解决utf-8 导出到csv文件时出现乱码的问题
            csvFileOutputStream.write(bom);
            csvFileOutputStream.write(title.getBytes());
            csvFileOutputStream.write("\n".getBytes());
            csvFileOutputStream.flush();
        } catch (IOException e) {
            // log.error("创建csv文件失败:{}", e.getMessage());

            File file = new File(csvName);
            if (file.exists()) {
                file.delete();
            }
            return false;
        } finally {
            if (csvFileOutputStream != null) {
                try {
                    csvFileOutputStream.close();
                } catch (IOException e) {
                    // log.error("关闭csvFileOutputStream失败:{}", e.getMessage());

                    File file = new File(csvName);
                    if (file.exists()) {
                        file.delete();
                    }
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 向某一位寄存器中写入某值
     * @param position 寄存器地址
     * @param value 将要写入寄存器中的值
     * @param outputStream socket输出流
     * @param inputStream socket输入流
     * @return 操作是否成功。true:操作成功。 false:操作失败
     * @throws IOException
     */
    public boolean writeCommand(String position, String value, OutputStream outputStream, InputStream inputStream) throws IOException {
        boolean result = false;
        String ss = "0000000000000110" + position + "0001" + value;
        outputStream.write(hexToByteArray(ss));
        outputStream.flush();

        // 消息头部
        String requiredHead = "0000000000000110" + position + "0001";
        byte[] realHead = new byte[12];
        inputStream.read(realHead);
        String realHeadStr = bytesToHex(realHead, 12);
        // System.out.println("realHeadStr:=" + realHeadStr);
        if (!requiredHead.equals(realHeadStr)) {
            // // log.error("tcp返回数据不符合要求");
            return false;
        }
        return true;
    }

    /**
     * 查询当前储存flash页面
     * @param outputStream socket输出流
     * @param inputStream socket输入流
     * @return 当前储存flash页面。-1：操作失败。其他值：操作成功。
     * @throws IOException
     */
    public int queryValueByPosition(OutputStream outputStream, InputStream inputStream,String position) throws IOException {
        int result = -1;
        String ss = "0000000000000104" + position + "0001";
        outputStream.write(hexToByteArray(ss));
        outputStream.flush();

        // 消息头部
        String requiredHead = "0000000000000104";
        byte[] realHead = new byte[8];
        inputStream.read(realHead);
        String realHeadStr = bytesToHex(realHead, 8);
        // System.out.println("realHeadStr:=" + realHeadStr);
        if (!requiredHead.equals(realHeadStr)) {
            // log.error("tcp返回数据不符合要求");
            // continue;
            return result;
        }

        // 消息数据长度
        byte[] realDataLength = new byte[2];
        inputStream.read(realDataLength);
        int dataLength = readInt(realDataLength[0], realDataLength[1]);
        // System.out.println("dataLength:=" + dataLength);
        if (dataLength != 2) {
            // log.error("tcp返回数据不符合要求");
            // continue;
            return result;
        }

        // 读取当前储存flash页面(总的页面)
        byte[] flashTotalbytes = new byte[2];
        inputStream.read(flashTotalbytes);
        result = readInt(flashTotalbytes[0], flashTotalbytes[1]);
        // System.out.println("flashTotal:=" + flashTotal);
        return result;
    }

    /**
     * 查询当前flash页面的全部数据，并写入csv文件
     * @param outputStream socket输出流
     * @param inputStream socket输入流
     * @param csvName csv文件名称
     * @param id 写入csv文件的起始序号
     * @return 操作是否成功。true:操作成功。 false:操作失败
     * @throws IOException
     */
    public boolean queryOneFlashEvent(OutputStream outputStream, InputStream inputStream, String csvName, long id) throws IOException {
        boolean result = false;
        int[][] events = new int[2048][7];
        int length = 0;
        String command = "";

        // 从703开始，读取700个寄存器中的值，175条事件记录
        command = "000000000000010402bf02bc";
        outputStream.write(hexToByteArray(command));
        outputStream.flush();

        result = analysisEventPackage(inputStream, events, length);
        if (!result) {
            return false;
        }
        length += 175;

        // 从1403开始，读取700个寄存器中的值，175条事件记录
        command = "0000000000000104057b02bc";
        outputStream.write(hexToByteArray(command));
        outputStream.flush();

        result = analysisEventPackage(inputStream, events, length);
        if (!result) {
            return false;
        }
        length += 175;

        // 从2103开始，读取648个寄存器中的值，175条事件记录
        command = "000000000000010408370288";
        outputStream.write(hexToByteArray(command));
        outputStream.flush();

        result = analysisEventPackage(inputStream, events, length);
        if (!result) {
            return false;
        }

        FileOutputStream csvFileOutputStream = null;
        try {
            csvFileOutputStream = new FileOutputStream(csvName, true);
            for (int i = 0; i < 512; i++) {
                String.format("%02d", events[i][0]);
                String dateTime = "20" + String.format("%02d", events[i][0])
                        + "-" + String.format("%02d", events[i][1]) + "-" + String.format("%02d", events[i][2])
                        + " " + String.format("%02d", events[i][3]) + ":" + String.format("%02d", events[i][4])
                        + ":" + String.format("%02d", events[i][5]);
                String faultCode = ""  + events[i][6];
                String aRecord = (id + i) + "," + dateTime + "," + faultCode + "\n";
                csvFileOutputStream.write(aRecord.getBytes());
            }
            csvFileOutputStream.flush();
        } catch (IOException e) {
            // log.error("将数据写入csv文件失败：{}", e.getMessage());
            return false;
        } finally {
            if (csvFileOutputStream != null) {
                try {
                    csvFileOutputStream.close();
                } catch (IOException e) {
                    // log.error("关闭csvFileOutputStream失败：{}", e.getMessage());
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 解析返回的包含故障数据的tcp包
     * @param inputStream tcp返回的流数据
     * @return 操作是否成功。true:操作成功。 false:操作失败
     * @throws IOException
     */
    public boolean analysisFaultPackage(InputStream inputStream, int[] faults) throws IOException {
        boolean result = false;
        // 消息头部
        String requiredHead = "0000000000000104";
        byte[] realHead = new byte[8];
        inputStream.read(realHead);
        String realHeadStr = bytesToHex(realHead, 8);
        if (!requiredHead.equals(realHeadStr)) {
            System.out.println(("tcp返回的历史故障数据不符合要求"));
            return false;
        }

        // 消息数据长度
        byte[] realDataLength = new byte[2];
        inputStream.read(realDataLength);
        int dataLength = readInt(realDataLength[0], realDataLength[1]);
        if (dataLength != 212) {
            System.out.println(("tcp返回的历史故障数据不符合要求"));
            // continue;
            return false;
        }
        // 故障数据:
        // 共计106个寄存器
        int number = dataLength / 2;
        byte[] faultBytes = new byte[dataLength];
        inputStream.read(faultBytes);
        for (int i = 0, j = 0; i < dataLength; i += 2, j++) {
            faults[j] = readInt(faultBytes[i], faultBytes[i + 1]);
        }
        return true;
    }


    /**
     * 解析返回的包含事件数据的tcp包
     * @param inputStream tcp返回的流数据
     * @return 操作是否成功。true:操作成功。 false:操作失败
     * @throws IOException
     */
    public boolean analysisEventPackage(InputStream inputStream, int[][] events, int begin) throws IOException {
        boolean result = false;
        // 消息头部
        String requiredHead = "0000000000000104";
        byte[] realHead = new byte[8];
        inputStream.read(realHead);
        String realHeadStr = bytesToHex(realHead, 8);
        // System.out.println("realHeadStr:=" + realHeadStr);
        if (!requiredHead.equals(realHeadStr)) {
            // log.error("tcp返回数据不符合要求");
            // continue;
            return false;
        }

        // 消息数据长度
        byte[] realDataLength = new byte[2];
        inputStream.read(realDataLength);
        int dataLength = readInt(realDataLength[0], realDataLength[1]);
        // System.out.println("dataLength:=" + dataLength);

        // 事件记录条数:
        // 每8位byte表示一条事件
        // 时间日期6个byte和故障码2个byte
        // 年，月，日，时，分，秒，故障码。
        int number = dataLength / 8;
        byte[] eventBytes = new byte[dataLength];
        inputStream.read(eventBytes);
        for (int i = begin, j = 0; i < number + begin; i++, j += 8) {
            events[i][0] = eventBytes[j] & 0xff;
            events[i][1] = eventBytes[j + 1] & 0xff;
            events[i][2] = eventBytes[j + 2] & 0xff;
            events[i][3] = eventBytes[j + 3] & 0xff;
            events[i][4] = eventBytes[j + 4] & 0xff;
            events[i][5] = eventBytes[j + 5] & 0xff;
            events[i][6] = readInt(eventBytes[j + 6], eventBytes[j + 7]);
        }
        return true;
    }

    /**
     * hex字符串转byte数组
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte数组结果
     */
    public byte[] hexToByteArray(String inHex){
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1){ // 奇数
            hexlen++;
            result = new byte[(hexlen/2)];
            inHex ="0" + inHex;
        }else { // 偶数
            result = new byte[(hexlen/2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2){
            result[j]=hexToByte(inHex.substring(i, i+2));
            j++;
        }
        return result;
    }

    /**
     * 两位16进制，转化为一位byte
     * Hex字符串转byte
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte
     */
    public byte hexToByte(String inHex){
        return (byte)Integer.parseInt(inHex, 16);
    }

    /**
     * 字节数组转16进制
     * @param bytes 需要转换的byte数组
     * @return  转换后的Hex字符串
     */
    public String bytesToHex(byte[] bytes, int length) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * 两位byte表示的16进制,转化为10进制
     * @param prefix 从左向右数的第1位byte
     * @param suffix 从左向右数的第2位byte
     * @return
     */
    public int readInt(byte prefix, byte suffix) {
        return (0xff00 & (prefix << 8)) | (0xff & suffix);
    }
}


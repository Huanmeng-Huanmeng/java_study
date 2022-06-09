package com.study.doc.xlsx;

import com.study.doc.xlsx.entity.CmsFaultFrequencyTest;
import com.study.doc.xlsx.entity.PointMappingTest;
import com.study.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReadXlsx {
    public static void main(String[] args) {
        try {
            //String fileName = "E:\\StudySpace\\Project\\Hello-Parent\\doc\\xlsx\\bearingmain.xlsx";
            //String type = "主轴承";
            //readXlsx(type, fileName);

            String fileName = "E:\\StudySpace\\Project\\Hello-Parent\\doc\\xlsx\\WQHJFC对应关系.xlsx";
            readPointMappingXlsx(fileName);
        } catch (IOException e) {
            log.error("excel导出失败");
        }

    }
    public static R readXlsx(String type, String fileName) throws IOException{
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
             log.error("msg", "上传文件格式不正确!");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = new FileInputStream(fileName);
        Workbook workbook = null;
        BaseFormulaEvaluator evaluator = null;
        if (isExcel2003) {
            workbook = new HSSFWorkbook(is);
            evaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook); // 获取excel单元格中表达式的值，而非表达式
        } else {
            workbook = new XSSFWorkbook(is);
            evaluator = new XSSFFormulaEvaluator((XSSFWorkbook)workbook);
        }


        List<CmsFaultFrequencyTest> cmsFaultFrequencyTests = new ArrayList<>();
        R r = readSheet(type, workbook, evaluator, cmsFaultFrequencyTests);
        if (200 != (Integer) r.get("code")) {
            return r;
        }
        return r;
    }

    public static R readSheet(String type, Workbook workbook, BaseFormulaEvaluator evaluator, List<CmsFaultFrequencyTest> cmsFaultFrequencyTests) {
        //获取excel sheet数量
        int numberOfSheets = workbook.getNumberOfSheets();
        int i = 0;
        DataFormatter formatter = new DataFormatter();
        for (i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet == null) {
                return R.error().put("msg", "该上传文件的第（" + (i + 1) + "）个sheet为空！");
            }
            String sheetName = sheet.getSheetName(); //sheet名称，用于校验模板是否正确
            int lastRowNum = sheet.getLastRowNum();
            for (int j = 0; j < lastRowNum; j++) {
                Row row = sheet.getRow(j);
                if (row != null) {
                    String stringCellValue = formatter.formatCellValue(row.getCell(0));
                    if ((stringCellValue != null) && ("输出数据库".equals(stringCellValue.trim()))) {
                        String manufactorValue; // 厂家
                        String modelValue; // 型号
                        int k = j + 2;
                        Row manufactorRow = sheet.getRow(k);
                        if (manufactorRow == null) {
                            return R.error().put("msg", "部件对应的厂家不能为空!");
                        }
                        String manufactor = formatter.formatCellValue(manufactorRow.getCell(0));
                        if (manufactor == null || !"厂家".equals(manufactor.trim())) {
                            return R.error().put("msg", "部件对应的厂家不能为空!");
                        }

                        Cell manufactorRowCell = manufactorRow.getCell(1);
                        if (manufactorRowCell != null && CellType.FORMULA.equals(manufactorRowCell.getCellType())) {
                            CellValue tempCellValue = evaluator.evaluate(manufactorRowCell);
                            if (tempCellValue == null) {
                                return R.error().put("msg", "部件对应的厂家不能为空!");
                            }
                            manufactorValue = tempCellValue.getStringValue();
                        } else {
                            manufactorValue = formatter.formatCellValue(manufactorRowCell);
                        }
                        if (manufactorValue == null || "".equals(manufactorValue.trim())) {
                            return R.error().put("msg", "部件对应的厂家不能为空!");
                        }

                        k = k + 1;
                        Row modelRow = sheet.getRow(k);
                        if (modelRow == null) {
                            return R.error().put("msg", "部件对应的型号不能为空!");
                        }
                        String model = formatter.formatCellValue(modelRow.getCell(0));
                        if (model == null || !"型号".equals(model.trim())) {
                            return R.error().put("msg", "部件对应的型号不能为空!");
                        }

                        Cell modelRowCell = modelRow.getCell(1);
                        if (modelRowCell != null && CellType.FORMULA.equals(manufactorRowCell.getCellType())) {
                            CellValue tempCellValue = evaluator.evaluate(modelRowCell);
                            if (tempCellValue == null) {
                                return R.error().put("msg", "部件对应的厂家不能为空!");
                            }
                            modelValue = tempCellValue.getStringValue();
                        } else {
                            modelValue = formatter.formatCellValue(modelRowCell);
                        }
                        if (modelValue == null || "".equals(modelValue.trim())) {
                            return R.error().put("msg", "部件对应的型号不能为空!");
                        }

                        k = k + 1;
                        Row titleRow = sheet.getRow(k);
                        if (titleRow == null) {
                            return R.error().put("msg", "部件对应的名称和频率不能为空!");
                        }
                        String typeName = formatter.formatCellValue(titleRow.getCell(0));
                        if (typeName == null || !"名称".equals(typeName.trim())) {
                            return R.error().put("msg", "名称不存在!");
                        }
                        String frequencyName = formatter.formatCellValue(titleRow.getCell(1));
                        if (frequencyName == null || !"频率".equals(frequencyName.trim())) {
                            return R.error().put("msg", "频率不存在!");
                        }
                        k = k + 1;
                        boolean flag = true;
                        while(flag) {
                            Row valueRow = sheet.getRow(k);
                            if (valueRow == null) {
                                flag = false;
                                break;
                            } else {
                                CmsFaultFrequencyTest cmsFaultFrequencyTest = new CmsFaultFrequencyTest();
                                cmsFaultFrequencyTest.setPartAscription(type);
                                cmsFaultFrequencyTest.setPartAttributeName(manufactorValue + modelValue);

                                Cell typeValueCell = valueRow.getCell(0);
                                String typeValue;
                                if (typeValueCell != null && CellType.FORMULA.equals(typeValueCell.getCellType())) {
                                    CellValue tempCellValue = evaluator.evaluate(typeValueCell);
                                    if (tempCellValue == null) {
                                        flag = false;
                                        break;
                                        //return R.error().put("msg", "名称不能为空!");
                                    }
                                    typeValue = tempCellValue.getStringValue();
                                } else {
                                    typeValue = formatter.formatCellValue(typeValueCell);
                                }
                                if (typeValue == null || "".equals(typeValue.trim())) {
                                    flag = false;
                                    break;
                                }
                                cmsFaultFrequencyTest.setFaultType(typeValue);

                                Cell frequencyValueCell = valueRow.getCell(1);
                                String frequencyValue;
                                if (typeValueCell != null && CellType.FORMULA.equals(frequencyValueCell.getCellType())) {
                                    CellValue tempCellValue = evaluator.evaluate(frequencyValueCell);
                                    if (tempCellValue == null) {
                                        return R.error().put("msg", "频率不能为空!");
                                    }
                                    double numberValue = tempCellValue.getNumberValue();
                                    cmsFaultFrequencyTest.setFaultFrequency((float) numberValue);
                                    cmsFaultFrequencyTests.add(cmsFaultFrequencyTest);
                                } else {
                                    frequencyValue = formatter.formatCellValue(frequencyValueCell);
                                    if (frequencyValue == null || "".equals(frequencyValue.trim())) {
                                        return R.error().put("msg", "频率不存在!");
                                    }
                                    if (!"/".equals(frequencyValue.trim())) {
                                        try {
                                            float frequencyValueFloat = Float.parseFloat(frequencyValue);
                                            cmsFaultFrequencyTest.setFaultFrequency(frequencyValueFloat);
                                            cmsFaultFrequencyTests.add(cmsFaultFrequencyTest);
                                        } catch (Exception e) {
                                            log.error("频率转化为float类型失败!");
                                            return R.error().put("msg", "频率转化为float类型失败");
                                        }
                                    }
                                }
                            }
                            k = k + 1;
                        }

                    }
                }
            }
        }
        return R.ok().put("msg", "故障频率excel导入成功!");
    }

    public static R readPointMappingXlsx(String fileName) throws IOException {
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            log.error("msg", "上传文件格式不正确!");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = new FileInputStream(fileName);
        Workbook workbook = null;
        BaseFormulaEvaluator evaluator = null;
        if (isExcel2003) {
            workbook = new HSSFWorkbook(is);
            evaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook); // 获取excel单元格中表达式的值，而非表达式
        } else {
            workbook = new XSSFWorkbook(is);
            evaluator = new XSSFFormulaEvaluator((XSSFWorkbook)workbook);
        }


        List<PointMappingTest> pointMappingTests = new ArrayList<>();
        R r = readPointMappingSheet(workbook, evaluator, pointMappingTests);
        if (200 != (Integer) r.get("code")) {
            return r;
        }
        return r;
    }

    public static R readPointMappingSheet(Workbook workbook, BaseFormulaEvaluator evaluator, List<PointMappingTest> pointMappingTests) {

        // 第一个sheet页不为空
        Sheet sheet = workbook.getSheetAt(0);
        if (sheet == null) {
            return R.error().put("msg", "该上传的测点excel文件的第（" + 1 + "）个sheet为空！");
        }

        // 第一个sheet页的第1行（也就是标题行）必须为4列
        Row titleRow = sheet.getRow(0);
        if (titleRow != null) {
            int coloumNum = titleRow.getLastCellNum();//获得总列数
            if (coloumNum != 4) {
                return R.error().put("msg", "该上传的测点excel文件的sheet页,总列数不对,应为【4】列,请根据模板导入数据！");
            }
        }

        DataFormatter formatter = new DataFormatter();
        // 第2行的风机拼音码和机位号必须存在
        Row row1 = sheet.getRow(1);
        if (row1 == null) {
            return R.error().put("msg", "该上传的测点excel文件的sheet页,第2行的信息不存在！");
        }
        String pinyinCode = formatter.formatCellValue(row1.getCell(0));
        if (pinyinCode == null || pinyinCode.trim().isEmpty()) {
            return R.error().put("msg", "第2行的风机拼音码不能为空!");
        }
        String turbineName = formatter.formatCellValue(row1.getCell(1));
        if (turbineName == null || turbineName.trim().isEmpty()) {
            return R.error().put("msg", "第2行的风机机位号不能为空!");
        }
        String originalPointName = formatter.formatCellValue(row1.getCell(2));
        if (originalPointName == null || originalPointName.trim().isEmpty()) {
            return R.error().put("msg", "第2行的原测点名称不能为空!");
        }
        String targetPointName = formatter.formatCellValue(row1.getCell(3));
        if (targetPointName == null || targetPointName.trim().isEmpty()) {
            return R.error().put("msg", "第2行的目标测点名称不能为空!");
        }
        PointMappingTest pointMappingTest = new PointMappingTest();
        pointMappingTest.setPinyinCode(pinyinCode);
        pointMappingTest.setTurbineName(turbineName);
        pointMappingTest.setOriginalPointName(originalPointName);
        pointMappingTest.setTargetPointName(targetPointName);
        log.debug("将测点对象【{}】加入数组中", pointMappingTest.toString());
        pointMappingTests.add(pointMappingTest);

        int lastRowNum = sheet.getLastRowNum();
        log.info("该上传的测点excel文件的sheet页的总行数为【{}】", lastRowNum + 1);
        //从第3行 开始 遍历每行
        for (int i = 2; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            pointMappingTest = new PointMappingTest();
            originalPointName = null;
            targetPointName = null;

            String pinyinCodeTemp = formatter.formatCellValue(row.getCell(0));
            if (pinyinCodeTemp != null && !pinyinCodeTemp.trim().isEmpty()) {
                pinyinCode = pinyinCodeTemp;
            }
            String turbineNameTemp = formatter.formatCellValue(row.getCell(1));
            if (turbineNameTemp != null && !turbineNameTemp.trim().isEmpty()) {
                turbineName = turbineNameTemp;
            }
            originalPointName = formatter.formatCellValue(row.getCell(2));
            if (originalPointName == null || originalPointName.trim().isEmpty()) {
                break;
                //return R.error().put("msg", "第" + (i + 1) + "行的原测点名称不能为空!");
            }
            targetPointName = formatter.formatCellValue(row.getCell(3));
            if (targetPointName == null || targetPointName.trim().isEmpty()) {
                return R.error().put("msg", "第" + (i + 1) + "行的目标测点名称不能为空!");
            }

            pointMappingTest.setPinyinCode(pinyinCode);
            pointMappingTest.setTurbineName(turbineName);
            pointMappingTest.setOriginalPointName(originalPointName);
            pointMappingTest.setTargetPointName(targetPointName);
            log.debug("将测点对象【{}】加入数组中", pointMappingTest.toString());
            pointMappingTests.add(pointMappingTest);
        }
        log.debug("该测点excel文件共解析出测点个数为【{}】", pointMappingTests.size());
        return R.ok().put("msg", "测点excel导入成功!");
    }
}

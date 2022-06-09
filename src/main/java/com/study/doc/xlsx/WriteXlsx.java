package com.study.doc.xlsx;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.study.doc.xlsx.entity.PointMappingTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class WriteXlsx {
    public static void main(String[] args) {
        testEasyPoi();
    }

    public static void testEasyPoi() {
        File file = new File("doc/xlsx/point_mapping.xlsx");

        //处理导出excel
        TemplateExportParams params = new TemplateExportParams();
        params.setScanAllsheet(true);//多模板
        params.setHeadingStartRow(0);// 标题开始行
        params.setHeadingRows(2);// 标题行数
        params.setTempParams("t");
        params.setTemplateUrl(file.getAbsolutePath());

        Map<String, Object> data = new HashMap<>();
        List<PointMappingTest> pointMappingTestList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            PointMappingTest pointMappingTest = new PointMappingTest();
            pointMappingTest.setTargetPointName("目标测点" + i);
            pointMappingTestList.add(pointMappingTest);
        }

        data.put("targetlist", pointMappingTestList);
        Workbook workbook = ExcelExportUtil.exportExcel(params, data);

        //下载
        String fileName = "doc/xlsx/out/WriteXlsx.xlsx";
        OutputStream outputStream = null;
        try{
            File file1 = new File(fileName);
            if (file1.exists()) {
                file1.delete();
            }
            File parentFile = file1.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file1.createNewFile();
            outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            log.error("文件【{}】不存在。", fileName);
            return ;
        } catch (IOException e) {
            log.error("写入文件【{}】失败。", fileName);
            return ;
        } finally{
            try {
                workbook.close();
            } catch (IOException e) {
                log.error("关闭【{}】失败。", workbook);
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                log.error("关闭【{}】失败。", outputStream);
            }
        }
        log.info("写入完成");
    }
}

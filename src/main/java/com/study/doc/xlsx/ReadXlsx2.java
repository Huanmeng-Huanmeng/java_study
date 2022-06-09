package com.study.doc.xlsx;

import com.alibaba.fastjson.JSONObject;
import com.study.doc.xlsx.entity.Column;
import com.study.doc.xlsx.entity.ColumnComment;
import com.study.doc.xlsx.entity.Table;
import com.study.utils.FileUtils;
import com.study.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class ReadXlsx2 {

    private static String tableSchema = "mdmdev131";

    private static boolean isRecord = true;

    private static String recordFileName = "data/out/alterTableColumns.txt";

    private static String recordTable = "data/out/alterTable.txt";


    public static void main(String[] args) {
        try {
            String fileName = "doc\\xlsx\\TableColumn.xlsx";
            R r = readTableColumnXlsx(fileName);
            log.info("{}", r.get("msg"));
        } catch (IOException e) {
            log.error("excel导出失败");
        }

    }

    public static R readTableColumnXlsx(String fileName) throws IOException{
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

        R r = readSheet(workbook, evaluator);
        if (200 != (Integer) r.get("code")) {
            return r;
        }

        List<Table> tableList = (List<Table>) r.get("tableList");

        for (Table table: tableList) {
            String sql = "alter table " + tableSchema + "." + table.getTableName()
                    + " COMMENT '" + table.getTableComment() + "';\n";
            log.info("更改表字段备注信息的sql语句为：【{}】", sql);

            if (isRecord) {
                boolean flag = FileUtils.writeToFileIfNotExist(recordTable, sql, true);
                if (!flag) {
                    log.error("更改表备注信息的sql语句存放到文件过程出现错误，操作失败");
                }
            }
        }

        List<Column> columnList = (List<Column>) r.get("columnList");

        for (Column column: columnList) {
            String sql = "alter table " + tableSchema + "." + column.getTableName() + " modify column "
                    + column.getColumnName() + " " + column.getColumnType() + " COMMENT '" + column.getColumnComment() + "';\n";
            log.info("更改表字段备注信息的sql语句为：【{}】", sql);

            if (isRecord) {
                boolean flag = FileUtils.writeToFileIfNotExist(recordFileName, sql, true);
                if (!flag) {
                    log.error("更改表字段备注信息的sql语句存放到文件过程出现错误，操作失败");
                }
            }
        }
        return r;
    }

    public static R readSheet(Workbook workbook, BaseFormulaEvaluator evaluator) {
        List<Table> tableList = new ArrayList<>(54);
        List<Column> columnList = new ArrayList<>(54);
        Set<String> tableSet = new HashSet<>(54);


        // 第一个sheet页不为空
        Sheet sheet = workbook.getSheetAt(0);
        if (sheet == null) {
            return R.error().put("msg", "该上传的表字段excel文件的第（" + 1 + "）个sheet为空！");
        }

        // 第一个sheet页的第1行（也就是标题行）必须为9列
        Row titleRow = sheet.getRow(0);
        if (titleRow != null) {
            int coloumNum = titleRow.getLastCellNum();//获得总列数
            if (coloumNum != 9) {
                return R.error().put("msg", "该上传的表字段点excel文件的sheet页,总列数不对,应为【9】列,请根据模板导入数据！");
            }
        }

        DataFormatter formatter = new DataFormatter();

        int lastRowNum = sheet.getLastRowNum();
        log.info("该上传的表字段excel文件的sheet页的总行数为【{}】", lastRowNum + 1);
        //从第3行 开始 遍历每行
        for (int i = 2; i <= lastRowNum; i++) {

            // 第i行的表、表注释、字段、字段的数据类型、字段名称、维护人必须存在
            Row row1 = sheet.getRow(i);
            if (row1 == null) {
                continue;
            }

            // 1.表
            String tableName = formatter.formatCellValue(row1.getCell(0));
            if (tableName == null || tableName.trim().isEmpty()) {
                return R.error().put("msg", "第" + (i + 1) + "行的表不能为空!");
            }

            // 2.表注释不解析
            String tableComment = formatter.formatCellValue(row1.getCell(1));
            if (tableComment == null || tableComment.trim().isEmpty()) {
                return R.error().put("msg", "第" + (i + 1) + "行的表注释不能为空!");
            }

            // 3.字段
            String columnName = formatter.formatCellValue(row1.getCell(2));
            if (columnName == null || columnName.trim().isEmpty()) {
                return R.error().put("msg", "第" + (i + 1) + "行的字段不能为空!");
            }

            // 4.字段的数据类型
            String columnType = formatter.formatCellValue(row1.getCell(3));
            if (columnType == null || columnType.trim().isEmpty()) {
                return R.error().put("msg", "第" + (i + 1) + "行的字段的数据类型不能为空!");
            }

            // 5.字段名称
            String fieldDescription = formatter.formatCellValue(row1.getCell(4));
            if (fieldDescription == null || fieldDescription.trim().isEmpty()) {
                return R.error().put("msg", "第" + (i + 1) + "行的字段名称不能为空!");
            }

            // 6.维护人
            String maintainer = formatter.formatCellValue(row1.getCell(5));
            if (maintainer == null || maintainer.trim().isEmpty()) {
                //return R.error().put("msg", "第" + (i + 1) + "行的维护人不能为空!");
                maintainer = "";
            }

            // 7.使用对象
            String useObject = formatter.formatCellValue(row1.getCell(6));
            if (useObject == null || useObject.trim().isEmpty()) {
                useObject = "";
            }

            // 8.上一次修改人
            String updateBy = formatter.formatCellValue(row1.getCell(6));
            if (updateBy == null || updateBy.trim().isEmpty()) {
                updateBy = "";
            }

            // 9.上一次时间
            String updatedTime = formatter.formatCellValue(row1.getCell(6));
            if (updatedTime == null || updatedTime.trim().isEmpty()) {
                updatedTime = "";
            }

            // 表和表注释
            String tableStrTemp = tableName + "_" + tableComment;
            if (!tableSet.contains(tableStrTemp)) {
                Table table = new Table();
                table.setTableSchema(tableSchema);
                table.setTableName(tableName);
                table.setTableComment(tableComment);

                tableSet.add(tableStrTemp);
                tableList.add(table);
            }


            // 字段注释
            ColumnComment columnComment = new ColumnComment();
            columnComment.setFieldDescription(fieldDescription);
            columnComment.setMaintainer(maintainer);
            columnComment.setUseObject(useObject);
            columnComment.setUpdateBy(updateBy);
            columnComment.setUpdatedTime(updatedTime);
            String columnCommentStr = JSONObject.toJSONString(columnComment);

            // 两种方式均可
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fieldDescription", columnComment.getFieldDescription());
            jsonObject.put("maintainer", columnComment.getMaintainer());
            jsonObject.put("useObject", columnComment.getUseObject());
            jsonObject.put("updateBy", columnComment.getUpdateBy());
            jsonObject.put("updatedTime", columnComment.getUpdatedTime());
            String columnCommentStr2 = jsonObject.toJSONString();


            // 表字段
            Column column = new Column();
            column.setTableSchema(tableSchema);
            column.setTableName(tableName);
            column.setColumnName(columnName);
            column.setColumnType(columnType);
            column.setColumnComment(columnCommentStr);
            columnList.add(column);
        }
        log.debug("该表字段excel文件共解析出表个数为【{}】", tableList.size());
        log.debug("该表字段excel文件共解析出字段个数为【{}】", columnList.size());
        return R.ok().put("msg", "表字段excel导入成功!").put("columnList", columnList).put("tableList", tableList);
    }


}

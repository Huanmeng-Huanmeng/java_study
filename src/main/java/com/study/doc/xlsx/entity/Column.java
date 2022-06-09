package com.study.doc.xlsx.entity;

public class Column {
    private String tableSchema;
    private String tableName;
    private String columnName;
    private String columnComment;
    private String columnType;

    // 字段描述
    private String fieldDescription;

    // 维护人
    private String maintainer;

    // 使用对象
    private String useObject;

    // 上一次修改人
    private String updateBy;

    // 上一次时间
    private String updatedTime;

    public Column() {
    }

    public Column(String tableSchema, String tableName, String columnName, String columnComment, String columnType, String fieldDescription, String maintainer, String useObject, String updateBy, String updatedTime) {
        this.tableSchema = tableSchema;
        this.tableName = tableName;
        this.columnName = columnName;
        this.columnComment = columnComment;
        this.columnType = columnType;
        this.fieldDescription = fieldDescription;
        this.maintainer = maintainer;
        this.useObject = useObject;
        this.updateBy = updateBy;
        this.updatedTime = updatedTime;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getUseObject() {
        return useObject;
    }

    public void setUseObject(String useObject) {
        this.useObject = useObject;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Column{" +
                "tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", columnType='" + columnType + '\'' +
                ", fieldDescription='" + fieldDescription + '\'' +
                ", maintainer='" + maintainer + '\'' +
                ", useObject='" + useObject + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updatedTime='" + updatedTime + '\'' +
                '}';
    }
}

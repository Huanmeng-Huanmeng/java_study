package com.study.doc.xlsx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Table {
    private String tableSchema;
    private String tableName;
    private String tableType;
    private String tableComment;

}

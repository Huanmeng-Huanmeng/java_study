package com.study.doc.xlsx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ColumnComment implements Serializable {
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

    private static final long serialVersionUID = 1L;
}

package com.study.doc.csv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Entity {
    private String wf_pinyin_code;
    private String wf_farm_name;
    private String t_inner_turbine_name;
    private String part_id;
    private String part_type;
    private String part_name;
    private String part_code;
    private String part_brand;
}

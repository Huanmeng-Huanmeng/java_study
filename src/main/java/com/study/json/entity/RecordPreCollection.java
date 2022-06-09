package com.study.json.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecordPreCollection {
    private String farm_code;
    private String turbine_code;
    private Integer preFlashNumber;
    private Integer preFaultNumber;

}

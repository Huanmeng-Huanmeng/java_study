package com.study.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.json.entity.RecordPreCollection;
import com.study.utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteToJson {
    public static void main(String[] args) {
        readFromJson("123");
    }

    public static void readFromJson(String fileName) {
        Map<String, RecordPreCollection> recordPreCollectionMap = new HashMap<>();
        fileName = "data/json/recordPreCollection.json";
        String jsonText = FileUtils.readFromFile(fileName);
        List<RecordPreCollection> recordPreCollections = JSONObject.parseArray(jsonText, RecordPreCollection.class);
        int length = recordPreCollections.size();
        for (int i = 0; i < length; i++) {
            RecordPreCollection recordPreCollection = recordPreCollections.get(i);
            String farm_code = recordPreCollection.getFarm_code();
            String turbine_code = recordPreCollection.getTurbine_code();
            String key = farm_code + "_" + turbine_code;
            recordPreCollectionMap.put(key, recordPreCollection);
        }
        RecordPreCollection pmsfc_001 = recordPreCollectionMap.get("PMSFC_001");
        int preFlashNumber = pmsfc_001.getPreFlashNumber();



        pmsfc_001.setPreFlashNumber(preFlashNumber);
        String jsonString = JSON.toJSONString(recordPreCollections);
        FileUtils.writeToFile(fileName, jsonString, false);
    }
}

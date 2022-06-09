package com.study.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.utils.FileUtils;
import com.study.doc.xml.FaultCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadJsonFromFile {
    public static void main(String[] args) {
        Map<String, Map<String, FaultCode>> deviceMap = new HashMap<>();
        String fileName = "data/json/recordPreCollection.json";
        String jsonText = FileUtils.readFromFile(fileName);
        JSONArray jsonArray = (JSONArray) JSONObject.parse(jsonText);
        int length = jsonArray.size();
        for (int i = 0; i < length; i++) {
            Map<String, Object> map = (Map<String, Object>) jsonArray.get(i);
            String name = (String) map.get("type_name");
            JSONArray jsonArray1 = (JSONArray) map.get("point");
            Map<String, FaultCode> faultMap = new HashMap<>(200);
            List<FaultCode> faultCodes = JSONObject.parseArray(jsonArray1.toJSONString(), FaultCode.class);
            for (FaultCode faultCode: faultCodes) {
                faultMap.put(faultCode.getCode(), faultCode);
            }
            deviceMap.put(name, faultMap);
        }
        System.out.println(deviceMap);

    }
}

package com.study.doc.csv;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

@Slf4j
public class ReadCsv {
    public static void main(String[] args) {
        String fileName = "csv/腾讯云DMC_数据导出_1647416555667.csv";

        FileReader fr= null;
        BufferedReader br = null;
        String line = "";
        String[] arrs = null;
        List<Entity> entities = new ArrayList<>();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            while ((line=br.readLine()) != null) {
                arrs = line.split(",");
                Entity entity = new Entity(arrs[0], arrs[1], arrs[2], arrs[3], arrs[4], arrs[5], arrs[6], arrs[7]);
                entities.add(entity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> stringSet = new HashSet<>();
        for (Entity example: entities) {
            String wf_farm_name = example.getWf_farm_name();
            if (wf_farm_name.startsWith("\"")) {
                wf_farm_name = wf_farm_name.substring(1);
            }
            if (wf_farm_name.endsWith("\"")) {
                wf_farm_name = wf_farm_name.substring(0, wf_farm_name.length() - 1);
            }
            stringSet.add(wf_farm_name);
        }

        System.out.println(stringSet.toString());
    }
}

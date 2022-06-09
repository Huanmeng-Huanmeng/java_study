package com.study.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PostDemo {
    public static void main(String[] args) {
        postTest2();
        // success = (boolean) JSONObject.parseObject(result).get("success");
    }

    public static void postTest() {
        String url = "http://sany-heavy-energy-as.bdn-saas-iot-qa.rootcloudapp.com/api/baseData/faultCode/add";
        //json参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brakeNumber","测试刹车号");
        jsonObject.put("code","测试故障码");
        jsonObject.put("modelPlatform","测试机型平台");
        jsonObject.put("name","测试故障名称");
        jsonObject.put("type","测试类型");
        // 获取返回信息
        boolean success = false;
        String message = "";
        String data = "";
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = "";
        try{
            //创建http请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("app_token", "6c80ff93c2be4147996c20b2db5a6e5a");
            httpPost.addHeader("current_tenant", "3YSPA08");
            httpPost.addHeader("current_app", "A0001");
            StringEntity entity = new StringEntity(jsonObject.toJSONString(), "utf-8");
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "utf-8");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(response != null){
                try {
                    response.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            if(httpClient != null){
                try{
                    httpClient.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void postTest2() {
        String url = "http://10.162.4.40:8083/faultAnalysis/download_last_version";
        //String url = "http://localhost:8083/faultAnalysis/download_last_version";
        //json参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("downloadUsername","liql19");
        jsonObject.put("password","Huanmeng6374@");
//        jsonObject.put("downloadUsername","75e847a159deeba3");
//        jsonObject.put("password","4a7af9e28c1ea91c90261e453069e03c");
        // 获取返回信息
        boolean success = false;
        String message = "";
        String data = "";
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = "";
        try{
            //创建http请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("Accept-Encoding", "identity");
            StringEntity entity = new StringEntity(jsonObject.toJSONString(), "utf-8");
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(response != null){
                try {
                    response.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            if(httpClient != null){
                try{
                    httpClient.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }
}

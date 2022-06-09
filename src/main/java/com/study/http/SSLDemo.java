package com.study.http;

import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class SSLDemo {
    private final static String PFX_PATH = "data/user.p12";    //客户端证书路径
    private final static String PFX_PWD = "sany666";    //客户端证书密码
    public static void main(String[] args) throws Exception {
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 100; i++) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            testFaultAnalysis();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
            Thread.sleep(10000);
        }

    }

    public static void testClientDownload()  throws Exception {
        //String url = "http://10.0.2.40:8434/client/version";
        String url = "https://plcup.sanywind.net/client/download"; //接口地址
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("pinyinCode", "NKJGFC");
        jsonObject.put("pinyinCode", "NKJGFC");
        jsonObject.put("programVersion", "V1.0.0.1");
        jsonObject.put("downloadSource", "client");
        jsonObject.put("downloadUsername", "liql19");
        jsonObject.put("password", "69trNGS#");
        System.out.println(url);
        System.out.println(jsonObject.toString());
        String result = sslRequestGet(url, jsonObject);
        System.out.println(result);
    }

    public static void testFaultAnalysis()  throws Exception {
        //String url = "https://faultanalysis.sanywind.net/faultAnalysis/download_last_version"; //接口地址
        String url = "https://faultanalysis.sanywind.net/faultAnalysis/get_last_version"; //接口地址
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("downloadUsername", "75e847a159deeba3");
        jsonObject.put("password", "4a7af9e28c1ea91c90261e453069e03c");
//        System.out.println(url);
//        System.out.println(jsonObject.toString());
        //String result = sslRequestPost(url, jsonObject);
        //System.out.println(result);


        Map<String, Object> form = new HashMap<>();
        form.put("downloadUsername", "liql19");
        form.put("password", "Huanmeng6374@");
        sslRequestPost2(url, jsonObject);

    }

    public static String sslRequestGet(String url, JSONObject params) throws Exception {
        String returnValue = null;
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        InputStream instream = new FileInputStream(new File(PFX_PATH));
        try {
            keyStore.load(instream, PFX_PWD.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, PFX_PWD.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext
                , new String[]{"TLSv1"}    // supportedProtocols ,这里可以按需要设置
                , null    // supportedCipherSuites
                , SSLConnectionSocketFactory.getDefaultHostnameVerifier());

        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        //CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {

            httpPost.addHeader("Content-Type", "application/json");
            StringEntity entity = new StringEntity(params.toJSONString());
            httpPost.setEntity(entity);
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpPost);

            if (null != closeableHttpResponse && !"".equals(closeableHttpResponse)) {
                System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
                if (closeableHttpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity httpEntity = closeableHttpResponse.getEntity();
                    returnValue = EntityUtils.toString(httpEntity);
                } else {
                    returnValue = "Error Response" + closeableHttpResponse.getStatusLine().getStatusCode();
                }
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            returnValue = "timeout";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            httpclient.getConnectionManager().shutdown();
        }
        return returnValue;
    }

    public static String sslRequestPost(String url, JSONObject params) throws Exception {
        String returnValue = null;
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        InputStream instream = new FileInputStream(new File(PFX_PATH));
        try {
            keyStore.load(instream, PFX_PWD.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, PFX_PWD.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext
                , new String[]{"TLSv1"}    // supportedProtocols ,这里可以按需要设置
                , null    // supportedCipherSuites
                , SSLConnectionSocketFactory.getDefaultHostnameVerifier());

        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.addHeader("Content-Type", "application/json");
            StringEntity entity = new StringEntity(params.toJSONString());
            httpPost.setEntity(entity);
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpPost);
            if (null != closeableHttpResponse && !"".equals(closeableHttpResponse)) {
                System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
                if (closeableHttpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity httpEntity = closeableHttpResponse.getEntity();
                    returnValue = EntityUtils.toString(httpEntity);
                } else {
                    returnValue = "Error Response" + closeableHttpResponse.getStatusLine().getStatusCode();
                }
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            returnValue = "timeout";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            httpclient.getConnectionManager().shutdown();
        }
        return returnValue;
    }

    // hutool工具类：链接：https://www.bookstack.cn/read/hutool/a4579b97cf741bcd.md
    public static String sslRequestPost2(String url, JSONObject params) {
        SSLContext sslcontext;
        String returnValue = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            InputStream instream = new FileInputStream(new File(PFX_PATH));
            keyStore.load(instream, PFX_PWD.toCharArray());
            instream.close();
            sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, PFX_PWD.toCharArray()).build();
        }catch (Exception e) {
            log.error(e.getMessage());
            log.error("加载证书异常="+e.getMessage());
            return "加载证书异常，异常路径为" + PFX_PATH;
        }
        try {
            HttpResponse execute = cn.hutool.http.HttpUtil.createPost(url).body(params.toJSONString()).setSSLSocketFactory(sslcontext.getSocketFactory()).execute();
            if(execute.getStatus() == cn.hutool.http.HttpStatus.HTTP_OK) {
                returnValue = execute.body();
                log.info("调用接口成功，时间为{}", System.currentTimeMillis());
                //log.info("调用列表接口返回数据="+returnValue);
                return returnValue;
            }
            return "获取最新版本异常";
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return "获取最新版本异常";
        }
    }
}

package com.study.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class FileDownController {

    @GetMapping("/down/file")
    public Map downFile(HttpServletResponse response) {
        return down(response);
    }


    // 下载文件
    public Map down(HttpServletResponse response) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "ok");
        File downFile = new File("doc/out.txt");


        ServletOutputStream out = null;
        FileInputStream ips = null;
        try {
            ips = new FileInputStream(downFile);
            String fileName = downFile.getName();
            response.reset();
            response.setContentLengthLong(downFile.length());
            response.setContentLength((int) downFile.length());
            response.setContentType("application/octet-stream");
            //为下载文件设置名字(java.net.URLEncoder.encode(fileName, "UTF-8") 可以解决中文乱码问题，但是使用swagger调用接口还是出现中文乱码问题)
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            fileName = fileName.replaceAll("\\+", "%20"); // 解决空格变+问题
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            //获取响应的输出流
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("抛出ApiException异常:{}", e.getMessage());
            result.put("code", 500);
            result.put("msg", e.getMessage());
            return result;
        } finally {
            try {
                if (out != null && ips != null) {
                    out.close();
                    ips.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error("抛出ApiException异常:{}", e.getMessage());
                result.put("code", 500);
                result.put("msg", e.getMessage());
                return result;
            } finally {
                //downFile.delete(); //文件转化为流之后，删除本地的暂存文件
            }
        }
        return result;
    }
}

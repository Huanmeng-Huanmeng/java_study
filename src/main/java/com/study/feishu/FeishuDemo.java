package com.study.feishu;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
{
	"msg_type": "post",
	"content": {
		"post": {
			"zh_cn": {
				"title": "项目更新通知",
				"content": [
					[{
							"tag": "text",
							"text": "项目有更新: "
						},
						{
							"tag": "a",
							"text": "请查看",
							"href": "http://www.example.com/"
						},
						{
							"tag": "at",
							"user_id": "ou_18eac8********17ad4f02e8bbbb"
						}
					]
				]
			}
		}
	}
}
* */
@Slf4j
@Service
public class FeishuDemo {
//    @Value("${feishu.push.sendUrl:https://open.work.sany.com.cn/open-apis/bot/v2/hook/468e859d-a59e-4274-bea6-cfd1a86f1816}")
//    private String sendUrl;

    public static void main(String[] args) {
        new FeishuDemo().pointSendFs();
    }

    public void pointSendFs() {
        // 通知信息编写
        List<String> message = new ArrayList<>();
        String messageTemp = "第一条";
        message.add(messageTemp);
        messageTemp = "第二条";
        message.add(messageTemp);
        messageTemp = "第三条";
        message.add(messageTemp);
        //String token = getToken();

        // String title = "新增通道["+message.size()+"]条,请及时进行参数的确认:";
        String title = "宽亚，打劫，把openId信息交出来:";
        List<List<Map<String, Object>>> content = new ArrayList();
        atAllPeople(content);
        addA(content, "点此进入运维系统", "https://ops.sanywind.net/#/WindFarmInfo");
        // 获取风场信息
        for (int i = 0; i < message.size(); i++) {
            String messageTemp2 = message.get(i);
            addContentField(content, (i+1)+".新增风场------");
            // 风场名称
            addContentField(content, "  风场编码", messageTemp2);
            addContentField(content, "  风场拼音", messageTemp2);

        }
        callFeiShu(title, content, "", "");
    }

    private void addContentField(List<List<Map<String, Object>>> contentList, String key, String value) {
        convert(contentList, key + "：" + value);
    }

    private void addContentField(List<List<Map<String, Object>>> contentList, String value) {
        convert(contentList, value);
    }

    private void convert(List<List<Map<String, Object>>> contentList, String value) {
        Map<String, Object> contentField = new HashMap<>();
        contentField.put("tag", "text");
        contentField.put("text", value);
        List<Map<String, Object>> contentList1 = new ArrayList<>();
        contentList1.add(contentField);
        contentList.add(contentList1);
    }

    private void atAllPeople(List<List<Map<String, Object>>> contentList) {
        Map<String, Object> contentField = new HashMap<>();
        contentField.put("tag", "at");
        contentField.put("user_id", "all");
        contentField.put("user_name", "所有人");
        List<Map<String, Object>> contentList1 = new ArrayList<>();
        contentList1.add(contentField);
        contentList.add(contentList1);
    }

    /**
     * 暂时无法使用，因为无法获取对应的openId
     * @param contentList
     */
    private void atOnePeople(List<List<Map<String, Object>>> contentList) {
        Map<String, Object> contentField = new HashMap<>();
        contentField.put("tag", "at");
        contentField.put("user_id", "ou_xxxxxxx"); //取值必须使用ou_xxxxx格式的 open_id 来at指定人
        contentField.put("user_name", "李棋林");
        List<Map<String, Object>> contentList1 = new ArrayList<>();
        contentList1.add(contentField);
        contentList.add(contentList1);
    }

    /**
     * 链接信息
     * @param contentList
     * @param text
     * @param href
     */
    private void addA(List<List<Map<String, Object>>> contentList, String text, String href) {
        Map<String, Object> contentField = new HashMap<>();
        contentField.put("tag", "a");
        contentField.put("text", text);
        contentField.put("href", href);
        List<Map<String, Object>> contentList1 = new ArrayList<>();
        contentList1.add(contentField);
        contentList.add(contentList1);
    }

    private void callFeiShu(String title, List<List<Map<String, Object>>> content, String chatId, String token) {
        Map<String, Object> zh_cn = new HashMap<>();
        zh_cn.put("title", title);
        zh_cn.put("content", content);
        Map<String, Object> post = new HashMap<>();
        post.put("zh_cn", zh_cn);
        Map<String, Object> content0 = new HashMap<>();
        content0.put("post", post);
        Map<String, Object> req = new HashMap<>();
        req.put("msg_type", "post");
        req.put("content", content0);
        //req.put("chat_id", chatId);
        HttpHeaders headers = new HttpHeaders();
        //定义请求参数类型，这里用json所以是MediaType.APPLICATION_JSON
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("Authorization", "Bearer " + token);
        log.info("请求参数：{}", JSONObject.toJSONString(req));
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(req, headers);

        RestTemplate restTemplate = new RestTemplate();
        String sendUrl = "https://open.work.sany.com.cn/open-apis/bot/v2/hook/9c27968c-6842-4af6-aba2-92ce9391610b";
        ResponseEntity<String> entity = restTemplate.postForEntity(sendUrl, request, String.class);
        entity.getStatusCode();
        JSONObject jsonObject = (JSONObject) JSONObject.parse(entity.getBody());
        System.out.println(entity);
    }
}

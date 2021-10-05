package com.torchcoder.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommunityUtil {

    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // MD5加密
    // hello + 3e4a8 -> abc123def456abc
    public static String md5(String key) {
        // 空值返回null
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    public static String getJSONString(int code, String msg, Map<String, Object> map){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg", msg);
        if(map != null){
            for(String key: map.keySet()){
                json.put(key, map.get(key));
            }
        }

        return json.toJSONString();
    }
    public static String getJSONString(int code, String msg){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg", msg);
        return json.toJSONString();
    }
    public static String getJSONString(int code){
        JSONObject json = new JSONObject();
        json.put("code",code);
        return json.toJSONString();
    }

//    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("wind", "222");
//        System.out.println(getJSONString(202,"wind", map));
//        System.out.println(getJSONString(202,"wind"));
//        System.out.println(getJSONString(202));
//    }
}

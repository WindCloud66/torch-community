package com.torchcoder.community.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author HouYongJu
 * @create 2021-10-03 14:17
 */
public class CookieUtil {

    public static String getValue(HttpServletRequest request, String key){
        if(request == null || StringUtils.isBlank(key)){
            throw new IllegalArgumentException("参数为空!");
        }

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals(key)){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }
}

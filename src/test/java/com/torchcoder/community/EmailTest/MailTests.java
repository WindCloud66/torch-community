package com.torchcoder.community.EmailTest;

import com.torchcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@SpringBootTest
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {

        mailClient.sendMail("yongjuhou@139.com", "TEST", "Welcome.");
    }

    @Test
    public void testHtmlMail() {
        //模板变量
        Context context = new Context();
        context.setVariable("username", "wind");
        //模板文件
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("yongjuhou@139.com", "HTML", content);
    }

}

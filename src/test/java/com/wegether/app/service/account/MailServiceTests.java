package com.wegether.app.service.account;

import com.wegether.app.service.mail.RegisterMailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@SpringBootTest
@Slf4j
public class MailServiceTests {

    @Autowired
    private RegisterMailService registerMailService;

    @Test
    public void registerMailServiceTest(){

        try {
            try {
                registerMailService.sendSimpleMessage("web_milk@nate.com");
            } catch (Exception e) {
                e.printStackTrace();
            }
            registerMailService.createMessage("web_milk@nate.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}

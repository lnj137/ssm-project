package com.nj.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-03 20:55
 */
@Controller
@RequestMapping("code")
public class CodeController {
    @GetMapping
    public void getCode(HttpServletResponse response ,HttpSession session){
        GifCaptcha gifCode = CaptchaUtil.createGifCaptcha(100, 40,4);
        String relCode = gifCode.getCode();
        System.out.println("relCode=====>"+relCode);
//        将验证码存入到session容器中，方便取出
        session.setAttribute("code",relCode);

        try {
            //验证码输出到浏览器端
            gifCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


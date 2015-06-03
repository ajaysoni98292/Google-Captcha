package com.spring.google.captcha.controller;

import com.spring.google.captcha.Utils.VerifyCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class CaptchaController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome() {
		return "hello";
	}

	@RequestMapping(value = "/captcha", method = RequestMethod.POST)
	public String captchaValidation(@RequestParam("g-recaptcha-response") String response,
									HttpServletRequest request, ModelMap model) {
		String userAgent = request.getHeader("User-Agent");
		try {
			VerifyCaptcha.verify(response, userAgent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "hello";
	}
}
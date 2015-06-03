package com.spring.google.captcha.controller;

import com.spring.google.captcha.Utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ajay
 */

@Controller
public class TimerController {

    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public String startTimer(HttpServletRequest request, ModelMap timer) {
        request.setAttribute("startTime", System.currentTimeMillis());
        request.setAttribute("sessionTime",300000); // 5 min => 5*60*1000 = 300000
        request.setAttribute("endTime", (System.currentTimeMillis() + 300000));
        request.setAttribute("remainingTime", 300000);
        timer.addAttribute("remainingTime",30000);
        // remaining time = endTimer - System.currentTimeMillis()
        return "timer";
    }

    @RequestMapping(value = "/timer", method = RequestMethod.GET)
    public String serverSideTime(HttpServletRequest request) {

        return "timer";
    }
/*
    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public
    @ResponseBody*/


    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public void submitTest() {
        System.out.println("=========Time Complete =========================");
        System.out.println("=========Test submitted successfully ===========");
    }
}

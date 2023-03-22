package com.spring.Notepad;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.net.Authenticator;

@Controller
public class WelcomeController {

    @RequestMapping("welcome")
    public String goToWelcomePage(){
        //model.put("name",getLoggedinUsername());
        return "welcome";
    }

//    private String getLoggedinUsername(){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//
//    }


}

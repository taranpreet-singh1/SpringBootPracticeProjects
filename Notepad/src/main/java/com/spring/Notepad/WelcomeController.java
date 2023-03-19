package com.spring.Notepad;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.net.Authenticator;

@Controller
public class WelcomeController {

    @RequestMapping("welcome")
    @ResponseBody
    public String goToWelcomePage(){
        //model.put("name",getLoggedinUsername());
        return "Welcome to my Notepad";
    }

//    private String getLoggedinUsername(){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//
//    }


}

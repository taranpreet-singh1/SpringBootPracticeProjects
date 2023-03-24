package com.spring.Notepad;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotepadController {

    @RequestMapping("welcome")
    public String goToWelcomePage(){
        //model.put("name",getLoggedinUsername());
        return "welcome";
    }

    @RequestMapping("addNote")
    public String addNote(){
        return "addNote";
    }

    @RequestMapping("list-notes")
    public String listAllTodos(){
        return "listNotes";
    }

//    private String getLoggedinUsername(){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//
//    }


}

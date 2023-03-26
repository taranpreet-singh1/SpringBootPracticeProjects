package com.spring.Notepad;


import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NotepadController {

    public NotepadController(NoteService noteService) {
        this.noteService = noteService;
    }

    private NoteService noteService;

    @RequestMapping("welcome")
    public String goToWelcomePage(){
        //model.put("name",getLoggedinUsername());
        return "welcome";
    }

    @RequestMapping(value="add-note", method= RequestMethod.GET)
    public String showAddNote(ModelMap model){
        String username = (String)model.get("name");
        Note note = new Note(0,username,"sadsa","sadas");
        model.put("note",note);
        return "addNote";
    }

    @RequestMapping(value="add-note", method= RequestMethod.POST)
    public String addNote(ModelMap model, @Valid Note note, BindingResult result){

        if(result.hasErrors()){
            return "welcome";
        }

        String username = (String)model.get("name");

        return "addNote";
    }

    @RequestMapping("list-notes")
    public String listAllTodos(){
        return "welcome";
    }

//    private String getLoggedinUsername(){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//
//    }


}

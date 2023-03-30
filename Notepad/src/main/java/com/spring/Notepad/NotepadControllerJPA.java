package com.spring.Notepad;


import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class NotepadControllerJPA {


    private NoteRepository noteRepository;

    public NotepadControllerJPA(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(ModelMap model){
        model.put("name",getLoggedinUsername());
        return "redirect:welcome";
    }

    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping("welcome")
    public String goToWelcomePage(ModelMap model){
        String username = (String)model.get("name");
        List<Note> notes = noteRepository.findByUsername(username);
        model.addAttribute("notes",notes);
        //model.put("name",getLoggedinUsername());
        return "welcome";
    }

    @RequestMapping(value="add-note", method= RequestMethod.GET)
    public String showAddNote(ModelMap model){
        String username = (String)model.get("name");
        Note note = new Note(0,username,"","");
        model.put("note",note);
        return "addNote";
    }

    @RequestMapping(value="add-note", method= RequestMethod.POST)
    public String addNote(ModelMap model, @Valid Note note, BindingResult result){

        if(result.hasErrors()){
            return "addNote";
        }

        String username = (String)model.get("name");
        note.setUsername(username);
       // noteService.addNote(username,note.getHeading(), note.getDescription());
        noteRepository.save(note);
        return "redirect:welcome";
    }

    @RequestMapping("list-notes")
    public String listAllTodos(){
        return "redirect:welcome";
    }

    @RequestMapping("delete-note")
    public String deleteNote(@RequestParam int id){
        noteRepository.deleteById(id);
        return "redirect:welcome";
    }

    @RequestMapping(value="update-note", method = RequestMethod.GET)
    public String showUpdatePage(@RequestParam int id, ModelMap model){
        Note note = noteRepository.findById(id).get();
        model.addAttribute("note",note);
        return "addNote";
    }

    @RequestMapping(value="update-note", method= RequestMethod.POST)
    public String updateNote(ModelMap model, @Valid Note note, BindingResult result){

        if(result.hasErrors()){
            return "addNote";
        }

        String username = (String)model.get("name");
        note.setUsername(username);
        noteRepository.save(note);
        return "redirect:welcome";

    }

//    private String getLoggedinUsername(){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//
//    }


}

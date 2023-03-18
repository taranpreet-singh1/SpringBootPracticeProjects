package com.springboot.FirstSpringWebApp.todo;

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

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name")
public class TodoControllerJPA {


    private TodoService todoService;

    private TodoRepository todoRepository;

    public TodoControllerJPA(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todo")
    public String listAllTodos(ModelMap model){
        String username = getLoggedinUsername();


       List<Todo> todos =  todoRepository.findByUsername(username);
        model.addAttribute("todos",todos);
        return "listTodos";
    }



    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        Todo todo = new Todo(0,getLoggedinUsername(), "",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }

        String username = getLoggedinUsername();
        todo.setUsername(username);
        todoRepository.save(todo);
       // todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todo";
    }


    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){

        //Delete Todo
        todoRepository.deleteById(id);
        return "redirect:list-todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }

        String username = getLoggedinUsername();
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todo";
    }

    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

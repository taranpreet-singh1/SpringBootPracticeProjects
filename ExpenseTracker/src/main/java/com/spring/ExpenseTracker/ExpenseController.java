package com.spring.ExpenseTracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExpenseController {

    @RequestMapping("list-expenses")
    public String listAllTodos(){
        return "listExpenses";
    }

}

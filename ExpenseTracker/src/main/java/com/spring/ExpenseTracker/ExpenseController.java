package com.spring.ExpenseTracker;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExpenseController {

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    private ExpenseService expenseService;

    @RequestMapping("list-expenses")
    public String listAllExpenses(ModelMap model){
        List<Expense> expenses =  expenseService.findByUsername("singht");
        model.addAttribute("expenses",expenses);
        return "listExpenses";
    }


    @RequestMapping(value="add-expense", method = RequestMethod.GET)
    public String showAddExpensePage(ModelMap model){
        String username = (String)model.get("name");
        Expense expense = new Expense(0,username,"",100);
        model.put("expense",expense);
        return "addExpense";
    }


    @RequestMapping(value="add-expense", method = RequestMethod.POST)
    public String AddExpense(ModelMap model, @Valid Expense expense, BindingResult result){

        if(result.hasErrors()){
            return "addExpense";
        }

        String username = (String)model.get("name");
        expenseService.addExpense(username,expense.getDescription(),100);
        return "redirect:list-expenses";
    }

    @RequestMapping("delete-expense")
    public String deleteExpense(@RequestParam int id){
        expenseService.deleteById(id);
        return "redirect:list-expenses";
    }



}

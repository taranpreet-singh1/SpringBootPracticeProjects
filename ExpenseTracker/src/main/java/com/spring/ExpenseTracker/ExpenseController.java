package com.spring.ExpenseTracker;

import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ExpenseController {

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    private ExpenseService expenseService;


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(ModelMap model){
        model.put("name",getLoggedinUsername());
        return "redirect:list-expenses";
    }

    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


    @RequestMapping("list-expenses")
    public String listAllExpenses(ModelMap model){
        String username = (String)model.get("name");
        List<Expense> expenses =  expenseService.findByUsername(username);
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


    @RequestMapping(value="update-expense", method = RequestMethod.GET)
    public String showUpdatePage(@RequestParam int id, ModelMap model){
        Expense expense = expenseService.findById(id);
        model.addAttribute("expense",expense);
        return "addExpense";
    }

    @RequestMapping(value="update-expense", method = RequestMethod.POST)
    public String updateExpense(ModelMap model, @Valid Expense expense, BindingResult result){

        if(result.hasErrors()){
            return "addExpense";
        }

        String username = (String)model.get("name");
        expense.setUsername(username);
        expenseService.updateExpense(expense);
        return "redirect:list-expenses";
    }




}

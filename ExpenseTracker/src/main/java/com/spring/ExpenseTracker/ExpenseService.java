package com.spring.ExpenseTracker;

import java.util.List;

public class ExpenseService {

    private static List<Expense> expenses;
    static {
        expenses.add(new Expense(1,"singht","Books", 100));
        expenses.add(new Expense(2, "singht", "Food", 200));
        expenses.add(new Expense(3, "singht", "Rent", 600));
    }


    public List<Expense> findByUsername(String username){
        return expenses;
    }

}

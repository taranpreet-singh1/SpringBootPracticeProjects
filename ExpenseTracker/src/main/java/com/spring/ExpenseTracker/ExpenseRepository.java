package com.spring.ExpenseTracker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
    public List<Expense> findByUsername(String username);
}

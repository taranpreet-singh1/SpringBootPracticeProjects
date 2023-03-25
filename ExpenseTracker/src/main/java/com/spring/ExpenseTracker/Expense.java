package com.spring.ExpenseTracker;


import jakarta.validation.constraints.Size;

public class Expense {

    private int id;
    private String username;

    @Size(min=10, message="Enter atleast 10 characters")
    private String description;
    private int amount;

    public Expense(int id, String username, String description, int amount) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}

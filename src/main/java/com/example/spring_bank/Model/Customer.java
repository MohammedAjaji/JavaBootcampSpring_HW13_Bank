package com.example.spring_bank.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {

    private String id, username;
    private double balance;
}

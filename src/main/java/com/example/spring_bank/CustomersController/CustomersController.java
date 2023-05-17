package com.example.spring_bank.CustomersController;

import com.example.spring_bank.ApiResponse.ApiResponse;
import com.example.spring_bank.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/bank")
public class CustomersController {

    ArrayList<Customer> customers = new ArrayList<>();

    //read
    @GetMapping("/get")
    public ArrayList<Customer> getCustomer() {
        return customers;
    }

    //creat
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return "Added!!";
    }

    //update
    @PutMapping("/update/{index}")
    public String updateCustomer(@PathVariable int index, @RequestBody Customer customer) {
        customers.set(index, customer);
        return "Updated !!";
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public String deleteCustomer(@PathVariable int index) {
        customers.remove(index);
        return "Deleted!!";
    }

    //Deposit
    @GetMapping("/deposit/{username}/{deposit}")
    public Customer deposit(@PathVariable String username, @PathVariable double deposit) {
        Customer data = null;
        for (Customer a : customers) {
            if (a.getUsername().equals(username)) {
                a.setBalance(a.getBalance() + deposit);
                data = a;
                }
        }
        return data;
    }



    //Withdraw
    @GetMapping("/withdraw/{username}/{withdraw}")
    public Customer withdraw(@PathVariable String username,@PathVariable double withdraw) {
        Customer data = null;
        for (Customer a : customers) {
            if (a.getUsername().equals(username)) {
                if(a.getBalance() >= withdraw){
                    a.setBalance(a.getBalance() - withdraw);
                    data = a;
                }
            }
        }
        return data;
    }
}

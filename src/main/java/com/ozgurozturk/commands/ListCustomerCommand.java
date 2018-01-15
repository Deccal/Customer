package com.ozgurozturk.commands;

import com.ozgurozturk.Customer;
import com.ozgurozturk.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class ListCustomerCommand implements Command {

    private List<Customer> customerList;


    @Autowired
    private UserManager userManager;


    @Override
    public String commandDescription() {
        return "Müşterileri Listele";
    }

    @Override
    public void executeCommand(Customer customer) {

    }

    @Override
    public void executeCommand() {
        customerList = new ArrayList<>();
        customerList = userManager.getCustomerList();
        customerList.stream().forEach(customer -> System.err.println(customer));

    }
}

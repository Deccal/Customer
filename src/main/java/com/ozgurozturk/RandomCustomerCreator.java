package com.ozgurozturk;

import java.util.Random;

/**
 * Created by Ozgur on 6.06.2017.
 */
public class RandomCustomerCreator {

    private Random random = new Random(100_000);

    public Customer createCostomer() {
        Customer customer = new Customer();
        customer.setName("Name " + random.nextInt());
        customer.setSurname("Surname " + random.nextInt());
        customer.setUserName("Username " + random.nextInt());
        customer.setPassword("Password " + random.nextInt());

        return customer;
    }
}

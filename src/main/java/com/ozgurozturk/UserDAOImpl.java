package com.ozgurozturk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozgur on 6.06.2017.
 */
@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    RandomCustomerCreator randomCustomerCreator;

    @Override
    public Customer getCustomerByUserNameAndPassword(String name, String password) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            customerList.add(randomCustomerCreator.createCostomer());
        }
        return customerList;
    }

    @Override
    public List<Admin> getAdminList() {
        return null;
    }

    @Override
    public Admin getAdminByUserNameAndPassword(String name, String password) {
        return null;
    }


    @Override
    public void createAdmin(Admin admin) {

    }

    @Override
    public void createCustomer(Customer customer) {

    }

    @Override
    public void removeCustomerByUserName(String userName) {

    }

    @Override
    public void removeCustomerById(long id) {

    }

    @Override
    public void removeCustomer(Customer customer) {

    }

    @Override
    public boolean findCustomerByUserName(String userName) {
        return false;
    }
}

package com.ozgurozturk;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozgur on 6.06.2017.
 */
public class UserManager {


    public UserManager() {
        System.err.println("CustomerManager");
    }

    @Autowired
    private UserCache userCache;

    public Customer getLogOnCustomer(String userName, String password) {
        Customer customer = userCache.getLogOnCustomer(userName, password);
        return customer;
    }

    public Customer getLogedCustomer(String userName, String password) {
        Customer customer = userCache.getCustomer(userName);
        if (customer != null) {
            if (customer.getPassword().equals(password)) {
                return customer;
            }
        } else {
            return null;
        }
        return null;
    }


    public List<Admin> getAdminList() {
        List<Admin> adminList = userCache.getAdminList();
        return adminList;
    }

    public Admin getLogOnAdmin(String userName, String password) {
        Admin admin = userCache.getLogOnAdmin(userName, password);
        return admin;
    }

    public void createAdmin(Admin admin) {
        userCache.createAdmin(admin);
    }

    public void createCustomer(Customer customer) {
        userCache.createCutomer(customer);
    }

    public void removeCustomerByUserName(String userName) {
        userCache.removeCustomerByUserName(userName);
    }

    public void removeCustomerById(long id) {
        userCache.removeCustomerById(id);

    }

    public void removeCustomer(Customer customer) {
        userCache.removeCustomer(customer);
    }

    public boolean findCustomerByUserName(String userName){
        boolean haveCustomer = userCache.findCustomerByUserName(userName);
        return  haveCustomer;
    }

    public List<Customer> getCustomerList (){
        List<Customer> customerList = new ArrayList<>();
        customerList = userCache.getCusTomerList();
        return customerList;
    }

}

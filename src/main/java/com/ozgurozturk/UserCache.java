package com.ozgurozturk;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ozgur on 6.06.2017.
 */

public class UserCache {


    private List<Customer> customerList;

    public UserCache() {
        System.err.println("CustomerCache");
    }

    @Autowired
    private UserDAO userDAO;

    private Map<String, Customer> customerMap = new HashMap<>();


    @PostConstruct
    public void init() {
        List<Customer> customerList = userDAO.getAllCustomer();
        customerList.stream().forEach(customer -> fillCustomerMap(customer));
    }

    public Customer getLogOnCustomer(String userName, String password) {
        Customer customer = userDAO.getCustomerByUserNameAndPassword(userName, password);
        return customer;

    }

    public void fillCustomerMap(Customer customer) {
        customerMap.put(customer.getUserName(), customer);
    }

    public Customer getCustomer(String userName) {
        return customerMap.get(userName);
    }

    public List<Admin> getAdminList() {
        List<Admin> adminList = userDAO.getAdminList();
        return adminList;
    }

    public void createAdmin(Admin admin) {
        userDAO.createAdmin(admin);
    }

    public void createCutomer(Customer customer) {
        userDAO.createCustomer(customer);
    }

    public Admin getLogOnAdmin(String userName, String password) {

        Admin admin = userDAO.getAdminByUserNameAndPassword(userName, password);

        return admin;

    }

    public void removeCustomerByUserName(String userName) {
        userDAO.removeCustomerByUserName(userName);
    }

    public void removeCustomerById(long id) {
        userDAO.removeCustomerById(id);

    }

    public void removeCustomer(Customer customer) {
        userDAO.removeCustomer(customer);
    }

    public boolean findCustomerByUserName(String userName){
        boolean haveCustomer = userDAO.findCustomerByUserName(userName);
        return  haveCustomer;
    }

    public List<Customer> getCusTomerList (){
        customerList = new ArrayList<>();
        customerList = userDAO.getAllCustomer();
        return  customerList;
    }
}

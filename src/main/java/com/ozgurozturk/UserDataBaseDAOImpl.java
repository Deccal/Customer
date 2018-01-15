package com.ozgurozturk;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozgur on 6.06.2017.
 */
public class UserDataBaseDAOImpl implements UserDAO {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Customer getCustomerByUserNameAndPassword(String name, String password) {
        Customer customer = customerRepository.findCustomerByUserNameAndPassword(name, password);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            customerList.add(customer);
        }

        return customerList;
    }

    @Override
    public List<Admin> getAdminList() {
        List<Admin> adminList = new ArrayList<>();
        Iterable<Admin> admins = adminRepository.findAll();

        for (Admin admin : admins) {
            adminList.add(admin);
        }

        return adminList;
    }

    @Override
    public Admin getAdminByUserNameAndPassword(String name, String password) {
        Admin admin = adminRepository.findAdminByAdminUserNameAndAdminPassword(name, password);
        return admin;
    }


    @Override
    public void createAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void removeCustomerByUserName(String userName) {
        customerRepository.deleteCustomerByUserName(userName);
    }

    @Override
    public void removeCustomerById(long id) {
        customerRepository.delete(id);

    }

    @Override
    public void removeCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public boolean findCustomerByUserName(String userName) {
       boolean haveCustomer = customerRepository.findCustomerByUserName(userName);
        return haveCustomer;
    }
}

package com.ozgurozturk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozgur on 6.06.2017.
 */
public class UserFileDAOImpl implements UserDAO {

    @Override
    public Customer getCustomerByUserNameAndPassword(String name, String password) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();

        File file = new File("customer");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            line = bufferedReader.readLine();

            while (line!=null){
                if (line!=null){
                    String[] split = line.split(",");
                    if (split.length == 4) {
                            Customer customer = new Customer();
                            customer.setName(split[1]);
                            customer.setSurname(split[2]);
                            customer.setUserName(split[3]);
                            customer.setPassword(split[4]);
                            System.err.println(customer);
                            customerList.add(customer);
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
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

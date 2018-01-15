package com.ozgurozturk;

import java.util.List;

/**
 * Created by Ozgur on 6.06.2017.
 */
public interface UserDAO {

    Customer getCustomerByUserNameAndPassword(String name,String password);

    List<Customer> getAllCustomer();

    List<Admin> getAdminList();

    Admin getAdminByUserNameAndPassword(String name,String password);

    void createAdmin(Admin admin);

    void createCustomer(Customer customer);

    void removeCustomerByUserName(String userName);

    void removeCustomerById(long id);

    void  removeCustomer(Customer customer);

    boolean findCustomerByUserName (String userName);

}

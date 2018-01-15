package com.ozgurozturk;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ozgur on 6.06.2017.
 */
@Entity
public class Customer {


    @Id
    @GeneratedValue
    private long id;


    private String name;
    private String surname;
    private String userName;
    private String password;


    @Embedded
    private CustomerTypeDetail customerTypeDetail;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "customer")
    private List<AccountDetail> accountDetailList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public CustomerTypeDetail getCustomerTypeDetail() {
        return customerTypeDetail;
    }

    public void setCustomerTypeDetail(CustomerTypeDetail customerTypeDetail) {
        this.customerTypeDetail = customerTypeDetail;
    }

    public List<AccountDetail> getAccountDetailList() {
        return accountDetailList;
    }

    public void setAccountDetailList(List<AccountDetail> accountDetailList) {
        this.accountDetailList = accountDetailList;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", customerTypeDetail=" + customerTypeDetail +
                ", accountDetailList=" + accountDetailList +
                '}';
    }
}

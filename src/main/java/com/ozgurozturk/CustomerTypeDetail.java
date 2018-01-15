package com.ozgurozturk;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Ozgur on 7.06.2017.
 */

@Embeddable
public class CustomerTypeDetail {

    private String customerTypeExp;

    @Enumerated(EnumType.STRING)
    private CustomerType customerType;


    public String getCustomerTypeExp() {
        return customerTypeExp;
    }

    public void setCustomerTypeExp(String customerTypeExp) {
        this.customerTypeExp = customerTypeExp;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "CustomerTypeDetail{" +
                "customerTypeExp='" + customerTypeExp + '\'' +
                ", customerType=" + customerType +
                '}';
    }
}

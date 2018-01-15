package com.ozgurozturk;

import com.ozgurozturk.processes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by Ozgur on 8.06.2017.
 */
public class UserProcessorFactory {


    @Autowired
    private ApplicationContext applicationContext;

    public UserProcess createActiveUserProcessor(UserType userType, CustomerType customerType) {

        switch (userType) {

            case ADMIN:
                return applicationContext.getBean(AdminProcess.class);
            case CUSTOMER:
                return findCustomerProcess(customerType);
            default:
                break;
        }

        return null;
    }

    private UserProcess findCustomerProcess(CustomerType customerType) {

        switch (customerType) {
            case GOLD:
                return applicationContext.getBean(GoldCustomerProcess.class);
            case SILVER:
                return applicationContext.getBean(SilverCustomerProcess.class);
            case BRONZE:
                return applicationContext.getBean(BronzeCustomerProcess.class);
            default:
                break;
        }

        return null;
    }
}

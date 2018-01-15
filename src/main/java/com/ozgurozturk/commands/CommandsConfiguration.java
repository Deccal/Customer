package com.ozgurozturk.commands;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ozgur on 9.06.2017.
 */

@Configuration
public class CommandsConfiguration {


    @Bean
    public AddCustomerCommand getAddCustomerCommand() {
        return new AddCustomerCommand();
    }


    @Bean
    public ListCustomerCommand getListCustomerCommand() {
        return new ListCustomerCommand();
    }


    @Bean
    public RemoveCustomerCommand getRemoveCustomerCommand() {
        return new RemoveCustomerCommand();
    }

    @Bean
    public DepositStockCommand getDepositStockCommand() {
        return new DepositStockCommand();
    }

    @Bean
    public WithdrawStockCommand getWithdrawStockCommand() {
        return new WithdrawStockCommand();
    }

    @Bean
    public DepositDollarCommand getDepositDollarCommand() {
        return new DepositDollarCommand();
    }

    @Bean
    public WithdrawDollarCommand getWithdrawDollarCommand() {
        return new WithdrawDollarCommand();
    }

    @Bean
    public DepositTLCommand getDepositTLCommand() {
        return new DepositTLCommand();
    }

    @Bean
    public WithdrawTLCommand getWithdrawTLCommand() {
        return new WithdrawTLCommand();
    }
}

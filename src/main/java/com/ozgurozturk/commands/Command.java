package com.ozgurozturk.commands;

import com.ozgurozturk.Customer;

/**
 * Created by Ozgur on 9.06.2017.
 */
public interface Command {

    String commandDescription();

    void executeCommand(Customer customer);

    void executeCommand();

}

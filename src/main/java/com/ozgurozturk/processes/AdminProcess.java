package com.ozgurozturk.processes;

import com.ozgurozturk.commands.AddCustomerCommand;
import com.ozgurozturk.commands.ListCustomerCommand;
import com.ozgurozturk.commands.RemoveCustomerCommand;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ozgur on 8.06.2017.
 */
public class AdminProcess extends UserProcess {

    @Autowired
    private AddCustomerCommand addCustomerCommand;

    @Autowired
    private RemoveCustomerCommand removeCustomerCommand;

    @Autowired
    private ListCustomerCommand listCustomerCommand;

    @PostConstruct
    public void init() {
        commandList.add(addCustomerCommand);
        commandList.add(removeCustomerCommand);
        commandList.add(listCustomerCommand);
    }
}

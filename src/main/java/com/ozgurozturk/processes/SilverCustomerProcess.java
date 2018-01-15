package com.ozgurozturk.processes;

import com.ozgurozturk.commands.DepositDollarCommand;
import com.ozgurozturk.commands.WithdrawDollarCommand;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class SilverCustomerProcess extends BronzeCustomerProcess {


    @Autowired
    private DepositDollarCommand depositDollarCommand;

    @Autowired
    private WithdrawDollarCommand withdrawDollarCommand;

    @Override
    @PostConstruct
    public void init(){
        commandList.add(depositDollarCommand);
        commandList.add(withdrawDollarCommand);
        super.init();
    }

}

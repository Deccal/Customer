package com.ozgurozturk.processes;

import com.ozgurozturk.commands.DepositTLCommand;
import com.ozgurozturk.commands.WithdrawTLCommand;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class BronzeCustomerProcess extends UserProcess {


    @Autowired
    private DepositTLCommand depositTLCommand;

    @Autowired
    private WithdrawTLCommand withdrawTLCommand;


    @PostConstruct
    public void init() {
        commandList.add(depositTLCommand);
        commandList.add(withdrawTLCommand);
    }

}

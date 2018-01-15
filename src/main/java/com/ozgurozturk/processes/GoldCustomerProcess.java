package com.ozgurozturk.processes;

import com.ozgurozturk.commands.DepositStockCommand;
import com.ozgurozturk.commands.WithdrawStockCommand;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class GoldCustomerProcess extends SilverCustomerProcess {


    @Autowired
    private DepositStockCommand depositStockCommand;

    @Autowired
    private WithdrawStockCommand withdrawStockCommand;

    @Override
    @PostConstruct
    public void init() {
        commandList.add(depositStockCommand);
        commandList.add(withdrawStockCommand);
        super.init();

    }


}

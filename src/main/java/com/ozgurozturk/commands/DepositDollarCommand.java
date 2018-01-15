package com.ozgurozturk.commands;

import com.ozgurozturk.AccountType;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class DepositDollarCommand extends DepositOrWithdrawCommand {



    public DepositDollarCommand() {
        super(AccountType.DOLLAR, true);
    }

}

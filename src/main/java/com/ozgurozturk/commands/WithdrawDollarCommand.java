package com.ozgurozturk.commands;

import com.ozgurozturk.AccountType;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class WithdrawDollarCommand extends DepositOrWithdrawCommand {

    public WithdrawDollarCommand() {
        super(AccountType.DOLLAR, false);
    }

}

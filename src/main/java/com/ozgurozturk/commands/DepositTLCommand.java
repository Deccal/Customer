package com.ozgurozturk.commands;

import com.ozgurozturk.AccountType;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class DepositTLCommand extends DepositOrWithdrawCommand {

    public DepositTLCommand() {
        super(AccountType.TL, true);
    }

}

package com.ozgurozturk.commands;

import com.ozgurozturk.AccountType;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class WithdrawTLCommand extends DepositOrWithdrawCommand {

    public WithdrawTLCommand() {
        super(AccountType.TL, false);
    }

}

package com.ozgurozturk.commands;

import com.ozgurozturk.AccountType;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class WithdrawStockCommand extends DepositOrWithdrawCommand {

    public WithdrawStockCommand() {
        super(AccountType.STOCK, false);
    }

}

package com.ozgurozturk.commands;

import com.ozgurozturk.AccountType;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class DepositStockCommand extends DepositOrWithdrawCommand {

    public DepositStockCommand() {
        super(AccountType.STOCK, true);
    }

}

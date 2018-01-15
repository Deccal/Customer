package com.ozgurozturk.commands;

import com.ozgurozturk.AccountDetail;
import com.ozgurozturk.AccountType;
import com.ozgurozturk.Customer;
import com.ozgurozturk.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ozgur on 9.06.2017.
 */
public abstract class DepositOrWithdrawCommand implements Command {

    @Autowired
    private UserManager userManager;

    private AccountType accountType;
    private boolean isDeposit;
    private String description;
    private Scanner scanner;
    private List<AccountDetail> accountDetailList;

    public DepositOrWithdrawCommand(AccountType accountType, boolean isDeposit) {
        this.accountType = accountType;
        this.isDeposit = isDeposit;

    }


    @Override
    public String commandDescription() {

        if (accountType.equals(AccountType.STOCK)) {
            description = "HİSSE SENEDİ";
            return description + " " + (isDeposit ? " AL" : " SAT");
        } else if (accountType.equals(AccountType.DOLLAR)) {
            description = "DOLAR";
            return description + " " + (isDeposit ? " YATIR" : " ÇEK");
        } else if (accountType.equals(AccountType.TL)) {
            description = "TÜRK LİRASI";
            return description + " " + (isDeposit ? " YATIR" : " ÇEK");
        }

        return null;
    }

    @Override
    public void executeCommand() {

    }

    @Override
    public void executeCommand(Customer customer) {
        scanner = new Scanner(System.in);
        double value;
        accountDetailList = new ArrayList<>();

        accountDetailList = customer.getAccountDetailList();

        if (accountType.equals(AccountType.STOCK)) {
            System.err.println((isDeposit ? "ALINACAK " : "SATILACAK ") + "HİSSE SENEDİ ADEDİ :");

        } else if (accountType.equals(AccountType.DOLLAR)) {
            System.err.println((isDeposit ? "YATIRILACAK " : " ÇEKİLECEK ") + "DOLAR MİKTARI :");

        } else if (accountType.equals(AccountType.TL)) {
            System.err.println((isDeposit ? "YATIRILACAK " : " ÇEKİLECEK ") + "TURK LİRASI MİKTARI :");
        }

        value = Double.valueOf(scanner.nextLine());

        accountDetailList.stream().forEach(accountDetail -> {
            if (accountDetail.getAccountType().equals(accountType)) {
                if (isDeposit) {
                    accountDetail.setBalance(accountDetail.getBalance() + value);
                } else {
                    accountDetail.setBalance(accountDetail.getBalance() - value);
                }
            }
        });

        userManager.createCustomer(customer);
    }
}

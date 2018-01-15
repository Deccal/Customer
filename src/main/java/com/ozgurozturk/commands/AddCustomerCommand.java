package com.ozgurozturk.commands;

import com.ozgurozturk.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class AddCustomerCommand implements Command {


    @Autowired
    private UserManager userManager;

    private Scanner scanner;
    private String customerType;
    private CustomerTypeDetail customerTypeDetail;
    private List<AccountDetail> accountDetailList;


    @Override
    public String commandDescription() {
        return "Müşteri Ekle";
    }

    @Override
    public void executeCommand(Customer customer) {

    }

    @Override
    public void executeCommand() {

        scanner = new Scanner(System.in);
        Customer customer = new Customer();
        boolean validType = false;

        System.err.println("Customer ismi giriniz");
        String name = scanner.nextLine();
        customer.setName(name);

        System.err.println("Customer soyadı giriniz");
        String surname = scanner.nextLine();
        customer.setSurname(surname);

        System.err.println("Customer username giriniz");
        String userName = scanner.nextLine();
        customer.setUserName(userName);

        System.err.println("Customer şifre giriniz");
        String password = scanner.nextLine();
        customer.setPassword(password);


        while (!validType) {
            System.err.println("Customer type giriniz 'Gold/Silver/Bronze'");
            customerType = scanner.nextLine();
            validType = checkCustomerType(customerType);
        }

        customer.setCustomerTypeDetail(prepareCustomerTypeDetail(customerType));
        prepareAccountDetailList(customer);

        customer.setAccountDetailList(accountDetailList);
        createNewCustomer(customer);


    }

    private CustomerTypeDetail prepareCustomerTypeDetail(String customerType) {

        customerTypeDetail = new CustomerTypeDetail();
        if (customerType.equalsIgnoreCase("Gold")) {
            customerTypeDetail.setCustomerType(CustomerType.GOLD);
            customerTypeDetail.setCustomerTypeExp("Gold Customer");
        } else if (customerType.equalsIgnoreCase("Silver")) {
            customerTypeDetail.setCustomerType(CustomerType.SILVER);
            customerTypeDetail.setCustomerTypeExp("Silver Customer");
        } else if (customerType.equalsIgnoreCase("Bronze")) {
            customerTypeDetail.setCustomerType(CustomerType.BRONZE);
            customerTypeDetail.setCustomerTypeExp("Bronze Customer");
        }

        return customerTypeDetail;
    }

    private List<AccountDetail> prepareAccountDetailList(Customer customer) {
        accountDetailList = new ArrayList<>();

        switch (customer.getCustomerTypeDetail().getCustomerType()) {
            case GOLD:
                accountDetailList.add(createAccountDetailByCustomerType(customer, AccountType.STOCK));
            case SILVER:
                accountDetailList.add(createAccountDetailByCustomerType(customer, AccountType.DOLLAR));
            case BRONZE:
                accountDetailList.add(createAccountDetailByCustomerType(customer, AccountType.TL));
            default:
                break;
        }
        return accountDetailList;

    }

    private boolean checkCustomerType(String customerType) {

        if (!(customerType.equalsIgnoreCase("Gold") || customerType.equalsIgnoreCase("Silver") || customerType.equalsIgnoreCase("Bronze"))) {
            System.err.println("Uygun Bir Type Seçiniz! 'Gold/Silver/Bronze'");
            return false;
        }

        return true;
    }

    private AccountDetail createAccountDetailByCustomerType(Customer customer, AccountType accountType) {
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setAccountType(accountType);
        accountDetail.setAccountName(accountType + " Account");
        accountDetail.setCustomer(customer);
        return accountDetail;
    }

    private void createNewCustomer(Customer customer) {
        userManager.createCustomer(customer);
    }
}

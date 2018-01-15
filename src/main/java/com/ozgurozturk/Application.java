package com.ozgurozturk;

import com.ozgurozturk.processes.UserProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application {

    @Autowired
    UserManager userManager;

    @Autowired
    private UserProcessorFactory userProcessorFactory;


    private UserProcess activeUserProcessor;
    private Customer customer;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        Application bean = applicationContext.getBean(Application.class);


        boolean haveAdmin = bean.checkAdmin();


        if (!haveAdmin) {
            System.err.println("Sistemde Admin bulunmadığından Admin yaratılacaktır.");
            bean.createAdmin();
        }

        bean.loginUser();

    }

    private void loginUser() {
        Scanner scanner = new Scanner(System.in);
        Object user;
        int userAnswer;
        do {
            System.err.println("Username Giriniz :");
            String userName = scanner.nextLine();
            System.err.println("Password Giriniz");
            String password = scanner.nextLine();
            user = findUser(userName, password);

        } while (user == null);

        if (user instanceof Admin) {
            activeUserProcessor = userProcessorFactory.createActiveUserProcessor(UserType.ADMIN, null);
            customer = null;
        } else if (user instanceof Customer) {
            activeUserProcessor = userProcessorFactory.createActiveUserProcessor(UserType.CUSTOMER, ((Customer) user).getCustomerTypeDetail().getCustomerType());
            customer = (Customer) user;
        }

        activeUserProcessor.process(customer);

        System.err.println("İşlemleriniz Bitmiştir. Yeni bir işlem yapmak için 'Giriş' yapmanız gerekmektedir.");
        System.err.println("Yeniden giriş yapmak için '5' e basın Lütfen! ");
        userAnswer = scanner.nextInt();
        if (userAnswer==5){
            loginUser();
        }
    }


    private boolean checkAdmin() {
        List<Admin> adminList = userManager.getAdminList();
        if (adminList != null && adminList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private void createAdmin() {
        Admin admin = new Admin();
        admin.setAdminName("Özgür");
        admin.setAdminSurname("Öztürk");
        admin.setAdminUserName("Deccal");
        admin.setAdminPassword("721690");
        userManager.createAdmin(admin);
    }

    @org.jetbrains.annotations.Nullable
    private Object findUser(String userName, String password) {
        Customer customer = userManager.getLogOnCustomer(userName, password);
        if (customer != null) {
            System.out.println("Giren müşteri  : " + customer);
            return customer;
        }

        Admin admin = userManager.getLogOnAdmin(userName, password);
        if (admin != null) {
            System.err.println("Giren Admin" + admin);
            return admin;
        }


        System.out.println("Yanlış username yada password");

        return null;
    }

}

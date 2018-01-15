package com.ozgurozturk.commands;

import com.ozgurozturk.Customer;
import com.ozgurozturk.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * Created by Ozgur on 9.06.2017.
 */
public class RemoveCustomerCommand implements Command {


    @Autowired
    UserManager userManager;

    private Scanner scanner;
    private int errCount;



    @Override
    public String commandDescription() {
        return "Müşteri Sil";
    }

    @Override
    public void executeCommand(Customer customer) {

    }


    @Override
    public void executeCommand() {
        String userName = null;
        scanner =  new Scanner(System.in);
        System.err.println("Silmek istediğiniz müşteri 'User Name'ini giriniz'. ");
        userName = scanner.nextLine();
        if(checkUserName(userName)){
            userManager.removeCustomerByUserName(userName);
            System.err.println(userName +  " Kullanıcı isimli Müşteri Silinmiştir.");
        }


    }

    private boolean checkUserName(String userName) {
        Scanner scanner = new Scanner(System.in);
       boolean haveCustomer = userManager.findCustomerByUserName(userName);
       if (!haveCustomer){
           errCount++;
           if(errCount<3) {
               System.err.println("Girdiğiniz Kullanıcı İsmi Sistemde bulunmamaktadır. Lütfen geçerli bir kullanıcı adı giriniz!");
               userName = scanner.nextLine();
               checkUserName(userName);
           }else{
               System.err.println("3 Kez Hatalı giriş yaptığınız için işleminiz sonlanmıştır!");
               return false;
           }
       }
       return haveCustomer;

    }
}

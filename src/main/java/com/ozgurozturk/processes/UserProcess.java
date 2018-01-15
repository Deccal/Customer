package com.ozgurozturk.processes;

import com.ozgurozturk.Customer;
import com.ozgurozturk.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ozgur on 8.06.2017.
 */
public class UserProcess {

    protected List<Command> commandList = new ArrayList<>();
    protected Scanner scanner;

    private boolean continueProcess;
    private String userAnswer;

    public void process(Customer customer) {
        continueProcess = true;

        scanner = new Scanner(System.in);
        Command selectedCommand;
        int commandCount = 1;
        //Write Menu to Console
        while (continueProcess) {
            for (Command command : commandList) {

                System.err.println(commandCount + " " + command.commandDescription());
                commandCount++;
            }

            int menuIndex = scanner.nextInt();
            if ((menuIndex > commandList.size()) || (menuIndex < 1)) {
                System.err.println("Geçersiz Menü Girişi. Lütfen Listede olan değerleri seçiniz!");
                continue;
            }

            selectedCommand = commandList.get(menuIndex - 1);
            System.err.println(selectedCommand.commandDescription() + " seçilmiştir.");

            if (customer != null) {
                selectedCommand.executeCommand(customer);
            } else {
                selectedCommand.executeCommand();
            }

            System.err.println("Başka bir işlem yapmak istiyor musunuz? E/H");
            userAnswer = scanner.nextLine();
            checkUserAnswer(userAnswer);
        }

    }


    private void checkUserAnswer(String userAnswer) {
        if (userAnswer.equalsIgnoreCase("E")) {
            continueProcess = true;
        } else if (userAnswer.equalsIgnoreCase("H")) {
            continueProcess = false;
        } else {
            System.err.println("Lütfen gecerli bir deger giriniz! E/H");
            userAnswer = scanner.nextLine();
            checkUserAnswer(userAnswer);
        }
    }


    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }
}

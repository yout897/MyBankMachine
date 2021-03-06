/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Author: Alex DiCarlo Date: 13/10/2016 Purpose: To create a program that acts
 * like a ATM, using user inputs.
 */
public class MyBankMachine {

    static ArrayList banks = new ArrayList<>();
    static double inputD;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        Collections.addAll(banks, "bmo", "td", "scotiabank", "rbc", "pc");

        double randBalance = (Math.random() * 1000);
        System.out.println("What bank are you currently signed up with?(Please use the accronym if it has one IE. PC,BMO,RBC,TD)");
        do {
            String inputS = scan.nextLine();
            if (banks.contains(inputS.toLowerCase())) {
                ATM atm = new ATM(inputS, randBalance);
                System.out.println("What would you like to do?\n"
                        + "1: Deposit\n"
                        + "2: Withdrawal\n"
                        + "3: Add Daily Interest\n"
                        + "4: Display Your Current Balance\n"
                        + "5: Exit The ATM");
                do {
                    inputS = scan.nextLine();
                    switch (inputS) {
                        case "1":
                            System.out.println("How much would you like to deposit?");
                            inputD = scan.nextDouble();
                            atm.deposit(inputD);
                            break;
                        case "2":
                            System.out.println("How much would you like to withdrawal?");
                            inputD = scan.nextDouble();
                            atm.withdrawal(inputD);
                            break;
                        case "3":
                            System.out.println("What is the rate?");
                            double rate = scan.nextDouble();
                            System.out.println("What is the compound period?");
                            int period = scan.nextInt();
                            atm.interest(rate, period);
                            System.out.println("You have just added interest with a rate of " + rate + " and a period of " + period);
                            break;
                        case "4":
                            atm.currentBalance();
                            break;
                        case "5":
                            System.out.println("Good Bye");
                            System.exit(0);
                        default:
                            System.out.println("That is not an option!");
                            break;
                    }
                } while (true);
            }else{
                System.out.println("That is not in the data bank.");
            }
        } while (true);
    }
}

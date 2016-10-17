/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mybankmachine;

import java.text.DecimalFormat;

/**
 *
 * @author aldic2547
 */
public class ATM {
    
    String bankName;
    double balance;
    DecimalFormat df = new DecimalFormat("$####.00");
    
    public ATM(String bnkName,double curBal){
        bankName = bnkName;
        balance = curBal;
    }
    public void withdrawal(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("You have withdrawaled " + df.format(amount) + " from your bank.");
        }else{
            System.out.println("You don't have enough money in your back to do that.");
        }
    }
    public void deposit(double amount){
        balance += amount;
        System.out.println("You have deposited " + df.format(amount) + " to your bank.");
    }
    public void interest(double anRate,int compPeriod){
        double total;
        total = (1 + anRate);
        total = Math.pow(total,compPeriod);
        total = balance*total;
        balance = total;
    }
    public double currentBalance(){
        System.out.println("Your current balance is: " + df.format(balance));
        return balance;
    }
}

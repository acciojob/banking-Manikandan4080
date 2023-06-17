package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int rem = sum;
        String accountNo = "";
        if(digits*9 < sum){
            throw new Exception("Account Number can not be generated");
        }

        while(0 < digits && 0 < rem){
            if(rem >= 9){
                rem -= 9;
                accountNo += "9";
            }
            else{
                accountNo += Integer.toString(rem);
                rem = 0;
            }
            digits--;
        }
        while(digits > 0){
            accountNo += "0";
            digits--;
        }

        return accountNo;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance - amount < getMinBalance()){
            throw new Exception("Insufficient Balance");
        }
        this.balance -= amount;
    }

}
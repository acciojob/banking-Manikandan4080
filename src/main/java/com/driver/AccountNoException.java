package com.driver;

public class AccountNoException extends RuntimeException{
    public AccountNoException(){
        super("Account Number can not be generated");
    }
}
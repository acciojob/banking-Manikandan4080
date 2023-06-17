package com.driver;

public class InsuffecientBalance extends RuntimeException{
    public InsuffecientBalance(){
        super("Insufficient Balance");
    }
}
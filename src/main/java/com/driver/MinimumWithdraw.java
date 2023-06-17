package com.driver;

public class MinimumWithdraw extends RuntimeException{
    public MinimumWithdraw(){
        super("Maximum Withdraw Limit Exceed");
    }
}

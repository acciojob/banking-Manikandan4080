package com.driver;

public class ValidIdException extends RuntimeException{
    public ValidIdException(){
        super("Valid License can not be generated");
    }
}
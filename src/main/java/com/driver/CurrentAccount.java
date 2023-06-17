package com.driver;

import java.util.HashMap;
import java.util.Map;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000) throw new InsuffecientBalance();
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(notValidId(tradeLicenseId)){
            String newId = generateId(tradeLicenseId);
            if(newId.isEmpty()) throw new ValidIdException();

            else{
                this.tradeLicenseId = newId;
            }
        }

    }
    private boolean notValidId(String id){
        int n = id.length();
        for(int i = 0; i < n-1; i++){
            if(id.charAt(i) == id.charAt(i+1)) return true;
        }
        return false;
    }
    private String generateId(String id){
        int n = id.length();
        Map<Character, Integer> countMap = new HashMap<>();
        for(char ch : id.toCharArray()){
            int val = countMap.getOrDefault(ch, 0);
            countMap.put(ch, val+1);
        }

        char maxRepeating = getMaxRepeatning(countMap);
        int maxCharCount = countMap.get(maxRepeating);

        if(maxCharCount > (n+1)/2) return "";

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++) res.append(' ');

        int idx = 0;
        while(maxCharCount > 0){
            res.setCharAt(idx, maxRepeating);
            idx+=2;
            maxCharCount--;
        }
        countMap.remove(maxRepeating);

        for(char ch : countMap.keySet()){
            int freq = countMap.get(ch);
            while(freq > 0){
                idx = (idx >= n) ? 1 : idx;
                res.setCharAt(idx, ch);
                idx+=2;
                freq--;
            }
        }

        return res.toString();
    }
    private char getMaxRepeatning(Map<Character, Integer> hm){
        int max = 0;
        char ch = ' ';
        for(char c : hm.keySet()){
            if(hm.get(c) > max){
                max = hm.get(c);
                ch = c;
            }
        }

        return ch;
    }
}

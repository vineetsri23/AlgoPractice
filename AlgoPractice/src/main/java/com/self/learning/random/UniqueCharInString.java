package com.self.learning.random;

import java.util.Hashtable;


public class UniqueCharInString {
    public static void main(String[] args){
        String str = "adsw";
        String str1 = "wards";
        Hashtable<String, String> hashtable = new Hashtable<>();
        char[] chars =str.toCharArray();
        for(int i=0; i < str.length();i++){
            hashtable.put(String.valueOf(chars[i]),String.valueOf(chars[i]));
        }
        char[] chars1 = str1.toCharArray();
        for(int i=0; i < str1.length(); i++){
            if(hashtable.containsKey(String.valueOf(chars1[i]))){
                hashtable.remove(String.valueOf(chars1[i]));
            }
            else{
                System.out.println("Not a permutation");
                break;
            }
        }
    }
}

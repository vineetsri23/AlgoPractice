package com.self.learning.random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class USPhoneNumberMatcher {
    /*
     * Complete the find_phone_number function below.
     */
    static String find_phone_number(String text) {
        /*
         * Write your code here.
         */
        //123-456-7890
        //(123) 456-7890
        Pattern pattern1 = Pattern.compile("[(][0-9]{3}[)] [0-9]{3}[-][0-9]{4}");
        Matcher matcher1 = pattern1.matcher(text);
        Pattern pattern2 = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}");
        Matcher matcher2 = pattern2.matcher(text);
        if (matcher1.find()) {
            return matcher1.group(0);
        } else if (matcher2.find()) {
            return matcher2.group(0);
        } else {
            return "NONE";
        }

    }


    public static void main(String[] args) {

        final String text = "aaaa(123) 456-7890";

        String res = find_phone_number(text);

        System.out.println(res);

    }
}

package com.csa.returnship.stl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chunky15 on 3/19/15.
 * Limitations: It cannot handle strings that would convert to a number larger than the long max, or strings
 * represented in octal, hex, binary, or any other radix than decimal.
 */
public class StringToLong {
    public static long convertStringToLong(String s) {
        long num = 0;
        String pattern = "(-?)(\\d+)[lL]?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        if (m.find()) {
            String digitString = m.group(2);
            for (int i = 0; i < digitString.length(); i++) {
                int digit = Character.getNumericValue(digitString.charAt(i));
                num = (num * 10) + digit;
            }
            num = m.group(1).equals("-") ? -num : num;
        } else {
            throw new NumberFormatException("Invalid number string");
        }

        return num;
    }
}

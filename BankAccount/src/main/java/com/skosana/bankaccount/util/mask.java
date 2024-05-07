package com.skosana.bankaccount.util;

public class mask {

    public static String maskString(Long inputNo) {
        String inputNoStr = String.valueOf(inputNo);
        if(inputNoStr == null && inputNoStr.length() < 4) {
            return "NULL or Less than 4 characters";
        }
        int maskLen = inputNoStr.length() - 4;

        return "*".repeat(maskLen) + inputNoStr.substring(maskLen);
    }
}

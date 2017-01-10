package com.test.dto;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtil {

    public static String encode(String newPassword) {
        if (!StringUtils.isEmpty(newPassword)) {
            String encodedPassword = "";
            for (int i=0; i<newPassword.length(); i++){
                char letter = newPassword.charAt(i);
                int letterInAscii = (int)letter;
                encodedPassword+=String.valueOf(letterInAscii);
            }
            return encodedPassword;
        }
        else {
            return null;
        }
    }

    public static boolean hasNumberUpperLowerLetter(String password){
        Pattern regexPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).*$");
        Matcher matcher = regexPattern.matcher(password);
        return matcher.matches();
    }

    public static boolean hasNoMoreThanThreeCharacter(String password){
        char[] array = password.toCharArray();
        int countOfDigitsInLine = 0;
        int countOfLettersInLine = 0;
        for (char anArray : array) {
            if (Character.isDigit(anArray)) {
                countOfDigitsInLine++;
            } else {
                countOfLettersInLine++;
            }
        }
        return (countOfDigitsInLine < 4 && countOfLettersInLine < 4);
    }

    public static boolean hasLessThanThreeSameCharacter(String password){
        char[] array = password.toCharArray();
        int countOfRepeatableCharacter = 0;
        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i] == array[j]){
                    countOfRepeatableCharacter++;
                }
            }
        }
        return countOfRepeatableCharacter <3;
    }


}

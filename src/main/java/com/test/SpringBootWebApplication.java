package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class SpringBootWebApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootWebApplication.class, args);
//    }

    public static void main(String[] args) {

        System.out.println(hasNumberUpperLowerLetter("a1a2p3Z4ZL"));
        System.out.println(hasNoMoreThanFourCharacter("a12p3Z"));

    }

    public static boolean hasNumberUpperLowerLetter(String password){
        Pattern regexPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).*$");
        Matcher matcher = regexPattern.matcher(password);
        return matcher.matches();
    }

    public static boolean hasNoMoreThanFourCharacter(String password){
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
}

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

        String patternOne = "^(?=.*[0-9])+3{1,3}(?=.*[a-zA-Z])+3{1,3}(?=\\s+$)$";

        String hasNumberUpperAndLowerLetters = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{7,}$";
       // String hasNumberUpperAndLowerLetters = "^([0-9]{1,3})(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)$";
        String noMoreThanFourLetters = "(?=.*[a-zA-Z]{1,3})";
        String hasNumber = "^(.*?\\d){1,3}$";
        String test = "aaZZa133";
        Pattern regexPattern = Pattern.compile(hasNumber);
        Matcher matcher = regexPattern.matcher(test);
        System.out.println(matcher.matches());

    }
}

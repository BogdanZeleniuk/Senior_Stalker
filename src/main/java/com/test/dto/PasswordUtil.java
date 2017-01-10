package com.test.dto;

import org.springframework.util.StringUtils;

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

}

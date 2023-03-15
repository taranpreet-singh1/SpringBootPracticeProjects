package com.springboot.FirstSpringWebApp.Login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    public boolean authenticate(String username, String password){

        boolean isValidUsername = username.equalsIgnoreCase("singht");
        boolean isValidPassword = password.equals("Taran123");

        return isValidUsername && isValidPassword;
    }

}

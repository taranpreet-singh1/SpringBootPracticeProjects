package com.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1,"Taran", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Adam", LocalDate.now().minusYears(25)));
        users.add(new User(3,"Even", LocalDate.now().minusYears(20)));
    }

}

package com.springbootpractice.springboot1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-service")
    public CurrencyServiceConfiguration retrieveAllCourses() {
        return configuration;
    }

}

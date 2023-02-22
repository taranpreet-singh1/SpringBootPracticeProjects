package com.taranspring.springbootpractice2.examples.BusinessCalculationService;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Arrays;

@Component
public class BusinessCalc {

    private DataService dataService ;

    public BusinessCalc(DataService dataService){
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

package com.taranspring.springbootpractice2.examples.BusinessCalculationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[]{11,12,33,44,55};
    }
}

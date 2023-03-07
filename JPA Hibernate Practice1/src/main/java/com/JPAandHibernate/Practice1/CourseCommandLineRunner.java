package com.JPAandHibernate.Practice1;

import com.JPAandHibernate.Practice1.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"Learn Azure", "Someone"));
        repository.insert(new Course(2,"Learn devops", "Someone"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));

    }
}

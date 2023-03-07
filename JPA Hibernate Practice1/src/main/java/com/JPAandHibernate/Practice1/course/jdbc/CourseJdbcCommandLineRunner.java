package com.JPAandHibernate.Practice1.course.jdbc;

import com.JPAandHibernate.Practice1.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"Learn Azure", "Someone"));
        repository.insert(new Course(2,"Learn devops", "Someone"));

        repository.delete(1);

        System.out.println(repository.findById(2));

    }
}

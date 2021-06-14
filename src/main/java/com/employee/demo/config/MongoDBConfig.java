package com.employee.demo.config;

import com.employee.demo.document.Employee;
import com.employee.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@EnableMongoRepositories(basePackageClasses = EmployeeRepository.class)
@Configuration

public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository usersRepository) {
        return strings -> {
            usersRepository.save(new Employee(1, "Vineeth", "Kumar", "Tester", "16/2 Richie street Chennai", "Image Recognition", new Date(2018, 01, 20), true));
            usersRepository.save(new Employee(2, "Prem", "Kumar", "Developer", "16/2 Richie street Chennai", "Speech Recognition", new Date(2019, 12, 11), true));
        };
    }


}

package org.example.hw39;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        Customer byId = customerDao.getById(1);
        System.out.println("Customer with id 1: " + byId);
        System.out.println("All customers:");
        customerDao.getAll().forEach(System.out::println);
    }
}

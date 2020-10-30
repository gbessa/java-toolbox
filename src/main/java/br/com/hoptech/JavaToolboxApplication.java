package br.com.hoptech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaToolboxApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaToolboxApplication.class, args);
    }

}

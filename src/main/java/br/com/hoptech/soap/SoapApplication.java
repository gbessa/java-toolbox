package br.com.hoptech.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Source: https://spring.io/guides/gs/producing-web-service/
// Result can be seen at: http://localhost:8080/ws/countries.wsdl
@SpringBootApplication
public class SoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

}

package br.com.hoptech.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

public class ModelMapperUse {
    public static void main(String[] args) {

        //Order order = new Order(new Customer(new Name("Gustavo", "Bessa")), new Address("Apple Street", "London"));

        //ModelMapper modelMapper = new ModelMapper();
        //OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        //System.out.println(orderDTO.toString());

    }
}

@AllArgsConstructor
@Getter
@Setter
class Order {
    Customer customer;
    Address billingAddress;
}

@AllArgsConstructor
@Getter
@Setter
class Customer {
    Name name;
}

@AllArgsConstructor
@Getter
@Setter
class Name {

    String firstName;
    String lastName;
}

@AllArgsConstructor
@Getter
@Setter
class Address {
    String street;
    String city;
}

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
class OrderDTO {
    String customerFirstName;
    String customerLastName;
    String billingStreet;
    String billingCity;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", billingStreet='" + billingStreet + '\'' +
                ", billingCity='" + billingCity + '\'' +
                '}';
    }
}
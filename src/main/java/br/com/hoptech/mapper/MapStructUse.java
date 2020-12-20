package br.com.hoptech.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public class MapStructUse {

    public static void main(String[] args) {
        //Car car = new Car( "Morris", 5, CarType.SEDAN );

        //CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );

        //System.out.println(carDto);
    }

}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Car {

    private String make;
    private int numberOfSeats;
    private CarType type;

    //constructor, getters, setters etc.
}

enum CarType {
    SEDAN, COUPE;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class CarDto {

    private String make;
    private int seatCount;
    private String type;

    @Override
    public String toString() {
        return "CarDto{" +
                "make='" + make + '\'' +
                ", seatCount=" + seatCount +
                ", type='" + type + '\'' +
                '}';
    }
}

//@Mapper
//interface CarMapper {
//    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );
//
//    @Mapping(source = "numberOfSeats", target = "seatCount")
//    CarDto carToCarDto(Car car);
//}



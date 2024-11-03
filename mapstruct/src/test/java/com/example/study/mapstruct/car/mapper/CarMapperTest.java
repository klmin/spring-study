package com.example.study.mapstruct.car.mapper;

import com.example.study.mapstruct.car.dto.CarDto;
import com.example.study.mapstruct.car.dto.CompanyDto;
import com.example.study.mapstruct.car.dto.ReservationDto;
import com.example.study.mapstruct.car.entity.Car;
import com.example.study.mapstruct.car.enums.EnumCarColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarMapperTest {

    @Autowired
    private CarMapper carMapper;

    private CarDto carDTO;
    private CompanyDto companyDTO;
    private ReservationDto reservationDTO;
    private Car car;

    @BeforeEach
    void setUp() {

        Long id = 1L;
        String name = "소나타";
        Integer price = 3000;
        List<String> options = List.of("Bluetooth", "BlackBox", "Aircon");
        EnumCarColor color = EnumCarColor.White;
        LocalDateTime regDttm = LocalDateTime.now();

        car = Car.builder().name(name).price(price).options(options).color(color).regDttm(regDttm).build();
        carDTO = CarDto.builder().id(id).name(name).price(price).options(options).color(color).regDttm(regDttm).build();
        companyDTO = CompanyDto.builder().companyId(3L).name("현대").build();
        reservationDTO = ReservationDto.builder().reservationName("홍길동").reservationMobile("01012345678").build();
    }

    @Test
    void toEntity(){

        Car entity = carMapper.toEntity(carDTO, companyDTO, reservationDTO, "테스트메모", "테스트파라미터");

        System.out.println("car : "+entity);
        assertEquals(entity.getColor(), carDTO.getColor());
        assertEquals(entity.getName(), carDTO.getName());
        assertEquals(entity.getCompanyName(), companyDTO.getName());
        assertEquals(entity.getReservation().getMobile(), reservationDTO.getReservationMobile());

    }

    @Test
    void toDto(){

        CarDto dto = carMapper.toDto(car);
        assertEquals(dto.getName(), car.getName());
        assertEquals(dto.getPrice(), car.getPrice());
        assertEquals(dto.getOptions(), car.getOptions());
        assertEquals(dto.getColor(), car.getColor());
    }

}
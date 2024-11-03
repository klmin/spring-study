package com.example.study.mapstruct.car.mapper;



import com.example.study.mapstruct.car.dto.CarDto;
import com.example.study.mapstruct.car.dto.CompanyDto;
import com.example.study.mapstruct.car.dto.ReservationDto;
import com.example.study.mapstruct.car.entity.Car;
import com.example.study.mapstruct.car.enums.EnumCarColor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Mapper(nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueCheckStrategy= NullValueCheckStrategy.ALWAYS,
        imports = {UUID.class, EnumCarColor.class})
public interface CarMapperStatic {
    CarMapperStatic INSTANCE = Mappers.getMapper(CarMapperStatic.class);

    @Mapping(target = "tempVehicleId", defaultExpression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "description", expression = "java(buildDescription(carDTO))")
    @Mapping(target = "status", defaultValue = "NORMAL")
    @Mapping(target = "name", source="carDTO.name")
    @Mapping(target = "color", defaultExpression = "java(EnumCarColor.BLUE)")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stringDate", source="carDTO.regDttm", qualifiedByName = "localDateTimeToString")
    @Mapping(target = "companyName", source="companyDTO.name")
    @Mapping(target = "notes", source="note")
    @Mapping(target = "reservation.name", source="reservationDTO.reservationName")
    @Mapping(target = "reservation.mobile", source="reservationDTO.reservationMobile")
    Car toEntity(CarDto carDTO, CompanyDto companyDTO, ReservationDto reservationDTO, String note, String testParameter);

    CarDto toDto(Car car);



    default String buildDescription(CarDto carDTO) {
        return carDTO.getName() + ", "+ carDTO.getPrice() +"원";
    }
    default String buildDescription2(CarDto carDTO) {
        return carDTO.getName() + ", "+ carDTO.getPrice() +"원";
    }

    @Named("localDateTimeToString")
    default String localDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

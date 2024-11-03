package com.example.study.mapstruct.car.mapper;


import com.example.study.mapstruct.car.dto.UserDto;
import com.example.study.mapstruct.car.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperStatic extends GenericMapper<UserDto, User> {
    UserMapperStatic INSTANCE = Mappers.getMapper(UserMapperStatic.class);
}

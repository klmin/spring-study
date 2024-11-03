package com.example.study.mapstruct.car.mapper;


import com.example.study.mapstruct.car.dto.UserDto;
import com.example.study.mapstruct.car.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDto, User> {
}

package com.example.study.mapstruct.car.entity;


import com.example.study.mapstruct.car.enums.EnumUserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class User {
    private Long userId;
    private String userName;
    private Integer age;
    private EnumUserStatus status;
}

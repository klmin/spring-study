package com.example.study.mapstruct.car.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CompanyDto {

    private Long companyId;
    private String name;
}

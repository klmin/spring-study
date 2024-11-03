package com.example.study.mapstruct.car.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReservationDto {
    private String reservationName;
    private String reservationMobile;
}

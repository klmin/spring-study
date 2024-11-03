package com.example.study.mapstruct.car.entity;



import com.example.study.mapstruct.car.enums.EnumCarColor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@ToString
public class Car {
    private Long id;
    private String name;
    private Integer price;
    private String description;
    private List<String> options;
    private EnumCarColor color;
    private LocalDateTime regDttm;
    private String status;
    private String tempVehicleId;
    private String stringDate;
    private Long companyId;
    private String companyName;
    private Reservation reservation;
    private String notes;
    private String testParameter;
    private Map<String, Object> testa;
    private List<String> testb;
    @Builder.Default
    private Map<String, Object> testc = new HashMap<>();
    @Builder.Default
    private List<String> testd = new ArrayList<>();
    private User user;
    private Integer testInteger;

}

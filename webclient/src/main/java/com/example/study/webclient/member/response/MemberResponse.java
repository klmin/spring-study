package com.example.study.webclient.member.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {

    private Long id;
    private String name;
    private Integer age;
    private List<String> hobby;
    private Map<String, Object> score;
    private LocalDateTime createdDttm;
    private LocalDate createdDt;
}

package com.example.study.restclient.api.server.member.request;



import com.example.study.restclient.api.server.member.response.MemberResponse;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberRequest {

    private Long id;
    private String name;
    private Integer age;
    private List<String> hobby;
    private Map<String, Object> score;
    private LocalDateTime createdDttm;
    private LocalDate createdDt;

    public MemberResponse toResponse() {
        return MemberResponse.builder()
                .id(id)
                .name(name)
                .age(age)
                .hobby(hobby)
                .score(score)
                .createdDttm(createdDttm)
                .createdDt(createdDt)
                .build();
    }

    public MemberResponse toResponse(Long id) {
        return MemberResponse.builder()
                .id(id)
                .name(name)
                .age(age)
                .hobby(hobby)
                .score(score)
                .createdDttm(createdDttm)
                .createdDt(createdDt)
                .build();
    }
}

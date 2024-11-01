package com.example.study.restclient.restclient.client;


import com.example.study.restclient.api.response.ApiResponse;
import com.example.study.restclient.member.request.MemberRequest;
import com.example.study.restclient.member.response.MemberResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@HttpExchange("/members")
public interface TestClient {

    @GetExchange
    ResponseEntity<ApiResponse<MemberResponse>> get(@RequestParam Long id,
                                                    @RequestParam String name,
                                                    @RequestParam Integer age,
                                                    @RequestParam List<String> hobby,
                                                    @RequestParam Map<String, Object> score,
                                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdDttm,
                                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createdDt);


    @PostExchange("/{id}")
    ResponseEntity<ApiResponse<MemberResponse>> post(@PathVariable Long id, @RequestBody MemberRequest request);

    @PostExchange("/{id}")
    ApiResponse<MemberResponse> postBody(@PathVariable Long id, @RequestBody MemberRequest request);

    @PutExchange("/{id}")
    ResponseEntity<ApiResponse<MemberResponse>> put(@PathVariable Long id, @RequestBody MemberRequest request);

    @PatchExchange("/{id}")
    ResponseEntity<ApiResponse<MemberResponse>> patch(@PathVariable Long id, @RequestBody MemberRequest request);

    @DeleteExchange("/{id}")
    ResponseEntity<ApiResponse<MemberResponse>> delete(@PathVariable Long id);

}

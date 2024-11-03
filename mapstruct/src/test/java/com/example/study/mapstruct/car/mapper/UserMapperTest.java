package com.example.study.mapstruct.car.mapper;

import com.example.study.mapstruct.car.dto.UserDto;
import com.example.study.mapstruct.car.entity.User;
import com.example.study.mapstruct.car.enums.EnumUserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void toEntity(){

        String userName = "홍길동";
        Long userId = 1L;
        EnumUserStatus status = EnumUserStatus.ACTIVE;
        Integer age = 20;

        UserDto dto = UserDto.builder().userId(userId).userName(userName).status(status).age(age).build();

        User user = userMapper.toEntity(dto);

        assertEquals(user.getUserId(), dto.getUserId());
        assertEquals(user.getUserName(), dto.getUserName());
        assertEquals(user.getStatus(), dto.getStatus());
        assertEquals(user.getAge(), dto.getAge());

    }

    @Test
    void toDto(){

        String userName = "홍길동2";
        Long userId = 2L;
        EnumUserStatus status = EnumUserStatus.DELETED;
        Integer age = 23;

        User user = User.builder().userId(userId).userName(userName).status(status).age(age).build();
        UserDto dto = userMapper.toDto(user);

        assertEquals(user.getUserId(), dto.getUserId());
        assertEquals(user.getUserName(), dto.getUserName());
        assertEquals(user.getStatus(), dto.getStatus());
        assertEquals(user.getAge(), dto.getAge());
    }

}
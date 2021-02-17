package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.User;
import com.gmail.yuramitryahin.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}

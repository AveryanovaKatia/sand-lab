package ru.project.user.mapper;

import org.springframework.stereotype.Component;
import ru.project.user.dto.UserRequestDto;
import ru.project.user.dto.UserResponseDto;
import ru.project.user.dto.UserResponseLongDto;
import ru.project.user.model.User;

@Component
public class UserMapper {

    public static User toUser(UserRequestDto userRequestDto) {

        final User user = new User();

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setAge(userRequestDto.getAge());
        user.setGender(userRequestDto.getGender());

        return user;

    }

    public static UserResponseDto toUserResponseDto(User user) {

        final UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());

        return userResponseDto;
    }

    public static UserResponseLongDto toUserResponseLongDto(User user) {

        final UserResponseLongDto userResponseLongDto = new UserResponseLongDto();

        userResponseLongDto.setId(user.getId());
        userResponseLongDto.setName(user.getName());
        userResponseLongDto.setEmail(user.getEmail());
        userResponseLongDto.setAge(user.getAge());
        userResponseLongDto.setGender(user.getGender());

        return userResponseLongDto;
    }
}

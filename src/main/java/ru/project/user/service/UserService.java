package ru.project.user.service;

import ru.project.user.dto.UserRequestDto;
import ru.project.user.dto.UserResponseDto;
import ru.project.user.dto.UserResponseLongDto;

import java.util.List;

public interface UserService {

    UserResponseDto save(UserRequestDto userRequestDto);

    UserResponseLongDto getUser(Long id);

    List<UserResponseDto> getShortUsers(List<Long> ids);

    List<UserResponseLongDto> getUsers(List<Long> ids);

    void delete(Long userId);
}

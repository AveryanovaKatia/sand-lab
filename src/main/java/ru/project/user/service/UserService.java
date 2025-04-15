package ru.project.user.service;

import ru.project.user.dto.UserRequestDto;
import ru.project.user.dto.UserResponseDto;

public interface UserService {

    UserResponseDto save(UserRequestDto userRequestDto);
}

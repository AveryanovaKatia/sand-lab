package ru.project.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.user.dto.UserRequestDto;
import ru.project.user.dto.UserResponseDto;
import ru.project.user.mapper.UserMapper;
import ru.project.user.repository.UserRepository;
import ru.project.user.model.User;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {

        log.info("Запрос на добавление пользователя");
        final User saveUser = userRepository.save(UserMapper.toUser(userRequestDto));

        log.info("Пользователь успешно добавлен под id {}", saveUser.getId());
        return UserMapper.toUserResponseDto(saveUser);
    }
}

package ru.project.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.exceptions.NotFoundException;
import ru.project.user.dto.UserRequestDto;
import ru.project.user.dto.UserResponseDto;
import ru.project.user.dto.UserResponseLongDto;
import ru.project.user.mapper.UserMapper;
import ru.project.user.repository.UserRepository;
import ru.project.user.model.User;

import java.util.List;
import java.util.Objects;

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

    @Override
    public UserResponseLongDto getUser(Long id) {

        log.info("Запрос на получение пользователя с id {}", id);
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Пользователя с id = {} нет." + id));

        log.info("Пользователь успешно найден под id {}", id);
        return UserMapper.toUserResponseLongDto(user);
    }

    @Override
    public List<UserResponseDto> getShortUsers(List<Long> ids) {
        log.info("Запрос на получение короткой информации o пользователях");
        final List<User> users = getUsersByIds(ids);

        return users.stream().map(UserMapper::toUserResponseDto).toList();
    }

    @Override
    public List<UserResponseLongDto> getUsers(List<Long> ids) {

        log.info("Запрос на получение полной информации o пользователях");
        final List<User> users = getUsersByIds(ids);

        return users.stream().map(UserMapper::toUserResponseLongDto).toList();
    }

    @Override
    public void delete(Long userId) {

        log.info("Запрос на удаление пользователя с id {}", userId);
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователя с id = {} нет." + userId));
        userRepository.deleteById(userId);
        log.info("Пользователь с id {} успешно удален ", userId);
    }

    private List<User> getUsersByIds(List<Long> ids) {

        final List<User> users;
        if (Objects.isNull(ids) || ids.isEmpty()) {
            users = userRepository.findAll();
            log.info("Получен списк всех пользователей");
        } else {
            users = userRepository.findAllById(ids);
            log.info("Получен списк пользователей по заданным id");
        }
        return  users;
    }
}

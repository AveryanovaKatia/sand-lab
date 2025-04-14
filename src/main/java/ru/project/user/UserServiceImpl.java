package ru.project.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {

        log.info("Запрос на добавление пользователя");
        final User saveUser = userRepository.save(user);

        log.info("Пользователь успешно добавлен под id {}", user.getId());
        return saveUser;
    }
}

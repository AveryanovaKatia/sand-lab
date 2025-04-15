package ru.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

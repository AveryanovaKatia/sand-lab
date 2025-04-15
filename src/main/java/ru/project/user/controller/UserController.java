package ru.project.user.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.project.user.dto.UserRequestDto;
import ru.project.user.dto.UserResponseDto;
import ru.project.user.service.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponseDto> save(@RequestBody @Valid UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userRequestDto));
    }
}
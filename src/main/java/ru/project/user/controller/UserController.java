package ru.project.user.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.project.user.dto.UserRequestDto;
import ru.project.user.dto.UserResponseDto;
import ru.project.user.dto.UserResponseLongDto;
import ru.project.user.service.UserService;

import java.util.List;

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

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponseLongDto> getUser(@PathVariable @Valid Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    @GetMapping("/short")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserResponseDto>> getShortUsers(@RequestParam List<Long> ids) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getShortUsers(ids));
    }

    @GetMapping("/long")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserResponseLongDto>> getUsers(@RequestParam List<Long> ids) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers(ids));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> delete(@PathVariable @Valid Long userId) {
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Пользователь удален: " + userId);
    }


}
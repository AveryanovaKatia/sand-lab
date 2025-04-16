package ru.project.user.dto;

import lombok.Data;
import ru.project.user.model.Gender;

@Data
public class UserResponseLongDto {

    private Long id;

    private String name;

    private String email;

    private int age;

    private Gender gender;
}

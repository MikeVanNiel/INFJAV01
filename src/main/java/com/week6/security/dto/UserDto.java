package com.week6.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
public class UserDto {
    private Long id;

    @NotNull
    @Size(min = 2)
    private String username;

    private String address;

    private List<UserDto> friends;
}

package com.week6.security.controller;

import com.week6.security.dto.UserDto;
import com.week6.security.model.User;
import com.week6.security.service.UserService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {

    UserService userService;
    ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Week 6: Spring Security</h1>");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> get() {
        List<UserDto> userDtos = userService
                .findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) throws ParseException {
        User user = this.userService.createUser(convertToEntity(userDto));
        return new ResponseEntity<UserDto>(convertToDto(user), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) throws ParseException {
        User user = this.userService.updateUser(convertToEntity(userDto));
        return new ResponseEntity<UserDto>(convertToDto(user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }


    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Admin page</h1>");
    }


    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto userDto) throws ParseException {
        return modelMapper.map(userDto, User.class);
    }
}

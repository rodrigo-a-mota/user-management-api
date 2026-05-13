package com.rodrigo.user_management_api.controller;

import com.rodrigo.user_management_api.dto.UserRequestDTO;
import com.rodrigo.user_management_api.dto.UserResponseDTO;
import com.rodrigo.user_management_api.mapper.UserMapper;
import com.rodrigo.user_management_api.model.User;
import com.rodrigo.user_management_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequest) {
        User savedUser = userService.createUser(UserMapper.toEntity(userRequest));
        return ResponseEntity.ok(UserMapper.toDTO(savedUser));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers()
                .stream()
                .map(UserMapper::toDTO)
                .toList();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(UserMapper.toDTO(userService.getUserById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequest) {
        User updatedUser = userService.updateUser(id, UserMapper.toEntity(userRequest));

        return ResponseEntity.ok(UserMapper.toDTO(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

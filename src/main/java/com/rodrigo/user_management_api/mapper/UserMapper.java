package com.rodrigo.user_management_api.mapper;

import com.rodrigo.user_management_api.dto.UserRequestDTO;
import com.rodrigo.user_management_api.dto.UserResponseDTO;
import com.rodrigo.user_management_api.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO userDTO = new UserResponseDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}

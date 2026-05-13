package com.rodrigo.user_management_api.dto;

import lombok.Getter;
import lombok.Setter;

public class UserResponseDTO {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;
}

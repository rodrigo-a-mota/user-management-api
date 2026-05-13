package com.rodrigo.user_management_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 100)
    private String name;

    @Getter
    @Setter
    @NotBlank
    @Email
    @Size(max = 150)
    private String email;

    @Getter
    @Setter
    @NotBlank
    @Size(min = 6)
    private String password;
}

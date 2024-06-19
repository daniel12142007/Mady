package com.example.mady.dto.request;

import com.example.mady.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String email;
    private String password;
    @JsonIgnore
    private Role role;
}
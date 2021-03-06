package com.namnd.Englishbackend.payloads.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:54 PM
 */

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public LoginRequest() {
    }
}

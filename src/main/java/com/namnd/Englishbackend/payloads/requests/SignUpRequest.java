package com.namnd.Englishbackend.payloads.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:55 PM
 */

@Getter
@Setter
public class SignUpRequest {

    @NotBlank
    @Size(max = 50)
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public SignUpRequest() {
    }
}

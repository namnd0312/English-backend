package com.namnd.Englishbackend.payloads.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:55 PM
 */

@Getter
@Setter
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String email;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
        this.roles = roles;
    }
}

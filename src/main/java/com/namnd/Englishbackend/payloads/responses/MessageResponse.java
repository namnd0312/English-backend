package com.namnd.Englishbackend.payloads.responses;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:55 PM
 */

@Getter
@Setter
public class MessageResponse {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse() {
    }
}

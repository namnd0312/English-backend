package com.namnd.Englishbackend.payloads.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nam.nd
 * @created 07/03/2021 - 11:03 AM
 */

@Getter
@Setter

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseBody <E> {

    private String code;

    private String status;

    private String message;

    private E data;

    public ResponseBody() {
    }

    public ResponseBody(String status, E data) {
        this.status = status;
        this.data = data;
    }

    public ResponseBody(String code, String status, E data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public ResponseBody(String code, String status, String message, E data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}

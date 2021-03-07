package com.namnd.Englishbackend.securities;

import org.springframework.security.core.AuthenticationException;

/**
 * ITSOL DEV
 *
 * @author maint on 5/20/2020
 */
public class UserTokenInvalidException extends AuthenticationException {
    public UserTokenInvalidException(String msg) {
        super(msg);
    }
}

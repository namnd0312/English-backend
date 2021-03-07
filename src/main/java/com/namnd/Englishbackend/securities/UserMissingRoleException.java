package com.namnd.Englishbackend.securities;

import org.springframework.security.core.AuthenticationException;

/**
 * ITSOL DEV
 *
 * @author maint on 5/20/2020
 */
public class UserMissingRoleException extends AuthenticationException {
    public UserMissingRoleException(String msg) {
        super(msg);
    }
}

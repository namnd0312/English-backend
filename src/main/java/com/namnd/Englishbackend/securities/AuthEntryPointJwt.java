package com.namnd.Englishbackend.securities;

import com.namnd.Englishbackend.configs.LogicException;
import javafx.fxml.LoadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.namnd.Englishbackend.enums.MessageEnum.UN_AUTHORIZE;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:11 PM
 */

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException {

//        throw new IOException("UN AUTHORISE", );
//        logger.error("Unauthorized error: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unautdgsgsgseghorized");
    }
}

package com.namnd.Englishbackend.controllers;

import com.namnd.Englishbackend.Utils.Response;
import com.namnd.Englishbackend.models.ERole;
import com.namnd.Englishbackend.models.Role;
import com.namnd.Englishbackend.models.User;
import com.namnd.Englishbackend.payloads.requests.LoginRequest;
import com.namnd.Englishbackend.payloads.requests.SignUpRequest;
import com.namnd.Englishbackend.payloads.responses.JwtResponse;
import com.namnd.Englishbackend.repositories.RoleRepository;
import com.namnd.Englishbackend.repositories.UserRepository;
import com.namnd.Englishbackend.securities.JwtUtils;
import com.namnd.Englishbackend.securities.UserMissingRoleException;
import com.namnd.Englishbackend.securities.UserTokenInvalidException;
import com.namnd.Englishbackend.securities.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;

import static com.namnd.Englishbackend.enums.MessageEnum.*;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:09 PM
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
       try{
           Authentication authentication = authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

           SecurityContextHolder.getContext().setAuthentication(authentication);
           String jwt = jwtUtils.generateJwtToken(authentication);

           UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

           List<String> roles = userDetails.getAuthorities()
                   .stream()
                   .map(GrantedAuthority::getAuthority)
                   .collect(Collectors.toList());

           JwtResponse jwtResponse = new JwtResponse(jwt,
                   userDetails.getId(),
                   userDetails.getEmail(),
                   roles);

           return new ResponseEntity<>(Response.ok(jwtResponse), HttpStatus.OK);
       }catch (Exception ex){
           return handleError(ex);
       }
    }


    private ResponseEntity<Object> handleError(Exception ex) {
        Throwable cause = ex.getCause();

         if(ex instanceof UserMissingRoleException) {
            return new ResponseEntity<>(Response.error(USER_MISSING_ROLE), HttpStatus.OK);
        } else if(ex instanceof UserTokenInvalidException) {
            return new ResponseEntity<>(Response.error(USER_TOKEN_INVALID), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(Response.error(UN_AUTHORIZE), HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(Response.error(EMAIL_ALREADY_IN_USE), HttpStatus.BAD_REQUEST);
        }

        // Create new user's account
        User user = new User(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return new ResponseEntity<>(Response.ok(), HttpStatus.OK);
    }
}

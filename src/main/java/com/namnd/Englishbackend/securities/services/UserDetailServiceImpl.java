package com.namnd.Englishbackend.securities.services;

import com.namnd.Englishbackend.models.User;
import com.namnd.Englishbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:13 PM
 */


/**
 * we get full custom User object using UserRepository,
 * then we build a UserDetails object using static build() method.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + s));

        return UserDetailsImpl.build(user);
    }
}

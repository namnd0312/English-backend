package com.namnd.Englishbackend.repositories;

import com.namnd.Englishbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:10 PM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);

    Boolean existsByEmail(String email);
}

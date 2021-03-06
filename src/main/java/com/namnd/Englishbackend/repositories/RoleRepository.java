package com.namnd.Englishbackend.repositories;

import com.namnd.Englishbackend.models.ERole;
import com.namnd.Englishbackend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nam.nd
 * @created 06/03/2021 - 11:10 PM
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}

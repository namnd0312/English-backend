package com.namnd.Englishbackend.repositories;

import com.namnd.Englishbackend.models.IrregularVerb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nam.nd
 * @created 10/04/2021 - 9:33 PM
 */

@Repository
public interface IrregularVebRepository extends JpaRepository<IrregularVerb, Long> {
}

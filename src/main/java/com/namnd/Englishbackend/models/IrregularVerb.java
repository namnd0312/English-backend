package com.namnd.Englishbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nam.nd
 * @created 10/04/2021 - 4:04 PM
 */

@Getter
@Setter
@Entity
@Table(name = "irregular_verb")
public class IrregularVerb implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "verb", nullable = false, length = 100)
    private String verb;

    @Column(name = "verb1", nullable = false, length = 100)
    private String verb1;

    @Column(name = "verb2", nullable = false, length = 100)
    private String verb2;

    @Column(name = "spelling_verb", nullable = false, length = 100)
    private String spellingVerb;

    @Column(name = "spelling_verb1", nullable = false, length = 100)
    private String spellingVerb1;

    @Column(name = "spelling_verb2", nullable = false, length = 100)
    private String spellingVerb2;

    @Column(name = "meaning", nullable = false, length = 100)
    private String meaning;
}

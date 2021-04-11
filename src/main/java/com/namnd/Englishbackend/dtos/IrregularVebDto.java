package com.namnd.Englishbackend.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author nam.nd
 * @created 10/04/2021 - 10:02 PM
 */

@Getter
@Setter
public class IrregularVebDto implements Serializable {

    private String id;

    @NotEmpty
    @Size(max = 100)
    private String verb;

    @NotEmpty
    @Size(max = 100)
    private String verb1;

    @NotEmpty
    @Size(max = 100)
    private String verb2;

    @NotEmpty
    @Size(max = 100)
    private String spellingVerb;

    @NotEmpty
    @Size(max = 100)
    private String spellingVerb1;

    @NotEmpty
    @Size(max = 100)
    private String spellingVerb2;

    @NotEmpty
    @Size(max = 100)
    private String meaning;
}

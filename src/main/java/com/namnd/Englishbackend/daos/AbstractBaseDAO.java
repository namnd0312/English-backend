package com.namnd.Englishbackend.daos;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;

/**
 * @author nam.nd
 * @created 08/03/2021 - 9:53 AM
 */
public abstract class AbstractBaseDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Get current session from EntityManager
     *
     * @return Session
     */
    protected Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
        return namedParameterJdbcTemplate;
    }
}

package edu.javaproject.dao;

import edu.javaproject.domain.CountryArea;
import edu.javaproject.domain.PassportOffice;
import edu.javaproject.domain.RegisterOffice;
import edu.javaproject.domain.Street;
import edu.javaproject.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffices(String AreaId) throws DaoException;
    List<RegisterOffice> findRegisterOffices(String AreaId) throws DaoException;

    List<CountryArea> findArea(String AreaId) throws DaoException;

    }


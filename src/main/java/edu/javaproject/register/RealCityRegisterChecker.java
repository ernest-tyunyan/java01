package edu.javaproject.register;

import edu.javaproject.exception.CityRegisterException;
import edu.javaproject.exception.TransportException;
import edu.javaproject.register2.CityRegisterResponse;
import edu.javaproject.domain.Person;

public class RealCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {
        return null;
    }

}

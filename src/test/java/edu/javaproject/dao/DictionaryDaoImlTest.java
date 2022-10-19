package edu.javaproject.dao;

import edu.javaproject.domain.CountryArea;
import edu.javaproject.domain.PassportOffice;
import edu.javaproject.domain.RegisterOffice;
import edu.javaproject.domain.Street;
import edu.javaproject.exception.DaoException;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMConfiguration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDaoImlTest {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImlTest.class);

    @BeforeClass
    public static void startUp() throws Exception {

        DBInit.startUp();

    }


    @Test
    public void testStreet() throws DaoException {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now();
        logger.debug("TEST{} {} ", dt1, dt2);

        List<Street> d = new DictionaryDaoIml().findStreets("улица");
        Assert.assertTrue(d.size() == 0);

    }

    @Test
    public void testPassportOffice() throws DaoException {

        List<PassportOffice> po = new DictionaryDaoIml().findPassportOffices("010020000000");
        Assert.assertTrue(po.size() == 0);

    }

    @Test
    public void testRegisterOffice() throws DaoException {

        List<RegisterOffice> ro = new DictionaryDaoIml().findRegisterOffices("010010000000");
        Assert.assertTrue(ro.size() == 0);
    }

@Test
    public void testArea() throws DaoException {
    List<CountryArea> ca1 = new DictionaryDaoIml().findArea("");
    Assert.assertTrue(ca1.size() == 0);
    List<CountryArea> ca2 = new DictionaryDaoIml().findArea("020000000000");
    Assert.assertTrue(ca2.size() == 0);
    List<CountryArea> ca3 = new DictionaryDaoIml().findArea("020010000000");
    Assert.assertTrue(ca3.size() == 0);
    List<CountryArea> ca4 = new DictionaryDaoIml().findArea("020010010000");
    Assert.assertTrue(ca4.size() == 0);
}
}

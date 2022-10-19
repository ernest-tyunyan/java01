package edu.javaproject.dao;

import edu.javaproject.config.Config;
import edu.javaproject.exception.DaoException;
import edu.javaproject.domain.CountryArea;
import edu.javaproject.domain.PassportOffice;
import edu.javaproject.domain.RegisterOffice;
import edu.javaproject.domain.Street;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoIml implements DictionaryDao {

    private static final Logger logger = LoggerFactory.getLogger(StudentOrderDaoImpl.class);

    private static final String GET_STREET = "select street_code, street_name from jc_street where upper(street_name) like upper(?)";
    private static final String GET_PASSPORT = "select * from jc_passport_office where p_office_area_id = ?";
    private static final String GET_REGISTER = "select * from jc_register_office where r_office_area_id = ?";

    private static final String GET_AREA = "select  * from jc_country_struct where area_id like ? and area_id  <> ?";

    private Connection getConnection() throws SQLException {
       return ConnectionBuilder.getConnection();
    }


    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();


        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(GET_STREET)) {

            stmt.setString(1, "%" + pattern + "%");


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                result.add(str);

            }


        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<PassportOffice> findPassportOffices(String AreaId) throws DaoException {
        List<PassportOffice> result = new LinkedList<>();


        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(GET_PASSPORT)) {

            stmt.setString(1, AreaId);


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PassportOffice str = new PassportOffice(rs.getLong("p_office_id"), rs.getString("p_office_area_id"), rs.getString("p_office_name"));
                result.add(str);

            }


        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);

        }
        return result;
    }


    @Override
    public List<RegisterOffice> findRegisterOffices(String AreaId) throws DaoException {
        List<RegisterOffice> result = new LinkedList<>();


        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(GET_REGISTER)) {

            stmt.setString(1, AreaId);


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RegisterOffice str = new RegisterOffice(rs.getLong("r_office_id"), rs.getString("r_office_area_id"), rs.getString("r_office_name"));
                result.add(str);

            }


        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);

        }
        return result;


    }

    @Override
    public List<CountryArea> findArea(String areaId) throws DaoException {
        List<CountryArea> result = new LinkedList<>();


        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(GET_AREA)) {

            String param1 = buildParam(areaId);
            String param2 = areaId;

            stmt.setString(1, param1);
            stmt.setString(2, param2);



            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CountryArea ca = new CountryArea(rs.getString("area_id"), rs.getString("area_name"));
                result.add(ca);

            }


        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new DaoException(ex);

        }
      return result;

    }

    private String buildParam(String areaId) throws SQLException {


        if (areaId == null || areaId.trim().isEmpty()) {
            return "__0000000000";
        }else if (areaId.endsWith("0000000000")) {
            return  areaId.substring(0, 2) + "____000000";

        } else if (areaId.endsWith("0000000")) {
            return areaId.substring(0, 5) + "___0000";
        } else if (areaId.endsWith("0000")) {
            return areaId.substring(0, 8) + "____";

        }
        throw new SQLException("Invalid parameter 'area_id':" + areaId);

        }


    }





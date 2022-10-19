package edu.javaproject.dao;

import edu.javaproject.domain.StudentOrder;
import edu.javaproject.exception.DaoException;

import java.util.List;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder so) throws DaoException;

    List<StudentOrder> getStudentOrders() throws DaoException;

    }


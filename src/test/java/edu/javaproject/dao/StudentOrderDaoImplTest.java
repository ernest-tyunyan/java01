package edu.javaproject.dao;

import edu.javaproject.domain.*;
import edu.javaproject.exception.DaoException;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class StudentOrderDaoImplTest {

    @Test
    public void saveStudentOrder() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test(expected = DaoException.class)
    public void saveStudentOrderError() throws DaoException {

            StudentOrder so = buildStudentOrder(10);
            so.getHusband().setSurName(null);
            Long id = new StudentOrderDaoImpl().saveStudentOrder(so);

    }


    @Test
    public void getStudentOrders() throws DaoException {
        List<StudentOrder> list = new StudentOrderDaoImpl().getStudentOrders();

    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (12345605 + id));
        so.setMarriageDate(LocalDate.of(2015, 6, 3));
        RegisterOffice ro = new RegisterOffice(2L, "", "");
        so.setMarriageOffice(ro);

        Street street = new Street(2L, "First street");

        Address address = new Address(street, "52A", "64", "355041");

// Муж
        Adult husband = new Adult("Васильев", "Андрей", "Генадьевич", LocalDate.of(1975, 3,10));
        husband.setPassportSeria("" + (10001 + id));
        husband.setStudentId("" + (15462 + id));
        husband.setIssueDate(LocalDate.of(2015, 7, 3));
        husband.setPassportSNumber("" + (187641 + id));
        PassportOffice po1 = new PassportOffice(2L, "", "");
        husband.setIssueDepartment(po1);
        husband.setAddress(address);
        husband.setUniversity(new University(2L, ""));
        husband.setStudentId("HH12345");

// Жена


        Adult wife = new Adult("Васильева", "Жанна", "Петровна", LocalDate.of(1977, 5, 9));
        wife.setPassportSeria("" + (10001 + id));
        wife.setStudentId("" + (15462 + id));
        wife.setIssueDate(LocalDate.of(2015, 7, 3));
        wife.setPassportSNumber("" + (187644 + id));
        PassportOffice po2 = new PassportOffice(1L, "", "");
        wife.setIssueDepartment(po2);
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));
        wife.setStudentId("WW12345");



// Ребенок
        Child child1 = new Child("Васильв", "Федор", "Андреевич", LocalDate.of(2007, 2,4));
        child1.setAddress(address);
        child1.setIssueDate(LocalDate.of(2011, 4, 10));
        RegisterOffice ro1 = new RegisterOffice(1L, "", "");
        child1.setIssueDepartment(ro1);
        child1.setCertificateNumber("" + (132373 + id));


        // Ребенок
        Child child2= new Child("Васильв", "Кирилл", "Андреевич", LocalDate.of(2008, 9,20));
        child2.setAddress(address);
        child2.setIssueDate(LocalDate.of(2015, 6, 9));
        RegisterOffice ro2 = new RegisterOffice(1L, "", "");
        child2.setIssueDepartment(ro2);
        child2.setCertificateNumber("" + (23237 + id));

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);






        return so;
    }
}
package edu.javaproject.domain;

import java.time.LocalDate;

public class Adult extends Person {
    private String passportSeria;
    private String passportSNumber;
    private LocalDate issueDate;
    private PassportOffice issueDepartment;

    private String StudentId;
    private University university;

    public Adult(String surName, String givenName, String patronymic, LocalDate dateOfBirth) {
        super(surName, givenName, patronymic, dateOfBirth);
    }
    public Adult() {

    }


    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportSNumber() {
        return passportSNumber;
    }

    public void setPassportSNumber(String passportSNumber) {
        this.passportSNumber = passportSNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PassportOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(PassportOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Adult{" +
                "passportSeria='" + passportSeria + '\'' +
                ", passportSNumber='" + passportSNumber + '\'' +
                ", issueDate=" + issueDate +
                ", issueDepartment=" + issueDepartment +
                ", StudentId='" + StudentId + '\'' +
                ", university=" + university +
                "} " + super.toString();
    }
}

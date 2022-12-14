package edu.javaproject.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class StudentOrder {
    private long studentOrderId;

    private LocalDateTime studentOrderDate;

    private StudentOrderStatus studentOrderStatus;
    private Adult husband;
    private Adult wife;

    private List<Child> children;

    private String marriageCertificateId;

    private LocalDate marriageDate;

    private RegisterOffice marriageOffice;

    public LocalDateTime getStudentOrderDate() {
        return studentOrderDate;
    }

    public void setStudentOrderDate(LocalDateTime studentOrderDate) {
        this.studentOrderDate = studentOrderDate;
    }

    public StudentOrderStatus getStudentOrderStatus() {
        return studentOrderStatus;
    }

    public void setStudentOrderStatus(StudentOrderStatus studentOrderStatus) {
        this.studentOrderStatus = studentOrderStatus;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHusband() {
        return husband;
    }

    public void setHusband(Adult husband) {
        this.husband = husband;
    }

    public Adult getWife() {
        return wife;
    }

    public Adult wife() {
        return wife;
    }

    public void addChild(Child child) {
        if (children == null) {
            children = new LinkedList<>();

        }
        children.add(child);
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }





    public List<Child> getChildren() {
        return children;
    }

    public String getMarriageCertificateId() {
        return marriageCertificateId;
    }

    public void setMarriageCertificateId(String marriageCertificateId) {
        this.marriageCertificateId = marriageCertificateId;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    public RegisterOffice getMarriageOffice() {
        return marriageOffice;
    }

    public void setMarriageOffice(RegisterOffice marriageOffice) {
        this.marriageOffice = marriageOffice;
    }

    @Override
    public String toString() {
        return "StudentOrder{" +
                "studentOrderId=" + studentOrderId +
                ", studentOrderDate=" + studentOrderDate +
                ", studentOrderStatus=" + studentOrderStatus +
                ", husband=" + husband +
                ", wife=" + wife +
                ", children=" + children +
                ", marriageCertificateId='" + marriageCertificateId + '\'' +
                ", marriageDate=" + marriageDate +
                ", marriageOffice=" + marriageOffice +
                '}';
    }
}

package edu.javaproject.domain;

public class Street {
    /**
     * код улицы
     */
    private Long streetCode;
    /**
     * название улицы
     */
    private String streetName;

    public Street(Long streetCode, String name) {
        this.streetCode = streetCode;
        this.streetName = name;
    }

    public Street() {

    }

    public Long getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Long streetCode) {
        this.streetCode = streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String name) {
        this.streetName = name;
    }

    @Override
    public String toString() {
        return "Street{" +
                "streetCode=" + streetCode +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}

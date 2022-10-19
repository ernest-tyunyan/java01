package edu.javaproject.exception;

public class CityRegisterException extends RuntimeException {
    private String code;


    public CityRegisterException(String code ,String message) {
        super(message);
        this.code = code;
    }

    public CityRegisterException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

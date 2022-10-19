package edu.javaproject.register2;

import edu.javaproject.domain.Person;

public class AnswerCityRegisterItem {

    public enum CityStatus {
        YES, NO, ERROR;
    }

    public static class CityError {
         private String text;
         private String code;

        public CityError(String code, String text) {
            this.text = text;
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    private CityStatus status;
    private Person person;
    private CityError error;

    public CityStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public CityError getError() {
        return error;
    }

    public AnswerCityRegisterItem(CityStatus status, Person person, CityError error) {
        this.status = status;
        this.person = person;
        this.error = error;
    }

    public AnswerCityRegisterItem(CityStatus status, Person person) {
        this.status = status;
        this.person = person;
    }
}

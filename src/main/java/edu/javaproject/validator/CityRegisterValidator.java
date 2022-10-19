package edu.javaproject.validator;

import edu.javaproject.domain.Person;
import edu.javaproject.exception.TransportException;
import edu.javaproject.register2.AnswerCityRegister;
import edu.javaproject.domain.Child;
import edu.javaproject.register2.AnswerCityRegisterItem;
import edu.javaproject.register2.CityRegisterResponse;
import edu.javaproject.domain.StudentOrder;
import edu.javaproject.exception.CityRegisterException;
import edu.javaproject.register.CityRegisterChecker;
import edu.javaproject.register.FakeCityRegisterChecker;

public class CityRegisterValidator {

    public static final String IN_CODE = "NO_GRN";
    public static String hostName;
    public static String login;
    public static String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();



    }



    public  AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();

            ans.addItem(checkPerson(so.getHusband()));
            ans.addItem(checkPerson(so.getWife()));



            for(Child child : so.getChildren()) {
                ans.addItem(checkPerson(child));
            }






        return ans;

    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;

        try {
             CityRegisterResponse tmp = personChecker.checkPerson(person);
             status = tmp.isExisting() ? AnswerCityRegisterItem.CityStatus.YES : AnswerCityRegisterItem.CityStatus.NO;

        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());


        }

        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status, person, error);

        return ans;
    }
}

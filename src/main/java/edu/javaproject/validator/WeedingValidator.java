package edu.javaproject.validator;

import edu.javaproject.domain.AnswerWeeding;
import edu.javaproject.domain.StudentOrder;

public class WeedingValidator {
     public static AnswerWeeding checkWeeding(StudentOrder so) {
        System.out.println("Weeding запущен");
        AnswerWeeding answ = new AnswerWeeding();
        return answ;
    }
}

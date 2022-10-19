package edu.javaproject.validator;

import edu.javaproject.domain.AnswerChildren;
import edu.javaproject.domain.StudentOrder;

public class ChildrenValidator {
    public static AnswerChildren checkChildren(StudentOrder so) {
         System.out.println("Children Check is running");
         AnswerChildren ansc = new AnswerChildren();
         return ansc;
     }
}

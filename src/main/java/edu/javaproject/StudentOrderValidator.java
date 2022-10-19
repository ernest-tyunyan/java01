package edu.javaproject;

import edu.javaproject.dao.StudentOrderDaoImpl;
import edu.javaproject.domain.AnswerChildren;
import edu.javaproject.domain.AnswerStudent;
import edu.javaproject.exception.DaoException;
import edu.javaproject.validator.CityRegisterValidator;
import edu.javaproject.domain.AnswerWeeding;
import edu.javaproject.domain.StudentOrder;
import edu.javaproject.mail.MailSender;
import edu.javaproject.register2.AnswerCityRegister;
import edu.javaproject.validator.ChildrenValidator;
import edu.javaproject.validator.StudentValidator;
import edu.javaproject.validator.WeedingValidator;

import java.util.List;




    public class StudentOrderValidator {
        private CityRegisterValidator cityRegisterVal;
        private WeedingValidator weedingVal;
        private ChildrenValidator childrenVal;
        private StudentValidator studentVal;
        private MailSender mailSender;


        public StudentOrderValidator() {
            cityRegisterVal = new CityRegisterValidator();
            weedingVal = new WeedingValidator();
            childrenVal = new ChildrenValidator();
            studentVal = new StudentValidator();
            mailSender = new MailSender();

        }


        public static void main(String[] args) {
            StudentOrderValidator sov = new StudentOrderValidator();
            sov.checkAll();
        }


        public void checkAll () {
         try {
             List<StudentOrder> soList = readStudentOrders();
             for (StudentOrder so : soList) {
                 checkOneOrder(so);


             }
         } catch (Exception ex) {
             ex.printStackTrace();
         }


        }
        public List <StudentOrder> readStudentOrders () throws DaoException {
            return new StudentOrderDaoImpl().getStudentOrders();
        }

        public void checkOneOrder (StudentOrder so){
//            AnswerCityRegister cityAnswer = checkCityRegister(so);
//
//
//
//             AnswerWeeding wedAnswer = checkWeeding(so);
//             AnswerChildren childAnswer = checkChildren(so);
//             AnswerStudent studAnswer = checkStudent(so);
//
//
//               sendMail(so);

        }


        public AnswerCityRegister checkCityRegister (StudentOrder so){


            return cityRegisterVal.checkCityRegister(so);


        }
        public AnswerWeeding checkWeeding (StudentOrder so){
            return weedingVal.checkWeeding(so);
        }
        public AnswerChildren checkChildren (StudentOrder so){
            return childrenVal.checkChildren(so);
        }
        public AnswerStudent checkStudent (StudentOrder so){
            return studentVal.checkStudent(so);
        }

        public void sendMail (StudentOrder so){
            mailSender.sendMail(so);

        }


    }


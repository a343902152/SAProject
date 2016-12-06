package project3.subsystem;

import project3.Person;

/**
 * Created by hasee on 2016/11/26.
 */
public class LoanSystem {

    public static boolean hasLoanHistory(Person person){
        return person.getLoanHistory().size()>0;
    }
}

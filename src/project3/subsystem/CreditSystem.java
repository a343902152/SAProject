package project3.subsystem;

import project3.Person;

/**
 * Created by hasee on 2016/11/26.
 */
public class CreditSystem {

    public static boolean isCredit(Person person,int targetCreditLevel){
        return person.getCreditLevel() >= targetCreditLevel;
    }
}

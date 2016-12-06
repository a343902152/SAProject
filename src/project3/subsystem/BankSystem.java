package project3.subsystem;

import project3.Person;

/**
 * Created by hasee on 2016/11/26.
 */
public class BankSystem {

    public static boolean hasEnoughMoney(Person person, double targetMoney){
        return person.getMoney() >= targetMoney;
    }
}

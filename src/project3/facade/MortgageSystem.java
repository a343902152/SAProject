package project3.facade;

import project3.Person;
import project3.subsystem.BankSystem;
import project3.subsystem.CreditSystem;
import project3.subsystem.LoanSystem;

/**
 * Created by hasee on 2016/11/26.
 */
public class MortgageSystem {
    public void mortgage(Person person,double targetMoney,int targetCreditLevel){
        if(BankSystem.hasEnoughMoney(person,targetMoney)){
            System.out.println(person.getName()+"有足够的金钱,进入下一步");
            if(CreditSystem.isCredit(person,targetCreditLevel)){
                System.out.println(person.getName()+"有足够的信用,进入下一步");
                if(!LoanSystem.hasLoanHistory(person)){
                    System.out.println(person.getName()+"没有贷款劣迹，抵押成功");
                }else{
                    System.out.println(person.getName()+"有贷款劣迹，抵押失败");
                }
            }else{
                System.out.println(person.getName()+"信用度不足，抵押失败");
            }
        }else{
            System.out.println(person.getName()+"没有足够的金钱,抵押失败");
        }
    }
}

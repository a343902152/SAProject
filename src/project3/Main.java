package project3;

import project3.facade.MortgageSystem;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Person zsf=new Person("zsf",1000,10);
        MortgageSystem mortgageSystem=new MortgageSystem();

        System.out.println("情景一：");
        mortgageSystem.mortgage(zsf,1500,8);

        System.out.println("情景二：");
        mortgageSystem.mortgage(zsf,800,11);

        System.out.println("情景三：");
        zsf.addLoanHistory("a");
        mortgageSystem.mortgage(zsf,800,8);

        System.out.println("情景四：");
        zsf.setLoanHistory(new ArrayList<String>());
        mortgageSystem.mortgage(zsf,800,8);

    }
}

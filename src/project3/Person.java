package project3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/11/26.
 */
public class Person {
    private String name;
    private double money;
    private int creditLevel;
    private List<String> loanHistory=new ArrayList<String>();

    public Person(String name, double money, int creditLevel) {
        this.name = name;
        this.money = money;
        this.creditLevel = creditLevel;
    }

    public void addLoanHistory(String loan){
        loanHistory.add(loan);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(int creditLevel) {
        this.creditLevel = creditLevel;
    }

    public List<String> getLoanHistory() {
        return loanHistory;
    }

    public void setLoanHistory(List<String> loanHistory) {
        this.loanHistory = loanHistory;
    }
}

package project4.receiver;

/**
 * Created by hp on 2016/12/6.
 */
public class Calculater {

    public double add(double curState,double num){
        System.out.println("add: "+curState+"->"+(curState+num));
        return curState+num;
    }

    public double sub(double curState,double num){
        System.out.println("sub: "+curState+"->"+(curState-num));
        return curState-num;
    }
}

package project2.target;

/**
 * Created by hasee on 2016/11/11.
 */
public class BasicAction implements IBasicAction {
    @Override
    public void move() {
        System.out.println("move");
    }

    @Override
    public void cry() {
        System.out.println("cry");
    }
}

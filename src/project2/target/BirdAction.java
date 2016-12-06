package project2.target;

/**
 * Created by hasee on 2016/11/11.
 */
public class BirdAction implements IBirdAction {
    @Override
    public void fly() {
        System.out.println("bird fly");
    }

    @Override
    public void sing() {
        System.out.println("bird sing");
    }
}

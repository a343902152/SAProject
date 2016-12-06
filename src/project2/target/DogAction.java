package project2.target;

/**
 * Created by hasee on 2016/11/11.
 */
public class DogAction implements IDogAction {
    @Override
    public void bark() {
        System.out.println("dog bark");
    }

    @Override
    public void run() {
        System.out.println("dog run");
    }
}

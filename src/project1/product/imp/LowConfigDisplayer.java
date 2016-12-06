package project1.product.imp;

import project1.product.IDisplayer;

/**
 * Created by hp on 2016/10/27.
 */
public class LowConfigDisplayer implements IDisplayer {
    @Override
    public void display(String shape) {
        System.out.println("显示低配版"+shape);
    }
}

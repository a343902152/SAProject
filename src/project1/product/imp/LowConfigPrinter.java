package project1.product.imp;

import project1.product.IPrinter;

/**
 * Created by hp on 2016/10/27.
 */
public class LowConfigPrinter implements IPrinter {
    @Override
    public void print(String shape) {
        System.out.println("打印低配版"+shape);
    }
}

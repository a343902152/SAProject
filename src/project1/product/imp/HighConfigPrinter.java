package project1.product.imp;

import project1.product.IPrinter;

/**
 * Created by hp on 2016/10/27.
 */
public class HighConfigPrinter implements IPrinter {
    @Override
    public void print(String shape) {
        System.out.println("打印高配版"+shape);
    }
}

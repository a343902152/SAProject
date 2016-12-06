package project1.factory;

import project1.product.IDisplayer;
import project1.product.IPrinter;

/**
 * Created by hp on 2016/10/27.
 */
public interface IGuiAbstractFactory {
    IDisplayer getDisplayer();

    IPrinter getPrinter();
}

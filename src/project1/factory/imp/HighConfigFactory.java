package project1.factory.imp;

import project1.factory.IGuiAbstractFactory;
import project1.product.IDisplayer;
import project1.product.IPrinter;
import project1.product.imp.HighConfigDisplayer;
import project1.product.imp.HighConfigPrinter;

/**
 * Created by hp on 2016/10/27.
 */
public class HighConfigFactory implements IGuiAbstractFactory {
    @Override
    public IDisplayer getDisplayer() {
        return new HighConfigDisplayer();
    }

    @Override
    public IPrinter getPrinter() {
        return new HighConfigPrinter();
    }
}

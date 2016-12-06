package project1.factory.imp;

import project1.factory.IGuiAbstractFactory;
import project1.product.IDisplayer;
import project1.product.IPrinter;
import project1.product.imp.LowConfigDisplayer;
import project1.product.imp.LowConfigPrinter;

/**
 * Created by hp on 2016/10/27.
 */
public class LowConfigFactory implements IGuiAbstractFactory {
    @Override
    public IDisplayer getDisplayer() {
        return new LowConfigDisplayer();
    }

    @Override
    public IPrinter getPrinter() {
        return new LowConfigPrinter();
    }
}

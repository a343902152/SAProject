package project1.simpleandmethodfactory.guifactory.factorymethod.impl;

import project1.simpleandmethodfactory.gui.IGui;
import project1.simpleandmethodfactory.gui.impl.LowConfigGui;
import project1.simpleandmethodfactory.guifactory.factorymethod.IGuiFactoryMethod;

/**
 * Created by hp on 2016/10/25.
 */
public class LowConfigFactoryMethod implements IGuiFactoryMethod {
    @Override
    public IGui getGui() {
        return new LowConfigGui();
    }
}

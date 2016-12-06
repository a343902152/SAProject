package project1.simpleandmethodfactory.gui.impl;

import project1.simpleandmethodfactory.gui.IGui;

/**
 * Created by hp on 2016/10/24.
 */
public class HighConfigGui implements IGui {
    @Override
    public void printAndDiaplay(String shape) {
        System.out.println("打印高配版图形"+shape);
    }
}

package project1.simpleandmethodfactory.guifactory.simple;

import project1.simpleandmethodfactory.gui.impl.HighConfigGui;
import project1.simpleandmethodfactory.gui.IGui;
import project1.simpleandmethodfactory.gui.impl.LowConfigGui;

/**
 * Created by hp on 2016/10/25.
 */
public class SimpleFactory {
    public static IGui getGui(boolean isHighConfig){
        if(isHighConfig){
            return new HighConfigGui();
        }else{
            return new LowConfigGui();
        }
    }
}

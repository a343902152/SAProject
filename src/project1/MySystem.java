package project1;

import project1.factory.IGuiAbstractFactory;
import project1.factory.imp.HighConfigFactory;
import project1.factory.imp.LowConfigFactory;
import project1.product.IDisplayer;
import project1.product.IPrinter;

import java.util.Random;

/**
 * Created by hp on 2016/10/27.
 */
public class MySystem {

    private IGuiAbstractFactory guiFactory;
    private IDisplayer displayer;
    private IPrinter printer;

    private int cpu;
    private int curMemory;

    public MySystem(int cpu, int curMemory) {
        this.cpu = cpu;
        this.curMemory = curMemory;

        if(isHighConfig(cpu,curMemory)){
            guiFactory=new HighConfigFactory();
        }else{
            guiFactory=new LowConfigFactory();
        }
        this.displayer=guiFactory.getDisplayer();
        this.printer=guiFactory.getPrinter();
    }


    public void print(String shape){
        printer.print(shape);
    }

    public void display(String shape){
        displayer.display(shape);
    }

    public String getShapgeFromDB() {
        Random random=new Random();

        return "shape"+random.nextInt(100);
    }


    public boolean isHighConfig(int cpu,int memory){
        if((cpu+memory)>5){
            return true;
        }else{
            return false;
        }
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getCurMemory() {
        return curMemory;
    }

    public void setCurMemory(int curMemory) {
        this.curMemory = curMemory;
    }

    public IDisplayer getDisplayer() {
        return displayer;
    }

    public void setDisplayer(IDisplayer displayer) {
        this.displayer = displayer;
    }

    public IPrinter getPrinter() {
        return printer;
    }

    public void setPrinter(IPrinter printer) {
        this.printer = printer;
    }
}

package project1.simpleandmethodfactory;

import project1.simpleandmethodfactory.gui.IGui;
import project1.simpleandmethodfactory.guifactory.factorymethod.impl.HighConfigFactoryMethod;
import project1.simpleandmethodfactory.guifactory.factorymethod.IGuiFactoryMethod;
import project1.simpleandmethodfactory.guifactory.factorymethod.impl.LowConfigFactoryMethod;
import project1.simpleandmethodfactory.guifactory.simple.SimpleFactory;

import java.util.Random;

/**
 * Created by hp on 2016/10/24.
 */
public class OperationSystem {

    private IGui gui;

    /**
     * 用于工厂方法
     */
    private IGuiFactoryMethod guiFactoryMethod;

    private int cpu;
    private int curMemory;

    public OperationSystem(int cpu, int curMemory) {
        this.cpu = cpu;
        this.curMemory = curMemory;
    }

    /**
     * 简单工厂：把对象的创建放到一个工厂类中，通过参数来创建不同的对象。
     * 简单工厂模式是由一个具体的类去创建其他类的实例，父类是相同的，父类是具体的。
     * 缺点：简单工厂模式不利于拓展，违背了**开闭原则**，每次添加一个类，都要修改工厂类，不利于分工合作
     * @param shape
     */
    public void simplePrint(String shape){
        System.out.println("简单工厂:");
        gui = SimpleFactory.getGui(isHighConfig(cpu,curMemory));
        gui.printAndDiaplay(shape);
    }

    /**
     * 工厂方法：对简单工厂也进行抽象
     * 有一个抽象的父类定义公共接口，子类负责生成具体的对象，这样做的目的是将类的实例化操作延迟到子类中完成。
     * 一对一的关系：抽象产品类派生出多个具体产品类；一抽象工厂类派生出多个具体工厂类；每个具体工厂类只能创建一个具体产品类的实例。
     * 缺点：当产品种类非常多时，会出现大量的与之对应的工厂对象，难以维护。
     * @param shape
     */
    public void factoryMethodPrint(String shape){
        System.out.println("工厂方法:");
        if(isHighConfig(cpu,curMemory)){
            guiFactoryMethod=new HighConfigFactoryMethod();
        }else {
            guiFactoryMethod=new LowConfigFactoryMethod();
        }
        gui=guiFactoryMethod.getGui();
        gui.printAndDiaplay(shape);
    }

    /**
     * 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定他们具体的类。
     * 它针对的是有多个产品的等级结构。而工厂方法模式针对的是一个产品的等级结构。
     * 一对多的关系：多个抽象产品类，派生出多个具体产品类；一个抽象工厂类，派生出多个具体工厂类；每个具体工厂类可创建多个具体产品类的实例。
     * @param shape
     */
    public void abstractFactoryPrint(String shape){

    }

    public boolean isHighConfig(int cpu,int memory){
        if((cpu+memory)>5){
            return true;
        }else{
            return false;
        }
    }


    public String getShapgeFromDB() {
        Random random=new Random();

        return "shape"+random.nextInt(100);
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
}

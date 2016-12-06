package project2.adapter;

import project2.adaptee.IBasicAction;
import project2.target.IBirdAction;

/**
 * Created by hasee on 2016/11/11.
 * 由于使用的是适配器模式，要求在不修改原有代码的基础上添加额外的形态转换功能
 * 所以不能添加新的方法，只能对原有的move和cry方法进行操作
 *
 * 这里使用的是对象适配器
 */
public class BirdAdapter implements IBasicAction {

    private IBirdAction birdAction;

    public BirdAdapter(IBirdAction birdAction) {
        this.birdAction = birdAction;
    }

    @Override
    public void move() {
        birdAction.fly();
    }

    @Override
    public void cry() {
        birdAction.sing();
    }
}

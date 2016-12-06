package project2;

import project2.adaptee.BasicAction;
import project2.adaptee.IBasicAction;

/**
 * Created by hasee on 2016/11/11.
 * 仿生机器人，默认拥有基础动作BasicAction，包括move和cry
 * 可以通过set不同的action来拥有不同形态的动作
 */
public class BionicsRobot {

    private IBasicAction action;

    /**
     * 默认用basicAction
     */
    public BionicsRobot() {
        this.action=new BasicAction();
    }

    public BionicsRobot(IBasicAction action) {
        this.action = action;
    }

    /**
     * 注意着不是IBasicAction中的move，这只是Bobot自己的一个方法，可以为任意名称
     */
    public void move(){
        action.move();
    }

    /**
     * 注意着不是IBasicAction中的cry，这只是Bobot自己的一个方法，他可以为任意名称
     */
    public void cry(){
        action.cry();
    }

    public IBasicAction getAction() {
        return action;
    }

    /**
     * 通过设置实现了IBasicAction的dog或birdAdpater，可以实现机器人的形态转换
     * @param action
     */
    public void setAction(IBasicAction action) {
        this.action = action;
    }
}

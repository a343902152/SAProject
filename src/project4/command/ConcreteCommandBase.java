package project4.command;

/**
 * Created by hp on 2016/12/6.
 */
public abstract class ConcreteCommandBase implements Command {

    private double lastState;

    public double getLastState() {
        return lastState;
    }

    public void setLastState(double lastState) {
        this.lastState = lastState;
    }
}

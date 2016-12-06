package project4.command;

import project4.receiver.Calculater;

/**
 * Created by hp on 2016/12/6.
 */
public class AddConcreteCommand extends ConcreteCommandBase {

    private Calculater calculater=new Calculater();

    @Override
    public double execute() {
        return calculater.add(getLastState(),3);
    }

    @Override
    public double undo() {
        return getLastState();
    }
}

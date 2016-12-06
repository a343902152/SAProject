package project4.command;

import project4.receiver.Calculater;

/**
 * Created by hp on 2016/12/6.
 */
public class SubConcreteCommand extends ConcreteCommandBase {

    private Calculater calculater=new Calculater();

    @Override
    public double execute() {
        return calculater.sub(getLastState(),1);
    }

    @Override
    public double undo() {
        return getLastState();
    }
}

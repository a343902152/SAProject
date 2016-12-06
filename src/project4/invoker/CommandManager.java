package project4.invoker;

import project4.command.ConcreteCommandBase;

import java.util.Stack;

/**
 * Created by hp on 2016/12/6.
 */
public class CommandManager {

    private Stack<ConcreteCommandBase> commands=new Stack<ConcreteCommandBase>();

    public double execute(ConcreteCommandBase command){
        commands.add(command);
        return command.execute();
    }

    public double undo(){
        return commands.pop().undo();
    }

    public boolean canUndo() {
        return commands.size()>=1;
    }
}

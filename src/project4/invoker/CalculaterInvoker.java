package project4.invoker;

import project4.command.AddConcreteCommand;
import project4.command.SubConcreteCommand;

/**
 * Created by hp on 2016/12/6.
 */
public class CalculaterInvoker {

    private double curState;
    private CommandManager commandManager=new CommandManager();
    private AddConcreteCommand addConcreteCommand;
    private SubConcreteCommand subConcreteCommand;

    public void add(){
        addConcreteCommand=new AddConcreteCommand();
        addConcreteCommand.setLastState(curState);
        this.curState=commandManager.execute(addConcreteCommand);
    }

    public void sub(){
        subConcreteCommand=new SubConcreteCommand();
        subConcreteCommand.setLastState(curState);
        this.curState=commandManager.execute(subConcreteCommand);
    }

    public void undo(){
        if(commandManager.canUndo()){
            System.out.print("undo:"+curState+"->");
            this.curState=commandManager.undo();
            System.out.println(curState);
        }else{
            System.out.println("已经没有更多操作，不能撤销");
        }

    }

}

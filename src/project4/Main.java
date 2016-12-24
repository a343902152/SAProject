package project4;

import project4.invoker.CalculaterInvoker;

public class Main {

    public static void main(String[] args) {

        CalculaterInvoker calculaterInvoker=new CalculaterInvoker();
        calculaterInvoker.add();
        calculaterInvoker.undo();
        calculaterInvoker.sub();
        calculaterInvoker.add();
        calculaterInvoker.add();
        calculaterInvoker.sub();
        calculaterInvoker.sub();
        calculaterInvoker.undo();
        calculaterInvoker.undo();
        calculaterInvoker.add();
        calculaterInvoker.add();
        calculaterInvoker.undo();
        calculaterInvoker.undo();
        calculaterInvoker.undo();
        calculaterInvoker.undo();
        calculaterInvoker.undo();
        calculaterInvoker.undo();
        calculaterInvoker.undo();
    }
}

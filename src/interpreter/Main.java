package interpreter;

import interpreter.context.Context;
import interpreter.expression.Expression;
import interpreter.expression.nonterminal.And;
import interpreter.expression.nonterminal.Not;
import interpreter.expression.nonterminal.Or;
import interpreter.expression.terminal.Constant;
import interpreter.expression.terminal.Variable;

public class Main {

    private static Expression expression;

    public static void main(String[] args) {
        Context context = new Context();
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Constant constant = new Constant(true);
        context.assign(x, false);
        context.assign(y, true);

        // (constant && x ) || (y && !x) = true
        expression = new Or(new And(constant, x), new And(y, new Not(x)));
        System.out.println("x=" + x.interpret(context));
        System.out.println("y=" + y.interpret(context));
        System.out.println(expression.toString() + "=" + expression.interpret(context));
    }
}

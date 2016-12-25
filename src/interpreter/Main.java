package interpreter;

import interpreter.context.Context;
import interpreter.context.DecimalContext;
import interpreter.expression.BooleanExpression;
import interpreter.expression.OperationExpression;
import interpreter.expression.nonterminal.*;
import interpreter.expression.terminal.BooleanConstant;
import interpreter.expression.terminal.BooleanVariable;
import interpreter.expression.terminal.DecimalConstant;
import interpreter.expression.terminal.DecimalVariable;

public class Main {

    private static BooleanExpression expression;

    public static void main(String[] args) {
//        Context context = new Context();
//        BooleanVariable x = new BooleanVariable("x");
//        BooleanVariable y = new BooleanVariable("y");
//        BooleanConstant constant = new BooleanConstant(true);
//        context.assign(x, false);
//        context.assign(y, true);
//
//        // expression= ( constant && x ) || (y && !x) = true
//        expression = new Or(new And(constant, x), new And(y, new Not(x)));
//        System.out.println("x=" + x.interpret(context));
//        System.out.println("y=" + y.interpret(context));
//        System.out.println(expression.toString() + "=" + expression.interpret(context));


        DecimalContext decimalContext=new DecimalContext();
        DecimalVariable a=new DecimalVariable("a");
        DecimalVariable b=new DecimalVariable("b");
        DecimalVariable c = new DecimalVariable("c");
        DecimalConstant d=new DecimalConstant(1.5);
        DecimalConstant e=new DecimalConstant(2);
        decimalContext.assign(a,10);
        decimalContext.assign(b,5);
        decimalContext.assign(c,0.5);
//        d*((a-(b+c))/e-(a+c))
//        OperationExpression operationExpression=new Sub(new Sub(a,new Add(b,c)),new Add(a,c));
        OperationExpression operationExpression=new Mul(d,new Sub(new Div(new Sub(a,new Add(b,c)),e),new Add(a,c)));

        System.out.println(operationExpression.toString());
        System.out.println(operationExpression.interpret(decimalContext));

    }
}

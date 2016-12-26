package interpreter;

import interpreter.context.DecimalContext;
import interpreter.expression.BooleanExpression;
import interpreter.expression.DecimalExpression;
import interpreter.expression.nonterminal.decimal.Mul;
import interpreter.expression.nonterminal.decimal.Add;
import interpreter.expression.nonterminal.decimal.Div;
import interpreter.expression.nonterminal.decimal.Sub;
import interpreter.expression.terminal.decimal.DecimalConstant;
import interpreter.expression.terminal.decimal.DecimalVariable;

public class Main {

    private static BooleanExpression expression;

    public static void main(String[] args) {
//        BooleanContext context = new BooleanContext();
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

        String str = "abc abc";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isSpaceChar(ch[i]))
                System.out.println("ok");
        }
        DecimalContext decimalContext = new DecimalContext();
        DecimalVariable a = new DecimalVariable("a");
        DecimalVariable b = new DecimalVariable("b");
        DecimalVariable c = new DecimalVariable("c");
        DecimalConstant d = new DecimalConstant(1.5);
        DecimalConstant e = new DecimalConstant(2);
        decimalContext.assign(a, 10);
        decimalContext.assign(b, 5);
        decimalContext.assign(c, 0.5);
//        decimalExpression=d*((a-(b+c))/e-(a+c))
//        DecimalExpression decimalExpression=new Sub(new Sub(a,new Add(b,c)),new Add(a,c));
        DecimalExpression decimalExpression = new Mul(d, new Sub(new Div(new Sub(a, new Add(b, c)), e), new Add(a, c)));

        System.out.println(decimalExpression.toString());
        System.out.println(decimalExpression.interpret(decimalContext));
        

    }
}


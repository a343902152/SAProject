package interpreter.expression.nonterminal;

import interpreter.context.Context;
import interpreter.context.DecimalContext;
import interpreter.expression.OperationExpression;

/**
 * Created by hasee on 2016/12/25.
 */
public class Sub extends OperationExpression {

    private OperationExpression left;
    private OperationExpression right;

    public Sub(OperationExpression left, OperationExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return "( "+left.toString()+" - "+right.toString()+" )";
    }

    @Override
    public double interpret(DecimalContext context) {
        return left.interpret(context)-right.interpret(context);
    }
}

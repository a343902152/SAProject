package interpreter.expression.nonterminal;

import interpreter.context.Context;
import interpreter.context.DecimalContext;
import interpreter.expression.BooleanExpression;
import interpreter.expression.OperationExpression;

/**
 * Created by hasee on 2016/12/25.
 */
public class Add extends OperationExpression {

    private OperationExpression left;
    private OperationExpression right;

    public Add(OperationExpression left, OperationExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(DecimalContext context) {
        return left.interpret(context)+right.interpret(context);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return "( "+left.toString()+" + "+right.toString()+" )";
    }
}

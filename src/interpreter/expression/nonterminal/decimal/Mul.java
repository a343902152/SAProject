package interpreter.expression.nonterminal.decimal;

import interpreter.context.DecimalContext;
import interpreter.expression.DecimalExpression;

/**
 * Created by hasee on 2016/12/25.
 */
public class Mul extends DecimalExpression {

    private DecimalExpression left;
    private DecimalExpression right;

    public Mul(DecimalExpression left, DecimalExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(DecimalContext context) {
        return left.interpret(context)*right.interpret(context);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return "( "+left.toString()+" * "+right.toString()+" )";
    }
}

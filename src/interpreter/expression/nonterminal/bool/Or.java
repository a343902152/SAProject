package interpreter.expression.nonterminal.bool;

import interpreter.context.BooleanContext;
import interpreter.expression.BooleanExpression;

/**
 * Created by hasee on 2016/12/25.
 */
public class Or extends BooleanExpression {

    private BooleanExpression left;
    private BooleanExpression right;

    public Or(BooleanExpression left, BooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(BooleanContext context) {
        return left.interpret(context) || right.interpret(context);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Or) {
            return this.left.equals((((Or) o).left)) ||
                    this.right.equals((((Or) o).right));
        }
        return false;
    }

    @Override
    public String toString() {
        return "( "+left.toString()+" OR "+right.toString()+" )";
    }
}

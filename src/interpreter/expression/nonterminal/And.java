package interpreter.expression.nonterminal;


import interpreter.context.Context;
import interpreter.expression.BooleanExpression;

/**
 * Created by hasee on 2016/12/25.
 */
public class And extends BooleanExpression {

    private BooleanExpression left;
    private BooleanExpression right;

    public And(BooleanExpression left, BooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Context context) {
        return left.interpret(context) && right.interpret(context);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof And) {
            return this.left.equals((((And) o).left)) &&
                    this.right.equals((((And) o).right));
        }
        return false;
    }

    @Override
    public String toString() {
        return "( "+left.toString()+" AND "+right.toString()+" )";
    }
}

package interpreter.expression.nonterminal;


import interpreter.context.Context;
import interpreter.expression.Expression;

/**
 * Created by hasee on 2016/12/25.
 */
public class And extends Expression {

    private Expression left;
    private Expression right;

    public And(Expression left, Expression right) {
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

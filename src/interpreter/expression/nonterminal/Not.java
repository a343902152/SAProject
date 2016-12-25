package interpreter.expression.nonterminal;

import interpreter.context.Context;
import interpreter.expression.Expression;

/**
 * Created by hasee on 2016/12/25.
 */
public class Not extends Expression {

    private Expression expression;

    public Not(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(Context context) {
        return !expression.interpret(context);
    }

    @Override
    public boolean equals(Object o) {
        if(o!=null&&o instanceof Not){
            return this.expression.equals(((Not)o).expression);
        }
        return false;
    }

    @Override
    public String toString() {
        return "( NOT "+expression.toString()+" )";
    }
}

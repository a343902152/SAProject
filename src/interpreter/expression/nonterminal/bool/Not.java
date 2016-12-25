package interpreter.expression.nonterminal.bool;

import interpreter.context.BooleanContext;
import interpreter.expression.BooleanExpression;

/**
 * Created by hasee on 2016/12/25.
 */
public class Not extends BooleanExpression {

    private BooleanExpression expression;

    public Not(BooleanExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(BooleanContext context) {
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

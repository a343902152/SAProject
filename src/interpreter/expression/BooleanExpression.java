package interpreter.expression;

import interpreter.context.BooleanContext;

/**
 * Created by hasee on 2016/12/25.
 */
public abstract class BooleanExpression extends Expression {
    public abstract boolean interpret(BooleanContext context);

}

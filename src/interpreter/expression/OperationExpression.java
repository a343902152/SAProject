package interpreter.expression;

import interpreter.context.Context;
import interpreter.context.DecimalContext;

/**
 * Created by hasee on 2016/12/25.
 */
public abstract class OperationExpression extends Expression {
    public abstract double interpret(DecimalContext context);
}

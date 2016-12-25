package interpreter.expression;

import interpreter.context.Context;

/**
 * Created by hasee on 2016/12/25.
 */
public abstract class Expression {

    public abstract boolean interpret(Context context);

    public abstract boolean equals(Object o);

    public abstract String toString();
}

package interpreter.expression.terminal.decimal;

import interpreter.context.DecimalContext;
import interpreter.expression.DecimalExpression;

/**
 * Created by hasee on 2016/12/25.
 */
public class DecimalVariable extends DecimalExpression {
    private String name;

    public DecimalVariable(String name) {
        this.name = name;
    }

    @Override
    public double interpret(DecimalContext context) {
        return context.lookup(this);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}

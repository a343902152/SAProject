package interpreter.expression.terminal;

import interpreter.context.DecimalContext;
import interpreter.expression.OperationExpression;

/**
 * Created by hasee on 2016/12/25.
 */
public class DecimalConstant extends OperationExpression {

    private double value;

    public DecimalConstant(double value) {
        this.value = value;
    }

    @Override
    public double interpret(DecimalContext context) {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return ((Double)value).toString();
    }
}

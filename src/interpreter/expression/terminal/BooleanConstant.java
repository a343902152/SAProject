package interpreter.expression.terminal;

import interpreter.context.Context;
import interpreter.expression.BooleanExpression;

/**
 * 代表一个常量，值
 * Created by hasee on 2016/12/25.
 */
public class BooleanConstant extends BooleanExpression {

    private boolean thisBoolean;

    public BooleanConstant(boolean thisBoolean) {
        this.thisBoolean = thisBoolean;
    }

    @Override
    public boolean interpret(Context context) {
        return thisBoolean;
    }

    @Override
    public boolean equals(Object o) {
        if(o!=null && o instanceof BooleanConstant){
            return this.thisBoolean==((BooleanConstant)o).thisBoolean;
        }
        return false;
    }

    @Override
    public String toString() {
        return Boolean.toString(thisBoolean);
    }

    public boolean isThisBoolean() {
        return thisBoolean;
    }

    public void setThisBoolean(boolean thisBoolean) {
        this.thisBoolean = thisBoolean;
    }
}

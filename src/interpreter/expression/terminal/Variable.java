package interpreter.expression.terminal;


import interpreter.context.Context;
import interpreter.expression.Expression;

/**
 * 代表一个有名(字)变量
 * Created by hasee on 2016/12/25.
 */
public class Variable extends Expression {

    private String name;


    public Variable(String name) {
        this.name = name;
    }

    /**
     * ★★context.lookup(context)是关键
     * 在登记在册的map中查找this这个variable对应的值
     *
     * @param context
     * @return
     */
    @Override
    public boolean interpret(Context context) {
        return context.lookup(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Variable) {
            return this.name.equals(((Variable) o).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}

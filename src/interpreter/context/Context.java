package interpreter.context;

import interpreter.expression.Expression;

/**
 * 问题：assign中的输入参数(boolean、double、int、string等)以及返回值(boolean、double、string)均在变化
 *      这时应该选择哪种方式来把他们统一起来？
 * Created by hasee on 2016/12/25.
 */
public abstract class Context {
    public abstract Object assign(Expression expression,Object value);
}

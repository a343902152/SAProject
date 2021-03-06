package interpreter.context;

import interpreter.expression.DecimalExpression;
import interpreter.expression.terminal.decimal.DecimalVariable;

import java.util.HashMap;

/**
 * Created by hasee on 2016/12/25.
 */
public class DecimalContext {
    private HashMap<DecimalExpression,Double> map = new HashMap<DecimalExpression, Double>();

    /**
     * 每有一个变量，就把他登记在册(variableMap)
     * @param var
     * @param value
     */
    public void assign(DecimalVariable var, double value){
        map.put(var, value);
    }

    /**
     * 在登记过的数据中查找variable对应的值
     * @param var
     * @return
     */
    public double lookup(DecimalVariable var){
        Double value=map.get(var);
        if(value==null){
            throw new IllegalArgumentException();
        }
        return value;
    }

}

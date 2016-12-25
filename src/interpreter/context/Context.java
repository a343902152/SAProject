package interpreter.context;

import interpreter.expression.terminal.Variable;

import java.util.HashMap;

/**
 * 上下文类，保存变量名与对应的值
 * Created by hasee on 2016/12/25.
 */
public class Context {
    private HashMap<Variable,Boolean> variableMap =new HashMap();

    /**
     * 每有一个变量，就把他登记在册(variableMap)
     * @param var
     * @param value
     */
    public void assign(Variable var, boolean value){
        variableMap.put(var, value);
    }

    /**
     * 在登记过的数据中查找variable对应的值
     * @param var
     * @return
     */
    public boolean lookup(Variable var){
        Boolean value=(Boolean) variableMap.get(var);
        if(value==null){
            throw new IllegalArgumentException();
        }
        return value;
    }
}

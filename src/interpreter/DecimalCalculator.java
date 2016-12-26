package interpreter;

import interpreter.context.Context;
import interpreter.context.DecimalContext;
import interpreter.expression.DecimalExpression;
import interpreter.expression.Expression;
import interpreter.expression.nonterminal.decimal.Add;
import interpreter.expression.nonterminal.decimal.Div;
import interpreter.expression.nonterminal.decimal.Mul;
import interpreter.expression.nonterminal.decimal.Sub;
import interpreter.expression.terminal.decimal.DecimalConstant;
import interpreter.expression.terminal.decimal.DecimalVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hp on 2016/12/26.
 */
public class DecimalCalculator {


    /**
     * 中缀表达式->后缀表达式
     * @param expression
     * @return
     */
    public List<String> mid2Post(String expression){
        List<String> postExpression=new ArrayList<String>();
        Stack<Character> opStack=new Stack<Character>();

        String curNumber=""; // 表示当前处理的数字，应对1.5 103等一个字符无法表示的情况，除了这种方法之外还有许多可靠的解决方案。
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if (Character.isSpaceChar(c)){
                continue;
            }else{
                if(Character.isDigit(c)||c=='.'){
                    curNumber+=c;
                }else{
                    if(!curNumber.isEmpty()){
                        postExpression.add(curNumber);
                        curNumber="";
                    }
                    if(Character.isLetter(c)){
                        postExpression.add(String.valueOf(c));
                    }
                    else if(c=='('){
                        opStack.push(c);
                    }else if(c==')'){
                        while (opStack.size()>0){
                            char topChar=opStack.pop();
                            if (topChar=='('){
                                break;
                            }else{
                                postExpression.add(String.valueOf(topChar));
                            }
                        }
                    }else{
                        // 比较优先级
                        while (opStack.size()>0&&needPop(opStack.peek(),c)){
                            postExpression.add(String.valueOf(opStack.pop()));
                        }
                        opStack.push(c);
                    }
                }
            }
        }
        if(!curNumber.isEmpty()){
            postExpression.add(curNumber);
        }
        while (opStack.size()>0){
            postExpression.add(String.valueOf(opStack.pop()));
        }
        return postExpression;
    }

    /**
     * c>peek时入栈，c<=peek时出栈
     * 优先级为： ×÷ > +- > (
     * @param peek
     * @param c
     * @return
     */
    private boolean needPop(Character peek, Character c) {
        if(peek.equals('*')||peek.equals('/')){
            return true;
        }else if(peek.equals('+')||peek.equals('-')){
            if(c.equals('+')||c.equals('-')){
                return true;
            }
        }
        return false;
    }

    /**
     * 后缀表达式求值，返回一个expression
     * expression.toString()可以得到计算式
     * expression.interpret()可得算式运算结果。
     * @param postExpression
     * @return
     */
    public Expression interpret(List<String> postExpression) {
        Stack<DecimalExpression> decimalStack=new Stack<DecimalExpression>();
        for (String s : postExpression) {
            if (isDigit(s)) {
                decimalStack.push(new DecimalConstant(Double.parseDouble(String.valueOf(s))));
            }else if(isLetter(s)){
                decimalStack.push(new DecimalVariable(String.valueOf(s)));
            }else {
                DecimalExpression expression2 = decimalStack.pop();
                DecimalExpression expression1 = decimalStack.pop();
                switch (s) {
                    case "+":
                        decimalStack.push(new Add(expression1, expression2));
                        break;
                    case "-":
                        decimalStack.push(new Sub(expression1, expression2));
                        break;
                    case "*":
                        decimalStack.push(new Mul(expression1, expression2));
                        break;
                    case "/":
                        decimalStack.push(new Div(expression1, expression2));
                        break;
                }
            }
            System.out.println(decimalStack);
        }
        return decimalStack.pop();
    }

    private boolean isLetter(String s) {
        return s.matches("^[A-Za-z]+$");
    }

    private boolean isDigit(String s) {
        return s.matches("^(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    public static void main(String[] args) {
        DecimalCalculator calculate = new DecimalCalculator();

        String s="9.5+(3-1)*3+10/2+45";
        // 中缀表达式->后缀表达式
        List<String> postExpression=calculate.mid2Post(s);
        System.out.println(postExpression); // sout=[9.5, 3, 1, -, 3, *, +, 10, 2, /, +, 45, +]

        // 用解释器模式做后缀表达式求值
        DecimalExpression expression=(DecimalExpression) calculate.interpret(postExpression);
        System.out.println(expression.toString());  // sout=( ( ( 9.5 + ( ( 3.0 - 1.0 ) * 3.0 ) ) + ( 10.0 / 2.0 ) ) + 45.0 )
        System.out.println(expression.interpret(new DecimalContext()));
//
        String sAlpha="a+(b-15.5)*b+c/2"; // 用字母表示的算式，在abc赋值之前不能interpret，但是可以toString()
        DecimalExpression alphaExpression=(DecimalExpression)calculate.interpret(calculate.mid2Post(sAlpha));
        System.out.println(alphaExpression.toString()); // sout=( ( a + ( ( b - 15.5 ) * b ) ) + ( c / 2.0 ) )
    }
}

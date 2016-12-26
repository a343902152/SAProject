package interpreter;

import interpreter.context.DecimalContext;
import interpreter.expression.DecimalExpression;
import interpreter.expression.Expression;
import interpreter.expression.nonterminal.decimal.Add;
import interpreter.expression.nonterminal.decimal.Div;
import interpreter.expression.nonterminal.decimal.Mul;
import interpreter.expression.nonterminal.decimal.Sub;
import interpreter.expression.terminal.decimal.DecimalConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hp on 2016/12/26.
 */
public class DecimalCalculator {


    public List<Character> mid2Post(String expression){
        List<Character> postExpression=new ArrayList<Character>();
        Stack<Character> opStack=new Stack<Character>();

        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if (Character.isSpaceChar(c)){
                continue;
            }else{
                if(Character.isDigit(c)){
                    postExpression.add(c);
                }else if(c=='('){
                    opStack.push(c);
                }else if(c==')'){
                    while (opStack.size()>0){
                        char topChar=opStack.pop();
                        if (topChar=='('){
                            break;
                        }else{
                            postExpression.add(topChar);
                        }
                    }
                }else{
                    // 比较优先级
                    while (opStack.size()>0&&needPop(opStack.peek(),c)){
                        postExpression.add(opStack.pop());
                    }
                    opStack.push(c);
                }
            }
        }
        while (opStack.size()>0){
            postExpression.add(opStack.pop());
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

    public Expression interpret(List<Character> postExpression) {
        Stack<DecimalExpression> decimalStack=new Stack<DecimalExpression>();
        for(int i=0;i<postExpression.size();i++){
            Character c = postExpression.get(i);
            if(c.isDigit(c)){
                decimalStack.push(new DecimalConstant(Double.parseDouble(String.valueOf(c))));
            }else{
                DecimalExpression expression2=decimalStack.pop();
                DecimalExpression expression1=decimalStack.pop();
                switch (c){
                    case '+':
                        decimalStack.push(new Add(expression1,expression2));
                        break;
                    case '-':
                        decimalStack.push(new Sub(expression1,expression2));
                        break;
                    case '*':
                        decimalStack.push(new Mul(expression1,expression2));
                        break;
                    case '/':
                        decimalStack.push(new Div(expression1,expression2));
                        break;
                }
            }
        }
        return decimalStack.pop();
    }

    public static void main(String[] args) {
        DecimalCalculator calculate = new DecimalCalculator();
//        String s = "12+(23*3-56+7)*(2+90)/2";

        String s="9+(3-1)*3+8/2";
        // 中缀表达式->后缀表达式
        List<Character> postExpression=calculate.mid2Post(s);
        System.out.println(postExpression); // sout=[9, 3, 1, -, 3, *, +, 8, 2, /, +]

        // 用解释器模式做后缀表达式求值
        DecimalExpression expression=(DecimalExpression) calculate.interpret(postExpression);
        System.out.println(expression.toString());  // sout=( ( 9.0 + ( ( 3.0 - 1.0 ) * 3.0 ) ) + ( 8.0 / 2.0 ) )
        System.out.println(expression.interpret(new DecimalContext()));
    }
}

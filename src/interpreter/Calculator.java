package interpreter;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by hasee on 2016/12/25.
 */
public class Calculator {
    /**
     * 将字符串转化成List
     *
     * @param str
     * @return
     */
    public ArrayList<String> getStringList(String str) {
        ArrayList<String> result = new ArrayList<String>();
        String num = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                num = num + str.charAt(i);
            } else {
                if (num != "") {
                    result.add(num);
                }
                result.add(str.charAt(i) + "");
                num = "";
            }
        }
        if (num != "") {
            result.add(num);
        }
        return result;
    }

    /**
     * 将中缀表达式转化为后缀表达式
     *
     * @param inOrderList
     * @return
     */
    public ArrayList<String> getPostOrder(ArrayList<String> inOrderList) {

        ArrayList<String> result = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < inOrderList.size(); i++) {
            if (Character.isDigit(inOrderList.get(i).charAt(0))) {
                result.add(inOrderList.get(i));
            } else {
                switch (inOrderList.get(i).charAt(0)) {
                    case '(':
                        stack.push(inOrderList.get(i));
                        break;
                    case ')':
                        while (!stack.peek().equals("(")) {
                            result.add(stack.pop());
                        }
                        stack.pop();
                        break;
                    default:
                        while (!stack.isEmpty() && compare(stack.peek(), inOrderList.get(i))) {
                            result.add(stack.pop());
                        }
                        stack.push(inOrderList.get(i));
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 计算后缀表达式
     *
     * @param postOrder
     * @return
     */
    public Double calculate(ArrayList<String> postOrder) {
        Stack stack = new Stack();
        for (int i = 0; i < postOrder.size(); i++) {
            if (Character.isDigit(postOrder.get(i).charAt(0))) {
                stack.push(Double.parseDouble(postOrder.get(i)));
            } else {
                Double back = (Double) stack.pop();
                Double front = (Double) stack.pop();
                Double res = 0.0;
                switch (postOrder.get(i).charAt(0)) {
                    case '+':
                        res = front + back;
                        break;
                    case '-':
                        res = front - back;
                        break;
                    case '*':
                        res = front * back;
                        break;
                    case '/':
                        res = front / back;
                        break;
                }
                stack.push(res);
            }
        }
        return (Double) stack.pop();
    }

    /**
     * 比较运算符等级
     *
     * @param peek
     * @param cur
     * @return
     */
    public static boolean compare(String peek, String cur) {
        if ("*".equals(peek) && ("/".equals(cur) || "*".equals(cur) || "+".equals(cur) || "-".equals(cur))) {
            return true;
        } else if ("/".equals(peek) && ("/".equals(cur) || "*".equals(cur) || "+".equals(cur) || "-".equals(cur))) {
            return true;
        } else if ("+".equals(peek) && ("+".equals(cur) || "-".equals(cur))) {
            return true;
        } else if ("-".equals(peek) && ("+".equals(cur) || "-".equals(cur))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Calculator calculate = new Calculator();
        String s = "12+(23*3-56+7)*(2+90)/2";
//        String s="1.5*((10-(5+0.5))/2-(10+0.5))";
        ArrayList result = calculate.getStringList(s);  //String转换为List
        result = calculate.getPostOrder(result);   //中缀变后缀
        System.out.println("后缀表达式："+result);

        double i = calculate.calculate(result);   //计算
        System.out.println(i);

    }
}

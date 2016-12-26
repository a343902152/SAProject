package visitor;

import interpreter.context.DecimalContext;
import interpreter.expression.BooleanExpression;
import interpreter.expression.DecimalExpression;
import interpreter.expression.nonterminal.decimal.Add;
import interpreter.expression.nonterminal.decimal.Div;
import interpreter.expression.nonterminal.decimal.Mul;
import interpreter.expression.nonterminal.decimal.Sub;
import interpreter.expression.terminal.decimal.DecimalConstant;
import interpreter.expression.terminal.decimal.DecimalVariable;
import visitor.element.*;
import visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Element> elements=new ArrayList<>();
        elements.add(new ConcreteElementA());
        elements.add(new ConcreteElementB());
        elements.add(new ConcreteElementA());
        elements.add(new ConcreteElementB());
        elements.add(new ConcreteElementC());
        elements.add(new ConcreteElementB());
        elements.add(new ConcreteElementC());
        elements.add(new ConcreteElementD());
        elements.add(new ConcreteElementA());
        elements.add(new ConcreteElementB());
        elements.add(new ConcreteElementD());
        elements.add(new ConcreteElementC());
        elements.add(new ConcreteElementB());
        elements.add(new ConcreteElementB());
        elements.add(new ConcreteElementA());

        // 一、不是用访问者模式,如果类别多了之后就要写很长的if else，没添加一个类别就要修改一下循环：
        for (Element element:elements){
            if(element instanceof ConcreteElementA){
                System.out.println("处理A:"+element);
            }else if(element instanceof ConcreteElementB){
                System.out.println("处理B:"+element);
            }else if(element instanceof ConcreteElementC){
                System.out.println("处理C:"+element);
            }else if(element instanceof ConcreteElementD){
                System.out.println("处理D:"+element);
            }
        }

        // 二、使用了访问者模式，即使添加类也不修改下面代码(但是要修改visitor)：
        Visitor visitor=new Visitor();
        for(Element element : elements){
            element.accept(visitor);
        }
    }
}


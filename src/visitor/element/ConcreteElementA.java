package visitor.element;

import visitor.visitor.Visitor;

/**
 * Created by hp on 2016/12/26.
 */
public class ConcreteElementA implements Element{
    @Override
    public void accept(Visitor visitor) {
        System.out.println("elementA接受访问");
        visitor.visit(this);
    }
}

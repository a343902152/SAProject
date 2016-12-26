package visitor.element;

import visitor.visitor.Visitor;

/**
 * Created by hp on 2016/12/26.
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("elementB接受访问");
        visitor.visit(this);
    }
}

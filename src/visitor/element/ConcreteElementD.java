package visitor.element;

import visitor.visitor.Visitor;

/**
 * Created by hp on 2016/12/26.
 */
public class ConcreteElementD implements Element {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("elementD接受访问");
        visitor.visit(this);
    }
}

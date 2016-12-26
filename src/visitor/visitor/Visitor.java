package visitor.visitor;

import visitor.element.ConcreteElementA;
import visitor.element.ConcreteElementB;
import visitor.element.ConcreteElementC;
import visitor.element.ConcreteElementD;

/**
 * 注意：与Element耦合度较大，每添加一个Element就需要修改一次visitor
 * Created by hp on 2016/12/26.
 */
public class Visitor {
    public void visit(ConcreteElementA elementA){
        System.out.println("visitor处理"+elementA);
    }

    public void visit(ConcreteElementB elementB){
        System.out.println("visitor处理"+elementB);
    }

    public void visit(ConcreteElementC elementC){
        System.out.println("visitor处理"+elementC);
    }

    public void visit(ConcreteElementD elementD){
        System.out.println("visitor处理"+elementD);
    }
}

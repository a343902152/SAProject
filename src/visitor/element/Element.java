package visitor.element;

import visitor.visitor.Visitor;

/**
 * Created by hp on 2016/12/26.
 */
public interface Element {
    void accept(Visitor visitor);
}

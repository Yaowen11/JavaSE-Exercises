package think.fifteen.genericinterface;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zyw
 * @date 2020/8/22 20:13
 */
public class ErasureAndInheritance {
    static class GenericBase<T> {
        private T element;

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }
    }

    static class Derived<T> extends GenericBase<T> {}
    static class Derived1<T> extends GenericBase<T> {}

    public static void main(String[] args) {
        Derived1 derived1 = new Derived1();
        Object obj = derived1.getElement();
        derived1.setElement(obj);
    }
}

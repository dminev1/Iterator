package Iterator;

import java.util.Iterator;

public class FilteringIterator<E> implements Iterator{

    private Iterator<E> ite;
    private IObjectTest test;
    private E next;

    public FilteringIterator(Iterator myIterator, IObjectTest myTest) {
        this.ite = myIterator;
        this.test = myTest;
    }

    @Override
    public boolean hasNext() {
        while(ite.hasNext()){
            next = ite.next();
            if(next.getClass().equals(test.getClass())){
                return true;
            }
        }
        return false;
    }

    @Override
    public E next() {
        return next;
    }
}

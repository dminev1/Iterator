package IteratorTest;

import Iterator.IObjectTest;

public class DummyObjectImpl implements IObjectTest {
    @Override
    public boolean test(Object o) {
        return o.hashCode() % 2 == 0;
    }

    @Override
    public String toString() {
        return "DummyObjectImpl ";
    }
}

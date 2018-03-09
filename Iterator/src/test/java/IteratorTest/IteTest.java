package IteratorTest;

import Iterator.FilteringIterator;
import Iterator.IObjectTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IteTest {


    /**
     * this is to test the iterator will have normal function which:
     * 1. skip the type which is not DummyObjectImpl
     * 2. have the correct iteration times which is 2. Only 2 DummyObjectImp are in the list(o1 and o3).
     */
    @Test
    public void testIterator() {
        IObjectTest o1 = new DummyObjectImpl();
        IObjectTest o2 = new DummyObjectImpl2();
        IObjectTest o3 = new DummyObjectImpl();

        List<Object> objList = new ArrayList<>();
        objList.add("Hello");
        objList.add(o1);
        objList.add(o3);
        objList.add("Hello");
        objList.add(o2);
        objList.add("Hello");

        FilteringIterator myIte = new FilteringIterator(objList.iterator(), o1);
        int count = 0;
        while (myIte.hasNext()) {
            count++;
            assertTrue(myIte.next().getClass().equals(o1.getClass()));
        }
        assertTrue(count == 2);
    }

    /**
     * this is to test the iterator will not give any element if the list doesn't contain the correct type
     */
    @Test
    public void testIterator2() {
        IObjectTest o1 = new DummyObjectImpl();
        IObjectTest o2 = new DummyObjectImpl2();

        List<Object> objList = new ArrayList<>();
        objList.add("Hello");
        objList.add(o1);
        objList.add("Hello");

        FilteringIterator myIte = new FilteringIterator(objList.iterator(), o2);
        assertFalse(myIte.hasNext());
    }
}

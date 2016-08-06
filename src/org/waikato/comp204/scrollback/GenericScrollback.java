package org.waikato.comp204.scrollback;

import java.util.ArrayList;
import java.util.List;

/**
 * A Generic Scrollback implementation
 */
public class GenericScrollback<T> implements GenericScrollbackInterface<T> {
    private int elementsCount;
    private int elementsLimit;

    private T LastElement;
    private T FirstElement;

    List myList = new ArrayList();

    public GenericScrollback()
    {
        elementsLimit = 10;
    }
    public GenericScrollback(int limit)
    {
        if(limit <= 0)
        {
            elementsLimit = 10;
        }
        else
        {
            elementsLimit = limit;
        }
    }
    @Override
    public void add(T item) {
            System.out.println(item);
    }
    public void show()
    {
        System.out.println("Scrollback Capacity : " + getCapacity());
        System.out.println("Current Elements : " + getCount());
    }

    @Override
    public T getLast(){
        return null;
    }

    @Override
    public void clear() {
        elementsLimit = 0;
        elementsCount = 0;
    }

    @Override
    public int getCapacity() {
        return elementsLimit;
    }

    @Override
    public int getCount() {
        return elementsCount;
    }
}

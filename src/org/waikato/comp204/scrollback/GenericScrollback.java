package org.waikato.comp204.scrollback;

/**
 * A Generic Scrollback implementation
 */
public class GenericScrollback<T> implements GenericScrollbackInterface<T> {
    private int elementsCount;
    private int elementsLimit;


    public GenericScrollback()
    {
        elementsLimit = 10;
    }
    public GenericScrollback(int limit)
    {
        elementsLimit = limit;
    }
    @Override
    public void add(T item) {
            System.out.println(item);
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

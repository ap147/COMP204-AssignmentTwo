package org.waikato.comp204.scrollback;

import java.util.ArrayList;
import java.util.List;

/**
 * A Generic Scrollback implementation
 */
public class GenericScrollback<T> implements GenericScrollbackInterface<T> {
    private int elementsCount;
    private int elementsLimit;

    private ElementNodes LastElement;
    private ElementNodes FirstElement;

    private T    LastOneValue;
    private int  LastScrollCount = 0;

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
    public void add(T item)
    {
        if (FirstElement == null && item !=null)
        {
            AddFirst(item);
        }
        else
        {
            AddSecound(item);
        }
        LastScrollCount = 0;

    }
    private void AddFirst(T item)
    {
        FirstElement = new ElementNodes(item);
        LastElement = FirstElement;
        elementsCount++;

    }
    private void AddSecound(T item)
    {
        if (!item.equals(LastElement.getElement()))
        {
            if (elementsCount < elementsLimit) {
                ElementNodes Temp = LastElement.AddElement(item);
                LastElement = Temp;
                elementsCount++;
            }
            else
            {
                AddingWhenFull(item);
            }
        }
    }
    private void AddingWhenFull(T item)
    {
        ElementNodes Temp = FirstElement.getNext();
        FirstElement.setNextNull();
        FirstElement = Temp;

        if (FirstElement == null) {
            FirstElement = new ElementNodes(item);
            LastElement = FirstElement;
        }
        else
        {
            Temp = LastElement.AddElement(item);
            LastElement = Temp;
        }
    }
    public void Show()
    {
        System.out.println("Scrollback Capacity : " + getCapacity());
        System.out.println("Current Elements : " + getCount());
        LastScrollCount = 0;
        dump();
    }

    public T getLastValue()
    {
        return LastOneValue;
    }


    public T getLast()
    {
        if(elementsCount != 0)
        {
            ElementNodes Temp = FirstElement;
            if (elementsCount == LastScrollCount) {
                LastScrollCount = 0;
            }
            int count = elementsCount - LastScrollCount;

            for (int x = 1; x < count; x++) {
                Temp = Temp.getNext();
            }
            LastScrollCount++;
            LastOneValue = Temp.getElement();
            return  LastOneValue;
        }
        else
        {
            return null;
        }

    }
    private void dump()
    {
        System.out.println();
        ElementNodes Temp = FirstElement;
        for(int x =0; x < elementsCount; x++)
        {
            System.out.println(x+1 +"  * " + Temp.getElement());
            Temp = Temp.getNext();
        }
    }
    @Override
    public void clear() {
        elementsCount = 0;
        FirstElement = null;
        LastElement = null;
    }

    @Override
    public int getCapacity() {
        return elementsLimit;
    }

    @Override
    public int getCount() {
        return elementsCount;
    }


    class ElementNodes {
        private T element;
        private ElementNodes next;

        protected ElementNodes(T _e)
        {
            element = _e;
        }

        protected ElementNodes AddElement(T s)
        {
            ElementNodes newElement = new ElementNodes(s);
            next = newElement;

            return next;
        }

        protected ElementNodes getNext()
        {
            return next;
        }
        protected  void setNextNull()
        {
            this.next = null;
        }
        protected T getElement()
        {
            return element;
        }
    }
}


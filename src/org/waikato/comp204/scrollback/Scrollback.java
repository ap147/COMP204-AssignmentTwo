package org.waikato.comp204.scrollback;

import javax.lang.model.element.Element;

/**
 * A String Scrollback implementation
 */
public class Scrollback implements ScrollbackInterface
{
    private int elementsCount;
    private int elementsLimit;
    private ElementNodes LastAddedElement = null;
    private int ScrollCount = 0;
    public  Scrollback()
    {
        elementsLimit = 10;
    }
    public  Scrollback(int amount)
    {
        elementsLimit = amount;
    }
    @Override
    public void add(String item)
    {
        boolean Duplicate = false;
        //If there are elements , is this a duplicate
        if(elementsCount !=0)
        {
            String LastAdded = LastAddedElement.getElement();
            if(LastAdded == item)
            {
                Duplicate = true;
            }
        }
        //if this is not a duplicate and limit is not reached
        if(elementsLimit != elementsCount && !Duplicate)
        {
            if(LastAddedElement == null)
            {
                LastAddedElement = new ElementNodes(item);
            }
            else
            {
                LastAddedElement = LastAddedElement.AddElement(item);
            }
            elementsCount++;
        }
        //Limit must be reached or its a duplicate
        else
        {
            //If its not a duplicate remove the first element and add this to last
            if(!Duplicate)
            {
                LastAddedElement.RemoveFirstElement();
                LastAddedElement = LastAddedElement.AddElement(item);
            }
            //Duplicate == do nothing
        }
        ScrollCount = 0;
    }

    @Override
    public String getLast()
    {
        if(ScrollCount == elementsCount)
        {
            ScrollCount = 0;
        }

        ElementNodes WantedElement = LastAddedElement.GetElement(ScrollCount);
        String WantedItem = WantedElement.getElement();
        ScrollCount++;


        return null;
    }

    @Override
    public void clear()
    {
        elementsCount = 0;
        LastAddedElement = null;
    }

    @Override
    public int getCapacity()
    {
        return elementsLimit;
    }

    @Override
    public int getCount()
    {
        return elementsCount;
    }
}


class ElementNodes
{
    private String element;
    private ElementNodes next;

    public ElementNodes(String _e)
    {
        element = _e;
    }

    public ElementNodes AddElement(String s)
    {
        ElementNodes newElement = new ElementNodes(s);
        next = newElement;
        return next;
    }
    public ElementNodes GetElement(int _index)
    {
        ElementNodes Current;
        Current = this;
        int index = _index;
        while(index != 0)
        {
            Current = Current.getNext();
        }
        return Current;
    }
    public void RemoveFirstElement()
    {
        ElementNodes Current;
        ElementNodes Next;

        Current = this;
        Next = Current.getNext();

        while(Next.getNext() != null)
        {
            Current = Next;
            Next = Next.getNext();
        }
        Current.setNextNull();
    }
    public ElementNodes getNext()
    {
        return next;
    }
    public  void setNextNull()
    {
        this.next = null;
    }
    public String getElement()
    {
        return element;
    }












}
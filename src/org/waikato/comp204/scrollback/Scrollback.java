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
        if(elementsCount !=0)
        {
            String LastAdded = LastAddedElement.getElement();
            if(LastAdded == item)
            {
                Duplicate = true;
            }
        }
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
        else
        {

        }
    }

    @Override
    public String getLast()
    {
        return null;
    }

    @Override
    public void clear()
    {
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
    public ElementNodes getNext()
    {
        return next;
    }
    public String getElement()
    {
        return element;
    }












}
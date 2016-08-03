package org.waikato.comp204.scrollback;

import javax.lang.model.element.Element;
import java.awt.image.AreaAveragingScaleFilter;
import java.time.temporal.Temporal;

/**
 * A String Scrollback implementation
 */
public class Scrollback implements ScrollbackInterface
{

    private String LastAddedElement;
    //Always pointing to the last element added
    private int Arrayindex;
    private int elementsCount;
    private int elementsLimit;

    private ElementNodes LastElement;
    private ElementNodes FirstElement;

    private int ScrollCount = 0;
    public  Scrollback()
    {
        elementsLimit = 10;
        Arrayindex = 0;
    }
    public  Scrollback(int amount)
    {
        elementsLimit = amount;
        Arrayindex = 0;
    }
    @Override
    public void add(String item)
    {
        elementsCount++;
        //if we are going over the limit, remove first element and add this one if item is not a duplicate
        if(elementsCount > elementsLimit && item != LastElement.getElement())
        {
            ElementNodes Temp = FirstElement;
            FirstElement = FirstElement.getNext();
            Temp.setNextNull();
        }
        if(elementsCount < elementsLimit)
        {
            //If list is empty
            if(FirstElement == null) {
                FirstElement = new ElementNodes(item);
                LastElement = FirstElement;
            }
            else
            {
                LastElement = new ElementNodes(item);
            }
        }

    }

    @Override
    public String getLast()
    {

    }

    @Override
    public void clear()
    {

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
    public  void setNextNull()
    {
        this.next = null;
    }
    public String getElement()
    {
        return element;
    }
}

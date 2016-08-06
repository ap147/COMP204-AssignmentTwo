package org.waikato.comp204.scrollback;

import javax.lang.model.element.Element;
import java.awt.image.AreaAveragingScaleFilter;
import java.time.temporal.Temporal;

/**
 * A String Scrollback implementation
 */
public class Scrollback implements ScrollbackInterface
{
    private int elementsCount;
    private int elementsLimit;

    private ElementNodes LastElement;
    private ElementNodes FirstElement;

    private int  LastScrollCount = 0;

    public  Scrollback()
    {
        elementsLimit = 10;
    }
    public  Scrollback(int limit)
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
    public void add(String item)
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
    private void AddFirst(String item)
    {
        FirstElement = new ElementNodes(item);
        LastElement = FirstElement;
        elementsCount++;

    }
    private void AddSecound(String item)
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
    private void AddingWhenFull(String item)
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
    @Override
    public String getLast()
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
            return  Temp.getElement();
        }
        else
        {
            return "";
        }

    }

    public void Show()
    {
        System.out.println("Scrollback Capacity : " + getCapacity());
        System.out.println("Current Elements : " + getCount());
        LastScrollCount = 0;
        dump();
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
    public void clear()
    {
        elementsCount = 0;
        LastScrollCount = 0;
        FirstElement = null;
        LastElement = null;
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


class ElementNodes {
    private String element;
    private ElementNodes next;

    protected ElementNodes(String _e)
    {
        element = _e;
    }

    protected ElementNodes AddElement(String s)
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
    protected String getElement()
    {
        return element;
    }
}

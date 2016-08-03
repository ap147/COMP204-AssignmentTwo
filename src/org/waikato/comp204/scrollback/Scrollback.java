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

    private int  getLastScrollCount = 0;

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
        System.out.println("Adding");
        elementsCount++;

        if(FirstElement == null)
        {
            FirstElement = new ElementNodes(item);
            LastElement = FirstElement;
            getLastScrollCount = 0;
        }
        else {


            if (!item.equals(LastElement.getElement())) {
                //if we are going over the limit, remove first element and add this one if item is not a duplicate
                if (elementsCount > elementsLimit) {
                    System.out.println("Setting First Elements Next Null!!");
                    ElementNodes Temp = FirstElement;
                    FirstElement = FirstElement.getNext();
                    Temp.setNextNull();
                    getLastScrollCount = 0;
                }
                if (elementsCount < elementsLimit) {
                    //Space Space Adding element
                    LastElement = LastElement.AddElement(item);
                    getLastScrollCount = 0;
                }
            } else {
                elementsCount--;
                getLastScrollCount = 0;
                System.out.println("Attempted to add Dumplicate!");
            }
        }
    }

    @Override
    public String getLast()
    {
        ElementNodes Temp = null;
        int TempCount = elementsCount - getLastScrollCount;
        getLastScrollCount++;

        ElementNodes Current = FirstElement;

        for(int x = 0; x < TempCount; x++)
        {
            Current = FirstElement.getNext();
        }
        return Current.getElement();

    }
    public void dump()
    {
        System.out.println();
        ElementNodes Temp = FirstElement;
        for(int x =0; x < elementsCount; x++)
        {
            System.out.println(Temp.getElement());
            Temp = Temp.getNext();
        }
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

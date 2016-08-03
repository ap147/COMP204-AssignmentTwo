package org.waikato.comp204.scrollback;

/**
 * A String Scrollback implementation
 */
public class Scrollback implements ScrollbackInterface
{
    private int elementsCount;
    public  Scrollback()
    {
        elementsCount = 10;
    }
    public  Scrollback(int amount)
    {
        elementsCount = amount;
    }
    @Override
    public void add(String item)
    {

    }

    @Override
    public String getLast()
    {
        return null;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public int getCapacity()
    {
        return elementsCount;
    }

    @Override
    public int getCount()
    {
        return 0;
    }
}

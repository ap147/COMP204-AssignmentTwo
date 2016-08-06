package org.waikato.comp204.scrollback;

import org.junit.Test;
import org.waikato.comp204.misc.PokemonEncounter;

import static org.junit.Assert.*;

/**
 * Tests for your String Scrollback implementation
 */
public class GenericScrollbackTest {
    public static void main(String[] args)
    {

    }
    /*
    Exactly 10 tests covering your String Scrollback implementation written in the ScrollbackTest file.
    Try to test the class as thoroughly as you can with your 10 tests,
    the grade allocation will take into account how thoroughly your tests cover the functionality.
     */
    @Test
    public void testGetLastRollMultipleTimer()
    {
        Scrollback x = new Scrollback();

        x.add("a");
        x.add("b");
        x.add("c");
        x.add("d");
        x.add("e");
        x.add("f");

        assertEquals("First Call to getLast was invalid",x.getLast(),"f");
        x.add("f");
        String last = x.getLast();
        last = x.getLast();
        last = x.getLast();
        assertEquals("Rolling through invalid",last,"d");
        x.add("d");
        assertEquals("Shouldve been a value which was just added",x.getLast(), "d");
    }
    @Test
    public void testConstuctors()
    {

        GenericScrollback cA = new GenericScrollback(5);
        GenericScrollback cB = new GenericScrollback(0);
        GenericScrollback cC = new GenericScrollback(-1);
        GenericScrollback cD = new GenericScrollback();
        //cA = 5
        //cB = 10
        //cC = 10
        //cD = 10
        assertEquals("cA should have capcity of 5 since 5 was passed through parametter in constructor", cA.getCapacity(), 5);
        assertEquals("cB should have capcity of 10 since invalid value (0) was passed through parametter ",cB.getCapacity(),10);
        assertEquals("cC should have capacity of 10 since invaild value (-1) was passed through parametter",cC.getCapacity(),10);
        assertEquals("cD Should have capacity of 10 since default constructor is called", cD.getCapacity(), 10);
    }

    @Test
    public void testAdd()
    {
        GenericScrollback aA = new GenericScrollback(5);
        aA.add("a");
        aA.add("b");
        aA.add("c");
        aA.add("c");
        aA.add("d");

        int count = aA.getCount();
        //Add 4 Items, on the 3th repeat that word and then unique , then check count ,it should be 4 instead of 5
        assertEquals(4,count,0);
    }

    @Test
    public void testGetLastWhenNoElements()
    {
        //What will happen when GetLast is called when no suitable elements avialable.
        GenericScrollback lwA = new GenericScrollback(5);
        assertEquals("getLast is not returning a blank when no elements", lwA.getLast(), null);
    }

    @Test
    public void testGetLastRollover()
    {
        GenericScrollback gl = new GenericScrollback(3);
        gl.add("a");
        gl.add("b");
        gl.add("c");

        gl.getLast();
        gl.getLast();
        gl.getLast();
        assertEquals("Not rolling around the list", gl.getLast(), "c");
    }

    @Test
    public void testOverAll()
    {
        GenericScrollback Oa = new GenericScrollback(15);
        Oa.add("test");
        Oa.add("bob");
        Oa.add("Geoff");
        Oa.add("COMP204");
        Oa.Show();

        assertEquals("Not Having Correct amount of Capacity", Oa.getCapacity(), 15);
        assertEquals("Not Having Correct amount of Count", Oa.getCount(), 4);


        assertEquals("Not returning correct last element", Oa.getLast(), "COMP204");
        Oa.add(Oa.getLastValue());
        Oa.Show();
        Oa.getLast();
        Oa.getLast();
        Oa.getLast();
        Oa.add(Oa.getLastValue());
        assertEquals("Didnt Return correct last element", Oa.getLastValue(), "bob");
        Oa.Show();
        assertEquals("Didnt Return correct ElementCount", Oa.getCount(), 5);

        Oa.clear();
        assertEquals("Should have no elements since just used clear()", Oa.getCount(), 0);

    }

    @Test
    public void testLastRolloverAdd()
    {
        //testing that program is rolling around list and adding at the same time when limited capacity
        GenericScrollback gLR = new GenericScrollback(3);

        gLR.add("a");
        gLR.add("b");
        gLR.add("c");
        //c
        gLR.getLast();
        gLR.add(gLR.getLastValue());
        assertEquals("Not rolling adding correctly", gLR.getLastValue(), "c");
        gLR.Show();

        //b
        gLR.getLast();
        gLR.getLast();
        gLR.add(gLR.getLastValue());
        assertEquals("Not rolling adding correctly", gLR.getLastValue(), "b");
        gLR.Show();

        //b
        gLR.getLast();
        gLR.getLast();;
        gLR.getLast();

        gLR.add(gLR.getLastValue());
        assertEquals("Not rolling adding correctly", gLR.getLastValue(), "b");
        gLR.Show();
        //List should have b,c,b
    }

    @Test
    public void testAddingReseting()
    {
        GenericScrollback Ar = new GenericScrollback();
        Ar.add("1");
        Ar.add("2");

        Ar.clear();
        assertEquals("Count/Limit should be 0 while Capacity is 10", Ar.getCount(), 0);
        Ar.add("1");
        Ar.add("2");
        assertEquals("Count/Limit should be 2 while Capacity is 10", Ar.getCount(), 2);
    }
    @Test
    public void testLowCapacity()
    {
        GenericScrollback Lc = new GenericScrollback(1);
        Lc.add("a");
        Lc.add("b");
        assertEquals("Didnt Add element when capacity is only one", Lc.getLast(), "b");
    }
    @Test
    public void testHighCapacity()
    {
        //This will go through all the add methods and confirm they all working correctly
        GenericScrollback Lc = new GenericScrollback(23);
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");
        Lc.add("a");
        Lc.add("b");

        int Size = Lc.getCount();
        assertEquals("amount of elements is not right",Size,23);
        assertEquals("This element was not added last", Lc.getLast(), "b");
    }
}
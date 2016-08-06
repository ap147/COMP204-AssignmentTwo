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
        Scrollback aA = new Scrollback(5);
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
        Scrollback lwA = new Scrollback(5);
        String x = lwA.getLast();
        int count = lwA.getCount();
        assertEquals("getLast is not returning a blank when no elements", x, "");
    }

    @Test
    public void testGetLastRollover()
    {
        Scrollback gl = new Scrollback(3);
        gl.add("a");
        gl.add("b");
        gl.add("c");

        gl.getLast();
        gl.getLast();
        gl.getLast();
        String Fourthelement = gl.getLast();
        assertEquals("Not rolling around the list", Fourthelement, "c");
    }

    @Test
    public void testOverAll()
    {
        Scrollback Oa = new Scrollback(15);
        Oa.add("test");
        Oa.add("bob");
        Oa.add("Geoff");
        Oa.add("COMP204");
        Oa.Show();

        assertEquals("Not Having Correct amount of Capacity", Oa.getCapacity(), 15);
        assertEquals("Not Having Correct amount of Count", Oa.getCount(), 4);

        String Last = Oa.getLast();
        assertEquals("Not returning correct last element", Last, "COMP204");
        Oa.add(Last);
        Oa.Show();
        Last = Oa.getLast();
        Last = Oa.getLast();
        Last = Oa.getLast();
        Oa.add(Last);
        assertEquals("Didnt Return correct last element", Last, "bob");
        Oa.Show();
        assertEquals("Didnt Return correct ElementCount", Oa.getCount(), 5);

        Oa.clear();
        assertEquals("Should have no elements since just used clear()", Oa.getCount(), 0);

    }

    @Test
    public void testLastRolloverAdd()
    {
        //testing that program is rolling around list and adding at the same time when limited capacity
        Scrollback gLR = new Scrollback(3);

        gLR.add("a");
        gLR.add("b");
        gLR.add("c");
        //c
        String x = gLR.getLast();
        gLR.add(x);
        assertEquals("Not rolling adding correctly", x, "c");
        gLR.Show();

        //b
        x = gLR.getLast();
        x = gLR.getLast();
        gLR.add(x);
        assertEquals("Not rolling adding correctly", x, "b");
        gLR.Show();

        //b
        x = gLR.getLast();
        x = gLR.getLast();
        x = gLR.getLast();
        gLR.add(x);
        assertEquals("Not rolling adding correctly", x, "b");
        gLR.Show();
        //List should have b,c,b
    }

    @Test
    public void testAddingReseting()
    {
        Scrollback Ar = new Scrollback();
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
        Scrollback Lc = new Scrollback(1);
        Lc.add("a");
        Lc.add("b");
        assertEquals("Didnt Add element when capacity is only one", Lc.getLast(), "b");
    }
    @Test
    public void testHighCapacity()
    {
        //This will go through all the add methods and confirm they all working correctly
        Scrollback Lc = new Scrollback(23);
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
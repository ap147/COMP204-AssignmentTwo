package org.waikato.comp204.scrollback;

import org.junit.Assert;
import org.junit.Test;
import org.omg.IOP.CodecPackage.FormatMismatch;

import static org.junit.Assert.*;

/**
 * Tests for your String Scrollback implementation
 */
public class ScrollbackTest {
    public static void main(String[] args)
    {
    }
    /*
    Exactly 10 tests covering your String Scrollback implementation written in the ScrollbackTest file.
    Try to test the class as thoroughly as you can with your 10 tests,
    the grade allocation will take into account how thoroughly your tests cover the functionality.
     */

    @Test
    public void testConstuctors()
    {
        Scrollback cA = new Scrollback(5);
        Scrollback cB = new Scrollback(0);
        Scrollback cC = new Scrollback(-1);
        Scrollback cD = new Scrollback();
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
        System.out.println(Fourthelement);
    }

    @Test
    public void testLastRolloverAdd()
    {

    }
}
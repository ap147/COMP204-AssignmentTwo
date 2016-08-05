package org.waikato.comp204.scrollback;

import org.junit.Assert;
import org.junit.Test;

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


    }

    @Test
    public void testAdd()
    {
        Scrollback aA = new Scrollback(5);
        Scrollback aB = new Scrollback(0);
        Scrollback aC = new Scrollback(-1);
        Scrollback aD = new Scrollback();



    }


    @Test
    public void testGetLastWhenNoElements()
    {
        Scrollback lwA = new Scrollback(5);
        String x = lwA.getLast();
        String expected = null;

    }
}
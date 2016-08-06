package org.waikato.comp204;
import org.waikato.comp204.scrollback.GenericScrollback;
import org.waikato.comp204.scrollback.Scrollback;

import java.util.Scanner;

public class AssignmentTwo
{
   // protected static String text;
    protected static String text;

    //protected static Scrollback scrollback;
    protected static GenericScrollback GenericScrollback;

    protected static int scrollbackSize;

    public static void main(String[] args)
    {
        System.out.println("AssignmentTwo Interactive Console!");
        System.out.println("Type Items follows by return to add them to the scrollback.");
        System.out.println("Special commands: ");
        System.out.println("    .    - Retrieve & add last command. Multiple periods will look back further in the scroll back");
        System.out.println("    show - Print details about scrollback");
        System.out.println("    rst  - Reset the scrollback");
        System.out.println("    quit - Exit this console");
        System.out.println();
        System.out.println();

        Scanner input = new Scanner(System.in);
        boolean go = false;
        while(!go)
        {
            System.out.println("Please enter a scrollback size (default = 10)");
            if (input.hasNextInt())
            {
                scrollbackSize = input.nextInt();
                GenericScrollback = new GenericScrollback(scrollbackSize);
                go = true;
            }
            else
            {
                GenericScrollback = new GenericScrollback();
                go = true;
            }
        }
        System.out.println("Created Scrollback of size "+ GenericScrollback.getCapacity());
        System.out.println();

        boolean exit = false;
        while(!exit)
        {
            String UserInput;
            if (input.hasNext())
            {
                UserInput = input.nextLine();
                int AmountOfDots = 0;
                //Counting amount of Dots
                for(int x = 0; x < UserInput.length(); x++)
                {
                    if(UserInput.charAt(x) ==  '.')
                    {
                        AmountOfDots++;
                    }
                }
                if(AmountOfDots != UserInput.length())
                {
                        if (UserInput.equals("exit"))
                        {
                            exit = true;
                        }
                        else if (UserInput.equals("show"))
                        {
                            GenericScrollback.Show();
                        }
                        else if (UserInput.equals("rst"))
                        {
                            GenericScrollback.clear();
                            System.out.println("");
                            System.out.println("Scrollback Reset");
                            System.out.println("Scrollback Capacity : " + GenericScrollback.getCapacity());
                            System.out.println("Current Elements : " + GenericScrollback.getCount());
                        }
                        else
                        {
                            System.out.println("Adding How it should be added");
                            GenericScrollback.add(UserInput);
                        }
                }
                else
                {
                    for(int x = 0; x < UserInput.length(); x++)
                    {
                        GenericScrollback.getLast();
                        if(x == UserInput.length())
                        {
                        }
                    }
                    if(GenericScrollback.getLastValue() != null & GenericScrollback.getLastValue() !=null)
                    {
                        System.out.println(GenericScrollback.getLastValue());
                        GenericScrollback.add(GenericScrollback.getLastValue());
                    }

                }
            }
        }
        System.out.println("AssignmentTwo Interactive Console Closed !");
    }
}

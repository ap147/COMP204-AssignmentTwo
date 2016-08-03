package org.waikato.comp204;
import org.waikato.comp204.scrollback.Scrollback;

import java.util.Scanner;

public class AssignmentTwo
{
    protected static Scrollback scrollback;
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
        while(!go) {
            System.out.println("Please enter a scrollback size (default = 10)");
            if (input.hasNextInt())
            {
                scrollbackSize = input.nextInt();
                scrollback = new Scrollback(scrollbackSize);
                go = true;
            }
            else if (input.hasNext())
            {
                System.out.println();
                System.out.println("Please Enter A Number or else leave empty");
                System.out.println();

            }
            else
            {
                scrollback = new Scrollback();
                go = true;
            }
        }
        //Create Scrollback !!!
        System.out.println("Created Scrollback of size "+ scrollback.getCapacity());
        System.out.println();

        boolean exit = false;

        while(!exit)
        {
            String UserInput;
            if (input.hasNext())
            {
                UserInput = input.next();
                if(UserInput.equals("exit"))
                {
                    exit = true;
                }
                else if(UserInput.equals("show"))
                {
                    System.out.println("Scrollback Capacity : " + scrollback.getCapacity());
                    System.out.println("Current Elements : " + scrollback.getCount());
                    scrollback.dump();
                    scrollback.dumpbygetLast();
                }
                else if(UserInput.equals("rst"))
                {
                    scrollback.clear();
                    System.out.println("");
                    System.out.println("Scrollback Reset");
                    System.out.println("Scrollback Capacity : " + scrollback.getCapacity());
                    System.out.println("Current Elements : " + scrollback.getCount());

                }
                else
                {
                    scrollback.add(UserInput);
                    System.out.println("Added.");
                }
            }

        }

        System.out.println("AssignmentTwo Interactive Console Closed !");


    }
}

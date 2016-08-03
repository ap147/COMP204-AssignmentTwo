package org.waikato.comp204;
import org.waikato.comp204.scrollback.Scrollback;

import java.util.Scanner;

public class AssignmentTwo
{
    public static void main(String[] args)
    {
        boolean go = false;
        Scrollback scrollback;

        System.out.println("AssignmentTwo Interactive Console!");
        System.out.println("Type Items follows by return to add them to the scrollback.");
        System.out.println("Special commands: ");
        System.out.println("    .    - Retrieve & add last command. Multiple periods will look back further in the scroll back");
        System.out.println("    show - Print details about scrollback");
        System.out.println("    rst  - Reset the scrollback");
        System.out.println("    quit - Exit this console");
        System.out.println();
        System.out.println();
        while(!go) {


            System.out.println("Please enter a scrollback size (default = 10)");


            Scanner input = new Scanner(System.in);
            int scrollbackSize;
            if (input.hasNextInt())
            {
                scrollbackSize = input.nextInt();
                scrollback = new Scrollback(scrollbackSize);
                go = true;
            }
            else if (input.hasNext())
            {
                System.out.println("Please Enter A Number or else leave empty");
            }
            else
            {
                scrollback = new Scrollback();
                go = true;
            }
        }
        System.out.println("Sup");

    }
}

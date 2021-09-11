package com.company;
import  java.util.Scanner;

public class CollectionManager {

    public void run() {
        String inputString;
        do
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Info");

            inputString = input.nextLine();
            System.out.println("You typed: " + inputString);

        } while (inputString.equals("Q")); // exits if input is Q
    }
}

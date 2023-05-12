package sdf;

import java.io.Console;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Welcome!");

        Console con = System.console();
        String input = "";
        double $last = 0.0;
        double number1 = 0.0;
        double number2 = 0.0;
        
        while (!input.equals("exit")) {
            input = con.readLine("> ");
            String[] inputArray = input.split(" ");

            if (inputArray[0].equals("$last")) {
                number1 = $last;
            } else {
                number1 = Double.parseDouble(inputArray[0]);
            }

            if (inputArray[2].equals("$last")) {
                number2 = $last;
            } else {
                number2 = Double.parseDouble(inputArray[2]);
            }

            if (input.contains("+")) {
                $last = number1 + number2;
                System.out.println($last);
            } else if (input.contains("-")) {
                $last = number1 - number2;
                System.out.println($last);
            } else if (input.contains("/")) {
                $last = number1 / number2;
                System.out.println($last);
            } else if (input.contains("*")) {
                $last = number1 * number2;
                System.out.println($last);
            // } else {
            //     System.out.println("Input not recognised :( Please key in number<space>operator<space>number.");
            }
        }
        System.out.println("Bye bye :)");
    }
}

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

        while (!input.equals("exit")) {
            input = con.readLine(">");
            Scanner scan = new Scanner(input);
            int number1 = scan.nextInt();
            char operator = scan.next().charAt(0);
            int number2 = scan.nextInt();

            if (operator == "+") {
                System.out.println(number1+number2);
            } else if (operator == "-") {
                System.out.println(number1-number2);
            } else if (operator == "/") {
                System.out.println(number1/number2);
            } else if (operator == "*") {
                System.out.println(number1*number2);
            } else {
                System.out.println("Input not recognised :( Please key in number<space>operator<space>number.");
            }

        }
        System.out.println("Bye bye :)");
    }
}

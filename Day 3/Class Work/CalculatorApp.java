package com.coforge.day3;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char ch;

        do {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("\nChoose Operation");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Result = " + (a + b));
                    break;

                case 2:
                    System.out.println("Result = " + (a - b));
                    break;

                case 3:
                    System.out.println("Result = " + (a * b));
                    break;

                case 4:
                    if (b != 0)
                        System.out.println("Result = " + (a / b));
                    else
                        System.out.println("Division by zero is not allowed.");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

            System.out.print("\nDo you want to continue? (Y/N): ");
            ch = sc.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');

        System.out.println("Thank you!");

        sc.close();
    }
}
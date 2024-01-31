package org.javaupskill;

import java.util.InputMismatchException;
import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lets Play FizzBuzz Game");
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter your number");

            int playerNumber = scanner.nextInt();
                System.out.println("The Fizz, Buzz and FizzBuzz numbers are: \n");
            while (playerNumber >= 0) {

                 if (playerNumber % 5 == 0) {
                     if(playerNumber % 3 == 0){
                         System.out.println("FizzBuzz \t");

                     }else {
                         System.out.println("Buzz \t");

                     }

                } else if (playerNumber % 3 == 0) {
                    System.out.println("Fizz \t");

                } else {
                    System.out.println(playerNumber);
                }
                playerNumber-=1;
            }
        }catch (InputMismatchException e){
            System.out.println("Please enter an integer");
        }
    }
}
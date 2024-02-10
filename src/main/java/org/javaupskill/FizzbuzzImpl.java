package org.javaupskill;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FizzbuzzImpl implements Fizzbuzz{


    /**
     * Runs the FizzBuzz Program
     *Start a terminal program that the accepts
     * a number and start counting down the number
     * whiles checking it against FizzBuzz
     */
    public  void checkNumber() {
        System.out.println("Lets Play FizzBuzz Game");

        try (Scanner scanner = new Scanner(System.in)) {

            startProcess(scanner);
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer greater than 0");
        }catch (Exception e){
            System.out.println("Oops Something went wrong");
        }

        }




    /**
     * private method that runs the logic
     * Accepts instantiated scanner as argument
     * @param scanner
     * prints the various FizzBuzz values of each number
     */

    public void startProcess(Scanner scanner) {
        System.out.println("Enter your number");

        int playerNumber = scanner.nextInt();

        if(playerNumber < 1){
            throw new InputMismatchException();
        }
        System.out.println("The Fizz, Buzz and FizzBuzz numbers are: \n");
        while (playerNumber >= 0) {


           String output =  (playerNumber % 5 == 0 && playerNumber % 3 == 0) ? "FizzBuzz \t"
                    : playerNumber % 3 == 0 ? "Fizz \t"
                    : playerNumber % 5 == 0 ? "Buzz \t"
                    : Integer.toString(playerNumber);

            System.out.println(output);
            playerNumber -= 1;
        }
    }
}


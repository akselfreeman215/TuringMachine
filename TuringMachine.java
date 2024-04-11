//Author:   Aksel Freeman
//Date:     13 Feb 2023
//File:     TuringMachine
//Purpose:  create a nondeterministic turing machine

//imports
import java.util.*;

//main class
public class TuringMachine {

    //variables for then state,. head location, tape, and to check the word backwards
    static int state = 0;
    static int head = 1;
    static char[] tape;
    static Stack<Character> stack = new Stack<Character>();
   
    //main method
    //enter a string that will be placed on the tape, continuously go through each state
    //until an accepted or rejected state is reached
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the input string: ");
       String input = sc.nextLine();
        while(input != ""){
           tape = ("#" + input + "#").toCharArray();
           System.out.println("Tape: " + new String(tape));
           while (state != 4 && state != 5) {
               switch (state) {
                   case 0:
                       stateZero();
                       break;
                   case 1:
                       stateOne();
                       break;
                   case 2:
                       stateTwo();
                       break;
                   case 3:
                       stateThree();
                       break;
               }
           }
           if (state == 4) {
               System.out.println("Accepted");
           } else {
               System.out.println("Rejected");
           }
           state = 0;
           head = 1;
           System.out.println();
           System.out.print("Enter the input string: ");
           input = sc.nextLine();
       }
    }
   
    //state 0 that initially checks if there is a an accepting character
    static void stateZero() {
        if (tape[head] == 'a' || tape[head] == 'b') {
            state = 1;
            head++;
        } else {
            state = 5;
        }
    }
    //state 1 that continuously checks for accepting characters until the end is reached
    static void stateOne() {
        if (tape[head] == 'a' || tape[head] == 'b') {
            head++;
        } else if (tape[head] == '#') {
            state = 2;
            head--;
        } else {
            state = 5;
        }
    }
   
    //state 2 that now checks if the backwards leter is accepted
    static void stateTwo() {
        if (tape[head] == 'a' || tape[head] == 'b') {
            state = 3;
            head--;
        } else {
            state = 5;
        }
    }
   
    //state 3 that continuosuly checks until beginning is reached
    static void stateThree() {
        if (tape[head] == 'a' || tape[head] == 'b') {
            head--;
        } else if (tape[head] == '#') {
            state = 4;
        } else {
            state = 5;
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.InputMismatchException;

/**
 * A command-line text-based Dungeons and Dragons initiative tracking tool by
 * Oliver Halberg.
 * Version 2.7
 * Last updated: 11/16/23
 */

public class InitiativeTracker {
    private ArrayList<Turn> turnorder = new ArrayList<Turn>(); // list of Turn objects to track the initiative order

    private int roundCount = 1; // variable to track rounds of combat; initialized at 1 to signify the first
                                // round

    public void showAllTurns(){
        if(this.turnorder.size() <= 0){
            System.out.println("No turns detected.");
        } else {
            System.out.println("===================== Turn Order =======================");
            for (int k = 0; k < this.turnorder.size(); k++) {
                System.out.println(this.turnorder.get(k));
            }
            System.out.println("========================================================");
        }
    }

    public static void main(String[] args) {
        InitiativeTracker tracker = new InitiativeTracker();
        Scanner scan = new Scanner(System.in);
        String input;
        String name;
        int count;
        int toRemove;
        boolean running = true;
        int i = 0;
        String entry;

        // Print welcome message
        System.out.println("================================================================================");
        System.out.println("\tWelcome to Initiative Tracker!");
        System.out.println("\tAuthor: Oliver Halberg \n\tVersion 2.7");
        System.out.println();

        while (running) { // main loop
            System.out.println( // printing instructions
                    "Type \"a\" to add a turn, \"n\" to show the next turn, \"s\" to show all turns, \"r\" to remove a turn, or \"q\" to quit: ");
            input = scan.next();
            scan.nextLine(); // clear input
            if (tracker.turnorder.size() > 0) { // if there is a turn order to sort
                Collections.sort(tracker.turnorder); // Sorts entered turns by initiative count, highest count first
            }
            switch (input) {
                case "A":
                case "a":
                    System.out.println("Enter initiative count: ");
                    try {
                        count = scan.nextInt(); // throws InputMismatchException if the user didn't enter a number
                        scan.nextLine();
                        System.out.println("Enter name: ");
                        name = scan.nextLine();
                        tracker.turnorder.add(new Turn(count, name)); // adds new Turn object to the list
                        System.out.println("Turn added.");
                    } 
                    catch (InputMismatchException e) { // handles exception where the user gave bad input
                        System.out.println("Invalid initiative count; try again: ");
                        scan.nextLine();
                    }
                    break;
                case "N":
                case "n":
                    if (tracker.turnorder.size() <= 0) {
                        System.out.println("No turns detected.");
                    } 
                    else {
                        if (i >= tracker.turnorder.size()) { // if we've gone beyond the bounds of the ArrayList
                            i = 0; // reset i
                            tracker.roundCount += 1;
                        }
                        System.out.println("====================== Round: " + tracker.roundCount + " ========================");
                        System.out.println("==================== Current Turn ======================");
                        System.out.println(tracker.turnorder.get(i));
                        System.out.println("========================================================");
                        i++;
                        try{
                            System.out.println("Next turn: " + tracker.turnorder.get(i).getName());
                        }
                        catch(IndexOutOfBoundsException e){ //if we've reached the end of the ArrayList, the next turn will be the first one
                            System.out.println("Next turn: " + tracker.turnorder.get(0).getName());
                        }
                    }
                    break;
                case "S":
                case "s":
                    tracker.showAllTurns();
                    break;
                case "R":
                case "r":
                    if (tracker.turnorder.size() <= 0) {
                        System.out.println("No turns detected.");
                    } 
                    else {
                        System.out.println("===================== Turn Order =======================");
                        for (int j = 0; j < tracker.turnorder.size(); j++) {
                            System.out.println("" + j + ": \t" + tracker.turnorder.get(j));
                        }
                        System.out.println("========================================================");
                        System.out.println("Enter the number to remove: (\"q\" to cancel)");
                        entry = scan.next();

                        if (entry.equals(("q"))) { // exiting back to loop
                            System.out.println("Cancelling...");
                        } 
                        else {
                            try {
                                toRemove = Integer.parseInt(entry);
                                if(toRemove == (i-1)){
                                    i--;
                                }
                                tracker.turnorder.remove(toRemove);
                                System.out.println("Removed " + toRemove);
                            } 
                            catch (NumberFormatException e) {
                                System.out.println("Invalid input.");
                            } 
                            catch (IndexOutOfBoundsException e) {
                                System.out.println("Invalid input.");
                            }
                        }
                    }
                    break;
                case "Q":
                case "q":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input, try again: ");
            }
            if (!running) { // if user has quit
                break;
            }
        } // end main loop
        System.out.println("================================================================================");
        scan.close();
    } // end main
} // end class InitiativeTracker

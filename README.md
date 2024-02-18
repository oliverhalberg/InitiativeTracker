# Initiative Tracker Project v2.7
#### By Oliver Halberg

## Functionality

This program provides a text-based command-line tool for tracking rounds of combat in DnD 5e and similar TTRPG systems.

### List of Commands:
- "**a**" or "**A**": Adds a turn to the tracker.
- "**n**" or "**N**": Moves to and displays the next turn in the initiative order. Increases the round counter if the new turn is the beginning of a new round. A preview of the following turn is also displayed.
- "**s**" or "**S**": Displays a list of all turns, sorted by initiative (greatest to smallest). This does not change the current turn.
- "**r**" or "**R**": Removes a turn from the tracker.
- "**q**" or "**Q**": Quits the application.

All other inputs, including invalid inputs given while adding or removing a program, will result in the user being prompted to enter the input again until a valid input is provided.

Each turn has an initiative count and a name associated with it.

### Adding Turns

Typing "**a**" or "**A**" opens the **Add Turn** menu. This prompts the user for an initiative count (an integer) and a name for the turn (a string of text). Once the information has been provided, the turn will be added to the initiative order and the program will return to the main menu.

### Removing Turns

Typing "**r**" or "**R**" opens the **Remove Turn** menu. This displays a sorted list of all of the turns in the initiative order, each with an associated number starting at 0. The user is then prompted to select a turn to remove by typing in its associated number. Once that has been provided, the turn will be removed from the list and the program will return to the main menu.

### A Note:

Currently, resolving turns that occur on the same initiative count is left to the user. 

## How to Run the Application

Currently, the application consists of the Java files `InitiativeTracker.java` and `Turn.java`. It can be run from the command line by compiling both files and running the command `java InitiativeTracker.java` in the project's directory on a machine with Java installed.

This program was written on a machine running Java 17.0. Some features may not work in older versions.

## Update Log

Log starts at v2.0; no log updates were kept for previous versions.

- 9/17/23 **v2.0**
    - Restructured code from v1.2 to allow for adding and deleting turns within same loop/better overall workflow
- 9/17/23 **v2.1**
    - Added case insensitivity to user inputs. Added this changelog.
- 9/18/23 **v2.2**
    - Restructured some code to use methods on the InitiativeTracker object; project functionality unchanged.
- 9/18/23 **v2.3**
    - Added cosmetic strings to outputs to make them look nicer.
- 10/15/23 **v2.4**
    - Added README.md. Cleaned up code to remove old comments.
- 10/16/23 **v2.5**
    - Added round counter: application now keeps track of how many rounds of combat have passed since the start of combat.
- 11/16/23 **v2.6**
    - Added preview of the next turn when showing the current turn.
- 11/16/23 **v2.7**
    - Fixed a bug where removing the current turn would cause the program to skip the following turn.

## Planned For Future Updates
- UI tweaks
- Create a `.jar` file containing the project for ease of use.
- Possibly create a new version of this application in the form of an Android application.

## Project Contents
- `InitiativeTracker.java`: The Java file containing the application.
- `README.md`: This document.
- `Turn.java`: A Java file containing the `Turn` class, which supports the main application.

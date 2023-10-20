/**
* A data structure to support the initiative tracker program.
*/

public class Turn implements Comparable<Turn>{
    private int initiative;
    private String name;

    public Turn(int initiative, String name){
        this.initiative = initiative;
        this.name = name;
    }

    public int getInitiative(){
        return this.initiative;
    }

    public String getName(){
        return this.name;
    }

    public int compareTo(Turn otherTurn){
        if(otherTurn instanceof Turn){
            otherTurn = (Turn) otherTurn;
            if(this.getInitiative() > otherTurn.getInitiative()){
                return -1;
            }
            else if(this.getInitiative() < otherTurn.getInitiative()){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            return 0; //can't compare them
        }
    }

    public String toString(){
        return "" + this.initiative + "\t" + this.name;
    }
}
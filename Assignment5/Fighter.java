// Assignment #: 5
//         Name: Arnav Babel
//    StudentID: 1225345329
//      Lecture: MWF 12:20-1:10
//  Description: Subclass of PlayerEntity that represents a player (hero) in the program

//package(s)
import java.text.DecimalFormat;

public class Fighter extends PlayerEntity {
    
    //private instance variables
    private double armor; //the armor of the fighter
    private int maxAttack; //the maximum damage a fighter can do in one attack
    private boolean isRanged; //specifies if the fighter can fight from a distance or in hand-to-hand combat

    //constructor(s)
    public Fighter(double health, String name, int stamina, int attack, String weapon, boolean isRanged) {
        super(health, name, stamina, attack, weapon);
        this.isRanged = isRanged;
        if (isRanged) {
            armor = 0.25;
            maxAttack = 125;
        } else {
            armor = 0.5;
            maxAttack = 100;
        }
    }

    //misc. methods
    public void computeCombatPower() { //a fighter's combat power will be lower if the fighter carries more armor
        if (maxAttack <= attack) {
            combatPoints = (int)((maxAttack + health) * (1 - armor));
        } else {
            combatPoints = (int)((attack + health) * (1 - armor));
        }
        if (isRanged && weapon.equals("Rock")) {
            combatPoints += 50;
        } 
        if (isRanged == false && weapon.equals("Sword")) {
            combatPoints *= 2;
        }
    }

    //toString()
    public String toString() { //outputs the statistics of the fighter
        DecimalFormat fmt = new DecimalFormat("##%");
        String str = "";
        if (isRanged == false) { //prints the statistics of a melee fighter
            str = "\nFighter Hero:\t\tMelee Type\n" + 
                   super.toString() + 
                   "\nArmor:\t\t\t" + fmt.format(armor) + "\n";
        } else { //prints the statistics of a ranged fighter
            str = "\nFighter Hero:\t\tRanged Type\n" + 
                         super.toString() +  
                         "\nArmor:\t\t\t" + fmt.format(armor) + "\n";
        }
        return str;
    }
}

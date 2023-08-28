// Assignment #: 5
//         Name: Arnav Babel
//    StudentID: 1225345329
//      Lecture: MWF 12:20-1:10
//  Description: Extends the PlayerEntity class and represents a player (hero) who can cast spells

//package(s)
import java.text.DecimalFormat;

public class Mage extends PlayerEntity {
    
    //private instance variables
    private double mana; //the current healing power of the mage (fraction that denotes percent)

    //constructor(s)
    public Mage(double health, String name, int stamina, int attack, String weapon, double mana) {
        super(health, name, stamina, attack, weapon);
        this.mana = mana;
    }

    //misc. methods
    public void computeCombatPower() { //computes the power of the mage
        combatPoints = (int)((this.attack + this.health) * (1 + this.mana));
        if (weapon.equals("Staff")) { //adds 30 to combatPoints if the weapon is a staff
            combatPoints += 30;
        }
    }

    //toString()
    public String toString() { //outputs the statistics of the mage
        DecimalFormat fmt = new DecimalFormat("##%");
        return "\nMage Hero:\n" +
               super.toString() + 
               "\nMana:\t\t\t" + fmt.format(mana) + "\n";
    }
}

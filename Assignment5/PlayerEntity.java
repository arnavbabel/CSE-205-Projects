// Assignment #: 5
//         Name: Arnav Babel
//    StudentID: 1225345329
//      Lecture: MWF 12:20-1:10
//  Description: This class represents the basic attributes of any player (hero)

public abstract class PlayerEntity {
    
    //protected instance variables
    protected double health; //current health of the player (hero)
    protected String entityName; //the name of the player (hero)
    protected int stamina; //endurance/energy/strength of a player (hero)
    protected int attack; //the damage a player (hero) does with an attack
    protected int combatPoints; //the current combat points a player (hero) has gained
    protected String weapon; //the weapon the player (hero) is wielding

    //constructor(s)
    public PlayerEntity(double health, String name, int stamina, int attack, String weapon) {
        this.health = health; 
        this.entityName = name; 
        this.stamina = stamina; 
        this.attack = attack; 
        combatPoints = 0;
        this.weapon = weapon;
    }

    //getter method(s)
    public int getCombatPoints() {
        return combatPoints;
    }

    //abstract method(s)
    public abstract void computeCombatPower();

    //toString()
    public String toString() { //outputs the statistics of the fighter inputted by the user
        return "Hero name:\t\t" + entityName + 
               "\nCurrent Health:\t\t" + health +  
               "\nStamina:\t\t" + stamina +
               "\nAttack Damage:\t\t" + attack +  
               "\nWeapon:\t\t\t" + weapon +  
               "\nCurrent Combat Points:\t" + combatPoints;
    }
}

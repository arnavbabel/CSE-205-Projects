// Assignment #: 5
//         Name: Arnav Babel
//    StudentID: 1225345329
//      Lecture: MWF 12:20-1:10
//  Description: Utility class that creates a player object (mage or fighter) from a parsable string

import java.util.ArrayList;

public class PlayerParser {
    
    public static PlayerEntity parseNewPlayer(String lineToParse) { //splits the data the user inputted and converts it
        //variables
        PlayerEntity player;
        String[] myArray = lineToParse.split("/");
        String playerType = myArray[0];
        double health = Double.parseDouble(myArray[1]);
        String name = myArray[2];
        int stamina = Integer.parseInt(myArray[3]);
        int attack = Integer.parseInt(myArray[4]);
        String weapon = myArray[5];
        
        //method(s)
        if (myArray[0].toLowerCase().equals("mage")) {
            player = new Mage(health, name, stamina, attack, weapon, Double.parseDouble(myArray[6]));
        } else if (myArray[0].toLowerCase().equals("fighter")) {
            if (myArray[6].equalsIgnoreCase("Range")) {
                myArray[6] = "true";
            } else if(myArray[6].equalsIgnoreCase("Melee")) {
                myArray[6] = "false";
            }
            player = new Fighter(health, name, stamina, attack, weapon, Boolean.parseBoolean(myArray[6]));
        } else {
            player = new Mage(0.0, "", 0, 0, "", 0.0);
        }
        return player;
    }
}

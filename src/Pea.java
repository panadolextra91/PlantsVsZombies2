import javax.swing.*;
import java.awt.*;

public class Pea {

    protected int posX;     // The x-coordinate of the pea
    protected GamePanel gp; // The parent game panel
    protected int myLane;   // The lane in which the pea is present

    // Constructor to initialize the Pea object with the given parent game panel, lane, and starting x-coordinate
    public Pea(GamePanel parent,int lane,int startX){
        this.gp = parent;   // Initialize the parent game panel
        this.myLane = lane; // Initialize the lane of the pea
        posX = startX;      // Initialize the starting x-coordinate of the pea
    }

    // Method to move the pea forward, check for collisions with zombies, and deal damage to them
    public void advance(){
        // Create a Rectangle object representing the pea's current position and size
        Rectangle pRect = new Rectangle(posX,130+myLane*120,28,28);
        
        // Iterate through all zombies in the same lane as the pea
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);
            
            // Create a Rectangle object representing the zombie's current position and size
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            
            // Check if the pea's rectangle intersects with the zombie's rectangle
            if(pRect.intersects(zRect)){
                // Decrease zombie health based on its type
                if (z instanceof NormalZombie) {
                    z.health -= 250;
                } else if (z instanceof ConeHeadZombie) {
                    z.health -= 200;
                }
                
                // Flag to check if the zombie should be removed from the game panel
                boolean exit = false;
                // If the zombie's health drops below zero, remove it from the game panel
                if(z.health < 0){
                    System.out.println("ZOMBIE DIE");   
                    gp.laneZombies.get(myLane).remove(i);   // Remove the zombie from the lane
                    GamePanel.setProgress(10);              // Update game progress
                    exit = true;                            // Set the flag to exit the loop
                }
                
                // Remove the pea from the lane
                gp.lanePeas.get(myLane).remove(this);
                
                // Break out of the loop if the zombie has been removed
                if(exit) break;
            }
        }
        
        // Move the pea forward by 15 units on the x-axis
        posX += 15;
    }

}

import java.awt.event.ActionEvent;
import javax.swing.*;

public class Peashooter extends Plant {

    public Timer shootTimer;    // Timer object to control the shooting interval of the Peashooter


    // Constructor to initialize the Peashooter object with the given parent game panel, x and y coordinates
    public Peashooter(GamePanel parent,int x,int y) {
        super(parent,x,y, 300);  // Call the Plant superclass constructor to initialize the plant object
        
        // Initialize the shootTimer with a 2000ms delay between pea shooting
        shootTimer = new Timer(2000,(ActionEvent e) -> {
            // Check if there are any zombies in the same lane as the Peashooter
            //System.out.println("SHOOT");
            if(gp.laneZombies.get(y).size() > 0) {
                // Create and add a new pea to the same lane as the Peashooter at the given x-coordinate
                gp.lanePeas.get(y).add(new Pea(gp, y, 103 + this.x * 100));
            }
        });
        shootTimer.start(); // Start the shootTimer to begin shooting peas
    }

    @Override
    public void stop(){     
        shootTimer.stop();  // Stop the shootTimer when the Peashooter is removed or the game is over
    }

}

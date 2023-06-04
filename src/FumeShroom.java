/* Name: NH1 - TTH2
Huynh Ngoc Anh Thu, ITCSIU21034
Pham Nguyen Dang Khoi, ITCSIU21196
Nguyen Tien Son, ITITIU21297
Dinh Hoang Thao Nguyen, ITITWE2008
Purpose: A simple version of the game Plants VS Zombies
*/
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * FumeShroom is a specialized type of Plant that shoots Puff projectiles to damage zombies.
 */
public class FumeShroom extends Plant {

    // Timer that controls the shooting intervals of the Fume Shroom
    public Timer shootTimer;

    // Constructor for the FumeShroom class
    public FumeShroom(GamePanel parent, int x, int y) {
        // Call the superclass constructor
        super(parent, x, y, 300);

        // Initialize and start the shootTimer with a 2000ms (2 seconds) interval
        shootTimer = new Timer(2000, (ActionEvent e) -> {
            // If there are zombies in the same lane as the Fume Shroom
            if(gp.laneZombies.get(y).size() > 0) {
                // Create and add a new Puff to the lane
                gp.lanePeas.get(y).add(new Puff(gp, y, 103 + this.x * 115));
            }
        });
        shootTimer.start();
    }

    // Override the stop method to stop the shootTimer
    @Override
    public void stop(){
        shootTimer.stop();
    }
}

/* Name: NH1 - TTH2
Huynh Ngoc Anh Thu, ITCSIU21034
Pham Nguyen Dang Khoi, ITCSIU21196
Nguyen Tien Son, ITITIU21297
Dinh Hoang Thao Nguyen, ITITWE2008
Purpose: A simple version of the game Plants VS Zombies
*/
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * FreezePeashooter is a specialized type of Plant that shoots Freeze Peas to slow down and damage zombies.
 */
public class FreezePeashooter extends Plant {

    // Timer that controls the shooting intervals of the Freeze Peashooter
    public Timer shootTimer;

    // Constructor for the FreezePeashooter class
    public FreezePeashooter(GamePanel parent, int x, int y) {
        // Call the superclass constructor
        super(parent, x, y, 300);

        // Initialize and start the shootTimer with a 2000ms (2 seconds) interval
        shootTimer = new Timer(2000, (ActionEvent e) -> {
            // If there are zombies in the same lane as the Freeze Peashooter
            if(gp.laneZombies.get(y).size() > 0) {
                // Create and add a new FreezePea to the lane
                gp.lanePeas.get(y).add(new FreezePea(gp, y, 103 + this.x * 100));
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

/* Name: NH1 - TTH2
Huynh Ngoc Anh Thu, ITCSIU21034
Pham Nguyen Dang Khoi, ITCSIU21196
Nguyen Tien Son, ITITIU21297
Dinh Hoang Thao Nguyen, ITITWE2008
Purpose: A simple version of the game Plants VS Zombies
*/
import javax.swing.*;
import java.awt.event.ActionEvent;

// The Sunflower class represents a sunflower plant that periodically produces sun tokens
public class Sunflower extends Plant {

    Timer sunProduceTimer;

    // Constructor to initialize the Sunflower object with its position on the game panel
    public Sunflower(GamePanel parent,int x,int y) {
        super(parent, x, y, 300);
        
        // Set up a timer to produce sun tokens every 15 seconds
        sunProduceTimer = new Timer(15000,(ActionEvent e) -> {
            // Create a new Sun object at the specified position
            Sun sta = new Sun(gp,60 + x*100,110 + y*120,130 + y*120);
            
            // Add the sun token to the activeSuns list and the game panel
            gp.activeSuns.add(sta);
            gp.add(sta,new Integer(1));
        });
        
        // Start the sun production timer
        sunProduceTimer.start();
    }

}

import java.awt.*;

/**
 * FreezePea is a specialized type of Pea that slows down zombies when hit.
 */
public class FreezePea extends Pea {

    // Constructor for the FreezePea class
    public FreezePea(GamePanel parent, int lane, int startX){
        // Call the superclass constructor
        super(parent, lane, startX);
    }

    // Override the advance method to implement FreezePea-specific behavior
    @Override
    public void advance(){
        // Create a Rectangle for the pea's position and size
        Rectangle pRect = new Rectangle(posX, 130 + myLane * 120, 28, 28);

        // Loop through the zombies in the same lane as the pea
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);

            // Create a Rectangle for the zombie's position and size
            Rectangle zRect = new Rectangle(z.posX, 109 + myLane * 120, 400, 120);

            // Check if the pea intersects the zombie
            if(pRect.intersects(zRect)) {
                // If the zombie is a NormalZombie, reduce its health by 250
                if (z instanceof NormalZombie) {
                    z.health -= 250;
                } 
                // If the zombie is a ConeHeadZombie, reduce its health by 200
                else if (z instanceof ConeHeadZombie) {
                    z.health -= 200;
                }

                // Slow down the zombie
                z.slow();

                // Initialize a flag to indicate whether the zombie has died
                boolean exit = false;

                // If the zombie's health is below 0, remove it and update the progress
                if(z.health < 0){
                    System.out.println("ZOMBIE DIE");
                    GamePanel.setProgress(10);
                    gp.laneZombies.get(myLane).remove(i);
                    exit = true;
                }

                // Remove the FreezePea instance from the lane
                gp.lanePeas.get(myLane).remove(this);

                // If the zombie has died, break out of the loop
                if(exit) break;
            }
        }

        // Move the pea forward by 15 units
        posX += 15;
    }
}

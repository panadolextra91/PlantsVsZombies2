// Import necessary libraries for Swing components and random numbers
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

// ConeHeadZombie class extends Zombie to create a specific type of zombie
public class ConeHeadZombie extends Zombie {

    // Constructor for the ConeHeadZombie class
    public ConeHeadZombie(GamePanel parent, int lane) {
        // Call the superclass constructor
        super(parent, lane);

        setImage(parent.coneHeadZombieImage);
    }

    // Method to set the zombie's image
    private void setImage(Image image) {
        // Set the image for the zombie
    }
}

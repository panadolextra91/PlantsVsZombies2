// Import necessary libraries for Swing components and random numbers
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

// ConeHeadZombie class extends Zombie to create a specific type of zombie
public class ConeHeadZombie extends Zombie {

    // private static final Image NORMAL_ZOMBIE_IMAGE = new ImageIcon(ConeHeadZombie.class.getResource("resources/images/zombies/zombie1.gif")).getImage();
    // private static final Image CONE_HEAD_ZOMBIE_IMAGE = new ImageIcon(ConeHeadZombie.class.getResource("resources/images/zombies/zombie2.gif")).getImage();

    // Constructor for the ConeHeadZombie class
    public ConeHeadZombie(GamePanel parent, int lane) {
        // Call the superclass constructor
        super(parent, lane);

        // Create a Random object for generating random numbers
        Random random = new Random();

        // Generate a random index (0 or 1)
        int index = random.nextInt(2);

        // Select the image path based on the random index
        String imagePath = index == 0 ? "images/zombies/zombie1.gif" : "images/zombies/zombie2.gif";

        // Debugging line to print the image path
        System.out.println("Image path: " + imagePath);

        // Set the zombie image using the parent's preloaded images
        setImage(index == 0 ? parent.normalZombieImage : parent.coneHeadZombieImage);
    }

    // Method to set the zombie's image
    private void setImage(Image image) {
        // Set the image for the zombie
    }
}

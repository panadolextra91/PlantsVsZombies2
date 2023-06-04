/* Name: NH1 - TTH2
Huynh Ngoc Anh Thu, ITCSIU21034
Pham Nguyen Dang Khoi, ITCSIU21196
Nguyen Tien Son, ITITIU21297
Dinh Hoang Thao Nguyen, ITITWE2008
Purpose: A simple version of the game Plants VS Zombies
*/
// Import necessary libraries for Swing components and random numbers
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;

// FlyZombie class extends Zombie to create a specific type of zombie
public class FlyZombie extends Zombie {

    // Constructor for the ConeHeadZombie class
    public FlyZombie(GamePanel parent, int lane) {
        // Call the superclass constructor
        super(parent, lane);

        setImage(parent.flyZombieImage);
    }

    // Method to set the zombie's image
    private void setImage(Image image) {
        // Set the image for the zombie
    }
}

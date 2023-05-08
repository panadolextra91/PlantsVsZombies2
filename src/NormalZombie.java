import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;
class NormalZombie extends Zombie {

    private static final Image NORMAL_ZOMBIE_IMAGE = new ImageIcon(NormalZombie.class.getResource("images/zombies/zombie1.gif")).getImage();
    private static final Image CONE_HEAD_ZOMBIE_IMAGE = new ImageIcon(NormalZombie.class.getResource("images/zombies/zombie2.gif")).getImage();

    public NormalZombie(GamePanel parent, int lane) {
        super(parent, lane);
        Random random = new Random();
        int index = random.nextInt(2);
        String imagePath = index == 0 ? "images/zombies/zombie1.gif" : "images/zombies/zombie2.gif";
        System.out.println("Image path: " + imagePath); // Debugging line
        setImage(index == 0 ? NORMAL_ZOMBIE_IMAGE : CONE_HEAD_ZOMBIE_IMAGE);
    }

    private void setImage(Image image) {
        // Set the image for the zombie
    }
}

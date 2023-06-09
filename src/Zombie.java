/* Name: NH1 - TTH2
Huynh Ngoc Anh Thu, ITCSIU21034
Pham Nguyen Dang Khoi, ITCSIU21196
Nguyen Tien Son, ITITIU21297
Dinh Hoang Thao Nguyen, ITITWE2008
Purpose: A simple version of the game Plants VS Zombies
*/
import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class Zombie {

    // Zombie properties
    protected int health = 1000;
    public int speed = 1;

    private GamePanel gp;

    protected int posX = 1000;
    protected int myLane;
    protected boolean isMoving = true;

    // Constructor
    public Zombie(GamePanel parent,int lane){
        this.gp = parent;
        myLane = lane;


    }

    // Advance method to move the zombie forward
    public void advance(){
        if(isMoving) {
            boolean isCollides = false;
            Collider collided = null;
            
            // Check for collisions with plants
            for (int i = myLane * 9; i < (myLane + 1) * 9; i++) {
                if (gp.colliders[i].assignedPlant != null && gp.colliders[i].isInsideCollider(posX)) {
                    isCollides = true;
                    collided = gp.colliders[i];
                }
            }
            
            // If no collision, move the zombie forward
            if (!isCollides) {
                if(slowInt>0){
                    if(slowInt % 2 == 0) {
                        posX--;
                    }
                    slowInt--;
                }else {
                    posX -= speed;
                }
            } else {    // If there's a collision, attack the plant
                collided.assignedPlant.health -= 10;
                if (collided.assignedPlant.health < 0) {
                    collided.removePlant();
                }
            }
            
            // If the zombie reaches the left side of the screen, restart the level
            if (posX < 0) {
                isMoving = false;
                JOptionPane.showMessageDialog(gp,"Bye bye!" + '\n' + "Starting the level again");
                System.out.println("Restart");
                System.exit(0);
                //GameWindow.gw = new GameWindow();
            }
        }
    }

    int slowInt = 0;
    
    // Slow method to slow down the zombie's movement
    public void slow(){
        slowInt = 1000;
    }
    
    // Factory method to create a new Zombie object based on the type parameter
    public static Zombie getZombie(String type,GamePanel parent, int lane) {
        Zombie z = null;
       switch(type) {
           case "NormalZombie" : z = new NormalZombie(parent,lane);
            System.out.println("Zombie type: NormalZombie");
                                 break;
           case "ConeHeadZombie" : z = new ConeHeadZombie(parent,lane);
            System.out.println("Zombie type: ConeHeadZombie");
                                 break;
           case "DanceZombie" : z = new DanceZombie(parent,lane);
            System.out.println("Zombie type: DanceZombie");
                                 break;
            case "FlyZombie" : z = new FlyZombie(parent,lane);
            System.out.println("Zombie type: FlyZombie");
                                 break;
           default:
               throw new IllegalArgumentException("Invalid Zombie type: "+ type);
    }
       return z;
    }


}

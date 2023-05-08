import javax.swing.*;
import java.awt.*;

public class Pea {

    protected int posX;
    protected GamePanel gp;
    protected int myLane;

    public Pea(GamePanel parent,int lane,int startX){
        this.gp = parent;
        this.myLane = lane;
        posX = startX;
    }

    // moving the pea forward and checking for collisions with zombies
    public void advance(){
        Rectangle pRect = new Rectangle(posX,130+myLane*120,28,28); //representing the pea's position and size
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) { 
            Zombie z = gp.laneZombies.get(myLane).get(i);
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            //Checks if the pea's rectangle pRect intersects with the zombie's rectangle zRect. If there's an intersection, it means the pea has hit the zombie.

            //If the pea hits a zombie, it reduces the zombie's health based on its type (250 for NormalZombie and 200 for ConeHeadZombie).
            if(pRect.intersects(zRect)){ 
                if (z instanceof NormalZombie) {
                    z.health -= 250;
                } else if (z instanceof ConeHeadZombie) {
                    z.health -= 200;
                }
                boolean exit = false;
                if(z.health < 0){
                    System.out.println("ZOMBIE DIE");
                    gp.laneZombies.get(myLane).remove(i);
                    GamePanel.setProgress(10);
                    exit = true;
                }
                gp.lanePeas.get(myLane).remove(this);
                if(exit) break;
            }
        }
        //If there was no intersection with any zombie, the pea moves 15 units forward on the x-axis.
        posX += 15;
    }

}

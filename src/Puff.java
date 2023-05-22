import java.awt.*;

// Constructor to initialize the Puff object with the given lane and starting position
public class Puff extends Pea{
    public Puff(GamePanel parent,int lane,int startX){
        super(parent,lane,startX);
    }

    // Override the advance method to increase the damage dealt by the Puff
    @Override
    public void advance(){
        // Create a rectangle representing the Puff's position
        Rectangle pRect = new Rectangle(posX,130+myLane*120,28,28);
        
        // Iterate through the zombies in the current lane
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            
            // Check if the Puff's rectangle intersects with a zombie's rectangle
            if(pRect.intersects(zRect)) {
                // If the zombie is a NormalZombie, reduce its health by 350
                if (z instanceof NormalZombie) {
                    z.health -= 350;
                } 
                // If the zombie is a ConeHeadZombie, reduce its health by 300
                else if (z instanceof ConeHeadZombie) {
                    z.health -= 300;
                }
                else if (z instanceof DanceZombie) {
                    z.health -= 250;
                }
                
                boolean exit = false;
                // If the zombie's health is below zero, remove it from the lane and update game progress
                if(z.health < 0){
                    System.out.println("ZOMBIE DIE");
                    GamePanel.setProgress(10);
                    gp.laneZombies.get(myLane).remove(i);

                    exit = true;
                }
                
                // Remove the Puff from the lane
                gp.lanePeas.get(myLane).remove(this);
                
                // If a zombie was killed, exit the loop
                if(exit) break;
            }
        }
        /*if(posX > 2000){
            gp.lanePeas.get(myLane).remove(this);
        }*/
        
        // Move the Puff forward
        posX += 15;
    }

}


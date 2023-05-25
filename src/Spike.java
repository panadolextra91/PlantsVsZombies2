import java.awt.*;

public class Spike extends Pea{
  public Spike(GamePanel parent,int lane,int startX){
        super(parent,lane,startX);
    }

    // Override the advance method to increase the damage dealt by the Spike
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
                // If the zombie is a NormalZombie, reduce its health by 400
                if (z instanceof NormalZombie) {
                    z.health -= 400;
                } 
                // If the zombie is a ConeHeadZombie, reduce its health by 350
                else if (z instanceof ConeHeadZombie) {
                    z.health -= 350;
                }
                //Update_DaneZombie_15/8
                else if (z instanceof DanceZombie) {
                    z.health -= 300;
                }
                else if (z instanceof FlyZombie) {
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
                
                // Remove the Spike from the lane
                gp.lanePeas.get(myLane).remove(this);
                
                // If a zombie was killed, exit the loop
                if(exit) break;
            }
        }

        // Move the Puff forward
        posX += 15;
    }
}

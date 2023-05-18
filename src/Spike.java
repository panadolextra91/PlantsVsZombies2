import java.awt.*;

public class Spike extends Pea {
  
  public Spike(GamePanel parent, int lane, int startX){
    
    super(parent, lane, startX);
  }
  
  @Override
  public void advance(){
    Rectangle sRect = new Rectangle(posX,130+myLane*120,28,28);
    for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
         Zombie z = gp.laneZombies.get(myLane).get(i);
         Rectangle zRect = new Rectangle(z.posX,90 + myLane*120,400,120);
            if(sRect.intersects(zRect)) {
                if (z instanceof NormalZombie) {
                    z.health -= 320;
                } else if (z instanceof ConeHeadZombie) {
                    z.health -= 300;
                } else if (z instanceof DanceZombie) {
                    z.health -=190;
                }
                boolean exit = false;
                if(z.health <= 0){
                    System.out.println("ZOMBIE DIE");
                    gp.laneZombies.get(myLane).remove(i);
                    GamePanel.setProgress(10);
                    gp.deathZombieImage.flush();
                    exit = true;
                }

                /*if (z.isDead) {
                    gp.laneZombies.get(myLane).remove(i);
                    //z.remove = true;
                    //gp.deathZombieImage.flush();
                    System.out.println("ZOM DIE");
                    GamePanel.setProgress(10);
                    //exit = true;
                }*/
                gp.lanePeas.get(myLane).remove(this);
                if(exit) break;
            }
        }
        /*if(posX > 2000){
            gp.lanePeas.get(myLane).remove(this);
        }*/
        posX += 30;
    }
    public void stopAdvance() {
        GamePanel.progress=0;
    }  
}

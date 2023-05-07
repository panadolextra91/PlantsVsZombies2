import java.awt.*;

public class Puff extends Pea{
    public Puff(GamePanel parent,int lane,int startX){
        super(parent,lane,startX);
    }

    @Override
    public void advance(){
        Rectangle pRect = new Rectangle(posX,130+myLane*120,28,28);
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            if(pRect.intersects(zRect)) {
                if (z instanceof NormalZombie) {
                    z.health -= 350;
                } else if (z instanceof ConeHeadZombie) {
                    z.health -= 300;
                }
                boolean exit = false;
                if(z.health < 0){
                    System.out.println("ZOMBIE DIE");
                    GamePanel.setProgress(10);
                    gp.laneZombies.get(myLane).remove(i);

                    exit = true;
                }
                gp.lanePeas.get(myLane).remove(this);
                if(exit) break;
            }
        }
        /*if(posX > 2000){
            gp.lanePeas.get(myLane).remove(this);
        }*/
        posX += 15;
    }

}


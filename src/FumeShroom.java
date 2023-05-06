import javax.swing.*;
import java.awt.event.ActionEvent;

public class FumeShroom extends Plant {
    public Timer shootTimer;


    public FumeShroom(GamePanel parent,int x,int y) {
        super(parent,x,y);
        shootTimer = new Timer(2000,(ActionEvent e) -> {
            //System.out.println("SHOOT");
            if(gp.laneZombies.get(y).size() > 0) {
                gp.lanePeas.get(y).add(new Puff(gp, y, 103 + this.x*115));
            }
        });
        shootTimer.start();
    }

    @Override
    public void stop(){
        shootTimer.stop();
    }

}

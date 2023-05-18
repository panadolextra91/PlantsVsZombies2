import java.awt.event.ActionEvent;
import java.swing.*;

public class Cactus extends Plant {
  
  public Timer shootTimer;
  
  public Cactus(GamePanel parent, int x, int y, int health) {
    super(parent, x, y, 300);
    shootTimer = new Timer(2000,(ActionEvent e) -> {
      //System.out.println("SHOOT");
      if(gp.laneZombies.get(y).size() >0) {
        gp.lanePeas.get(y).add(new Spike(gp, y, 103 + this.x *100));
      }
    });
    shootTimer.start();
  }
  
  @Override
  public void stop(){
    shootTimer.stop();
  }
}

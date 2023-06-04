/* Name: NH1 - TTH2
Huynh Ngoc Anh Thu, ITCSIU21034
Pham Nguyen Dang Khoi, ITCSIU21196
Nguyen Tien Son, ITITIU21297
Dinh Hoang Thao Nguyen, ITITWE2008
Purpose: A simple version of the game Plants VS Zombies
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Wallnut extends Plant{
    public Wallnut(GamePanel parent, int x, int y, int health) {
        super(parent, x, y, 2500);
      
              /*if(gp.laneZombies.get(y).size() > 0) {
            gp.lanePeas.get(y).add(new Shield(gp, y, 103 + this.x * 100));
        } */
    }



    /*public void eaten1 (Graphics g) {
        for (int i = 0; i < 45; i++) {
            g.drawImage(shield1, 60 + (i % 9) * 100, 129 + (i / 9) * 120, null);
        }
    }
    public void eaten2(Graphics g) {
        for (int i = 0; i< 45; i++) {
            g.drawImage(shield2, 60 + (i % 9) * 100, 129 + (i / 9) * 120, null);
        }
    } */

}

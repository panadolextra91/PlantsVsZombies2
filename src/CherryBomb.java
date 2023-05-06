import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CherryBomb extends Plant {
    public CherryBomb(GamePanel parent, int x, int y) {
        super(parent, x, y);
        if (gp.laneZombies.get(y).size() > 0) {
            gp.laneBombs.get(y).add(new Bomb(gp, y, 103 + this.x * 100));
        }
    }
}
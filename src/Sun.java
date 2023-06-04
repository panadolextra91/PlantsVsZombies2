/* Name: NH1 - TTH2
Huynh Ngoc Anh Thu, ITCSIU21034
Pham Nguyen Dang Khoi, ITCSIU21196
Nguyen Tien Son, ITITIU21297
Dinh Hoang Thao Nguyen, ITITWE2008
Purpose: A simple version of the game Plants VS Zombies
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// The Sun class represents a sun token that the player can collect for in-game currency
public class Sun extends JPanel implements MouseListener {

    GamePanel gp;
    Image sunImage;

    int myX;
    int myY;
    int endY;

    // Time until the sun token is removed from the game if not collected
    int destruct = 200;

    // Constructor to initialize the Sun object with the starting and ending positions
    public Sun(GamePanel parent,int startX,int startY,int endY){
        this.gp = parent;
        this.endY = endY;
        setSize(80,80);
        setOpaque(false);
        myX = startX;
        myY = startY;
        setLocation(myX,myY);
        sunImage = new ImageIcon(this.getClass().getResource("images/sun.png")).getImage();
        addMouseListener(this);
    }

    // Draws the sun token image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sunImage,0,0,null);
    }

    // Moves the sun token towards its endY position or reduces its lifespan if it has reached the endY position
    public void advance(){
        if(myY < endY) {
            myY+= 4;
        }else{
            destruct--;
            if(destruct<0){
                gp.remove(this);
                gp.activeSuns.remove(this);
            }
        }
        setLocation(myX,myY);
    }

    // Mouse event handlers
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    // When the sun token is clicked, increase the sun score and remove the token from the game
    @Override
    public void mouseReleased(MouseEvent e) {
        gp.setSunScore(gp.getSunScore()+25);
        gp.remove(this);
        gp.activeSuns.remove(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

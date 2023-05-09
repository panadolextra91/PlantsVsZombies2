import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// The PlantCard class represents a plant card in the game, which players can select to place plants on the field
public class PlantCard extends JPanel implements MouseListener {

    Image img;      // The image of the plant displayed on the card
    ActionListener al;  // ActionListener to handle the events when the card is selected

    // Constructor to initialize the PlantCard object with the given plant image
    public PlantCard(Image img){
        setSize(64,90); // Set the size of the PlantCard
        this.img = img; // Set the plant image
        addMouseListener(this); // Add a MouseListener to listen for user interaction with the card
    }

    // Set the ActionListener for the PlantCard
    public void setAction(ActionListener al){
        this.al = al;
    }

    // Paint the plant image on the PlantCard
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    // When the mouse is released, trigger the ActionListener if it is set
    @Override
    public void mouseReleased(MouseEvent e) {
        if(al != null){
            al.actionPerformed(new ActionEvent(this,ActionEvent.RESERVED_ID_MAX+1,""));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

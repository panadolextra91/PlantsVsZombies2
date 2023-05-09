// Imports necessary libraries for the Swing components and event handling
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Collider is a custom Swing component that represents a plant collider in a game.
 */
public class Collider extends JPanel implements MouseListener {

    // Declare an ActionListener for handling events
    ActionListener al;

    // Constructor for the Collider class
    public Collider(){
        // Commented out code to set a red border around the collider
        // setBorder(new LineBorder(Color.RED));

        // Make the collider transparent
        setOpaque(false);
        
        // Register this object as a MouseListener
        addMouseListener(this);

        // Set the size of the collider to 100x120 pixels
        setSize(100,120);
    }

    // Declare a Plant object to represent the assigned plant
    public Plant assignedPlant;

    // Method to set the assigned plant
    public void setPlant(Plant p){
        assignedPlant = p;
    }

    // Method to remove the assigned plant and stop its actions
    public void removePlant(){
        assignedPlant.stop();
        assignedPlant = null;
    }

    // Method to check if a point (tx) is inside the collider bounds
    public boolean isInsideCollider(int tx){
        return (tx > getLocation().x) && (tx < getLocation().x + 100);
    }

    // Method to set the ActionListener for the collider
    public void setAction(ActionListener al){
        this.al = al;
    }

    // Empty method for the mouseClicked event
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    // Empty method for the mousePressed event
    @Override
    public void mousePressed(MouseEvent e) {
    }

    // Method for the mouseReleased event
    @Override
    public void mouseReleased(MouseEvent e) {
        // If an ActionListener is set, trigger the actionPerformed event
        if(al != null){
            al.actionPerformed(new ActionEvent(this,ActionEvent.RESERVED_ID_MAX+1,""));
        }
    }

    // Empty method for the mouseEntered event
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    // Empty method for the mouseExited event
    @Override
    public void mouseExited(MouseEvent e) {
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {

    // Enum to represent different types of plants
    public enum PlantType{
        None,
        Sunflower,
        Peashooter,
        FreezePeashooter,        
        Wallnut,        
        FumeShroom;
        //CherryBomb;

    }

    //PlantType activePlantingBrush = PlantType.None;
    
    // Constructor for GameWindow
    public GameWindow(){
        // Setting up the window properties
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Huhu");

        // Creating and adding sun label to the window
        JLabel sun = new JLabel("SUN");
        sun.setLocation(37,80);
        sun.setSize(60,20);

        // Creating and adding GamePanel to the window
        GamePanel gp = new GamePanel(sun);
        gp.setLocation(0, 0);
        getLayeredPane().add(gp, new Integer(0));
        
        // Creating and adding plant cards for different plants
        PlantCard sunflower = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_sunflower.png")).getImage());
        sunflower.setLocation(110,8);
        sunflower.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Sunflower;
        });
        getLayeredPane().add(sunflower,new Integer(3));

        PlantCard peashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_peashooter.png")).getImage());
        peashooter.setLocation(175,8);
        peashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Peashooter;
        });
        getLayeredPane().add(peashooter,new Integer(3));

        PlantCard freezepeashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_freezepeashooter.png")).getImage());
        freezepeashooter.setLocation(240,8);
        freezepeashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.FreezePeashooter;
        });
        getLayeredPane().add(freezepeashooter,new Integer(3));

        PlantCard fumeshroom = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_fume.png")).getImage());
        fumeshroom.setLocation(305,8);
        fumeshroom.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.FumeShroom;
        });
        // Adding the fumeshroom label to the window
        getLayeredPane().add(fumeshroom,new Integer(3));
        
        PlantCard wallnut = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_wallnut.png")).getImage());
        wallnut.setLocation(370,8);
        wallnut.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Wallnut;
        });
        getLayeredPane().add(wallnut,new Integer(3));

        /*PlantCard cherrybomb = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_cherrybomb.png")).getImage());
        cherrybomb.setLocation(305,8);
        cherrybomb.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.CherryBomb;
        });
        getLayeredPane().add(cherrybomb,new Integer(3)); */


        // Adding the sun label to the window
        getLayeredPane().add(sun,new Integer(2));
        // Setting window properties
        setResizable(false);
        setVisible(true);
    }
    
    // Alternate constructor for GameWindow
    public GameWindow(boolean b) {
        // Creating a new menu and setting its location
        Menu menu = new Menu();
        menu.setLocation(0,0);
        
        // Setting up the window properties
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Adding the menu to the window
        getLayeredPane().add(menu,new Integer(0));
        menu.repaint();
        
        // Setting window properties
        setResizable(false);
        setVisible(true);
    }
    
    // Static variable to store the game window instance
    public static GameWindow gw;
    
    // Method to begin the game
    public static void begin() {
        gw.dispose();
       gw = new GameWindow();
    }
    public static void main(String[] args) {
          gw = new GameWindow(true);
    }

}

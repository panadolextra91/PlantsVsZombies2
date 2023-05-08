import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {

    public enum PlantType{
        None,
        Sunflower,
        Peashooter,
        FreezePeashooter,
        FumeShroom;
        //CherryBomb;

    }

    //PlantType activePlantingBrush = PlantType.None;
    
    public GameWindow(){
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel sun = new JLabel("SUN");
        sun.setLocation(37,80);
        sun.setSize(60,20);

        GamePanel gp = new GamePanel(sun);
        gp.setLocation(0,0);
        // getLayeredPane().add(gp,new Integer(0));
        getLayeredPane().add(gp, Integer.valueOf(0));
        
        PlantCard sunflower = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_sunflower.png")).getImage());
        sunflower.setLocation(110,8);
        sunflower.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Sunflower;
        });
        // getLayeredPane().add(sunflower,new Integer(3));
        getLayeredPane().add(sunflower, Integer.valueOf(3));

        PlantCard peashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_peashooter.png")).getImage());
        peashooter.setLocation(175,8);
        peashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Peashooter;
        });
        // getLayeredPane().add(peashooter,new Integer(3));
        getLayeredPane().add(peashooter, Integer.valueOf(3));

        PlantCard freezepeashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_freezepeashooter.png")).getImage());
        freezepeashooter.setLocation(240,8);
        freezepeashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.FreezePeashooter;
        });
        // getLayeredPane().add(freezepeashooter,new Integer(3));
        getLayeredPane().add(freezepeashooter, Integer.valueOf(3));

        PlantCard fumeshroom = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_fume.png")).getImage());
        fumeshroom.setLocation(305,8);
        fumeshroom.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.FumeShroom;
        });
        // getLayeredPane().add(fumeshroom,new Integer(3));
        getLayeredPane().add(fumeshroom, Integer.valueOf(3));

        /*PlantCard cherrybomb = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_cherrybomb.png")).getImage());
        cherrybomb.setLocation(305,8);
        cherrybomb.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.CherryBomb;
        });
        getLayeredPane().add(cherrybomb,new Integer(3)); */


        // getLayeredPane().add(sun,new Integer(2));
        getLayeredPane().add(sun, Integer.valueOf(2));
        setResizable(false);
        setVisible(true);
    }
    public GameWindow(boolean b) {
        Menu menu = new Menu();
        menu.setLocation(0,0);
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // getLayeredPane().add(menu,new Integer(0));
        getLayeredPane().add(menu, Integer.valueOf(0));
        menu.repaint();
        setResizable(false);
        setVisible(true);
    }
    static GameWindow gw;
    public static void begin() {
        gw.dispose();
       gw = new GameWindow();
    }
    public static void main(String[] args) {
          gw = new GameWindow(true);
    }

}

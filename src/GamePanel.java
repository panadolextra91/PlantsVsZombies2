import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public final class GamePanel extends JLayeredPane implements MouseMotionListener {
    
      // Singleton instance of the GamePanel
    // Images for game elements
    Image bgImage;
    Image peashooterImage;
    Image freezePeashooterImage;
    Image sunflowerImage;
    Image peaImage;
    Image freezePeaImage;
    Image fumeImage;
    //Image cherryBombImage;
    //Image explosionImage;
    Image fumeShroomImage;

    Image normalZombieImage;
    Image coneHeadZombieImage;
    //Image deathZombieImage;
    Collider[] colliders;

    ArrayList<ArrayList<Zombie>> laneZombies;
    ArrayList<ArrayList<Pea>> lanePeas;

    //ArrayList<ArrayList<Bomb>> laneBombs;
    ArrayList<Sun> activeSuns;

     // Timers for game events
    Timer redrawTimer;
    Timer advancerTimer;
    Timer sunProducer;
    static Timer zombieProducer;
    static Timer zombieSpawn;
    JLabel sunScoreboard;

    // Enum for the type of plant currently being placed
    GameWindow.PlantType activePlantingBrush = GameWindow.PlantType.None;

    // Variables to store the current position of the mouse
    int mouseX , mouseY;

    // Variables for sun score
    private int sunScore;

    public int getSunScore() {
        return sunScore;
    }

    public void setSunScore(int sunScore) {
        this.sunScore = sunScore;
        sunScoreboard.setText(String.valueOf(sunScore));
    }

    // Constructor for the GamePanel class
    public GamePanel(JLabel sunScoreboard){
        // Initialize instance variables and set up the game
        setSize(1000,752);
        setLayout(null);
        addMouseMotionListener(this);
        this.sunScoreboard = sunScoreboard;
        setSunScore(150);  //pool avalie

        bgImage  = new ImageIcon(this.getClass().getResource("images/mainBG.png")).getImage();

        peashooterImage = new ImageIcon(this.getClass().getResource("images/plants/peashooter.gif")).getImage();
        freezePeashooterImage = new ImageIcon(this.getClass().getResource("images/plants/freezepeashooter.gif")).getImage();
        sunflowerImage = new ImageIcon(this.getClass().getResource("images/plants/sunflower.gif")).getImage();
        fumeShroomImage = new ImageIcon(this.getClass().getResource("images/plants/7kry26.gif")).getImage();
        //cherryBombImage = new ImageIcon(this.getClass().getResource("images/plants/7kqycf.gif")).getImage();
        peaImage = new ImageIcon(this.getClass().getResource("images/pea.png")).getImage();
        freezePeaImage = new ImageIcon(this.getClass().getResource("images/freezepea.png")).getImage();
        fumeImage = new ImageIcon(this.getClass().getResource("images/puff.png")).getImage();
        //explosionImage = new ImageIcon(this.getClass().getResource("images/explosion.gif")).getImage();

        normalZombieImage = new ImageIcon(this.getClass().getResource("images/zombies/zombie1.gif")).getImage();
        coneHeadZombieImage = new ImageIcon(this.getClass().getResource("images/zombies/zombie2.gif")).getImage();
        //deathZombieImage = new ImageIcon(this.getClass().getResource("images/zombies/zomdie.gif")).getImage();

        laneZombies = new ArrayList<>();
        laneZombies.add(new ArrayList<>()); //line 1
        laneZombies.add(new ArrayList<>()); //line 2
        laneZombies.add(new ArrayList<>()); //line 3
        laneZombies.add(new ArrayList<>()); //line 4
        laneZombies.add(new ArrayList<>()); //line 5

        lanePeas = new ArrayList<>();
        lanePeas.add(new ArrayList<>()); //line 1
        lanePeas.add(new ArrayList<>()); //line 2
        lanePeas.add(new ArrayList<>()); //line 3
        lanePeas.add(new ArrayList<>()); //line 4
        lanePeas.add(new ArrayList<>()); //line 5

        /*laneBombs = new ArrayList<>();
        laneBombs.add(new ArrayList<>());
        laneBombs.add(new ArrayList<>());
        laneBombs.add(new ArrayList<>());
        laneBombs.add(new ArrayList<>());
        laneBombs.add(new ArrayList<>()); */

        colliders = new Collider[45];
        for (int i = 0; i < 45; i++) {
            Collider a = new Collider();
            a.setLocation(44 + (i%9)*100,109 + (i/9)*120);
            a.setAction(new PlantActionListener((i%9),(i/9)));
            colliders[i] = a;
            add(a,new Integer(0));
        }

        //colliders[0].setPlant(new FreezePeashooter(this,0,0));
/*
        colliders[9].setPlant(new Peashooter(this,0,1));
        laneZombies.get(1).add(new NormalZombie(this,1));*/

        activeSuns = new ArrayList<>();

        redrawTimer = new Timer(25,(ActionEvent e) -> {
            repaint();
        });
        redrawTimer.start();

        advancerTimer = new Timer(60,(ActionEvent e) -> advance());
        advancerTimer.start();

        sunProducer = new Timer(4000,(ActionEvent e) -> {
            Random rnd = new Random();
            Sun sta = new Sun(this,rnd.nextInt(800)+100,0,rnd.nextInt(300)+200);
            activeSuns.add(sta);
            add(sta,new Integer(1));
        });
        sunProducer.start();

        zombieProducer = new Timer(7000,(ActionEvent e) -> {
            Random rnd = new Random();
            LevelData lvl = new LevelData();
            String [] Level = lvl.Level[Integer.parseInt(lvl.Lvl)-1];
            int [][] LevelValue = lvl.LevelValue[Integer.parseInt(lvl.Lvl)-1];
            int l = rnd.nextInt(5);
            int t = rnd.nextInt(100);
            Zombie z = null;
            for(int i = 0;i<LevelValue.length;i++) {
                if(t>=LevelValue[i][0]&&t<=LevelValue[i][1]) {
                    z = Zombie.getZombie(Level[i],GamePanel.this,l);
                }
            }
            laneZombies.get(l).add(z);
        });
        zombieProducer.start();

        zombieSpawn = new Timer(1500,(ActionEvent e) -> {
            Random rnd = new Random();
            LevelData lvl = new LevelData();
            String [] Level = lvl.Level[Integer.parseInt(lvl.Lvl)-1];
            int [][] LevelValue = lvl.LevelValue[Integer.parseInt(lvl.Lvl)-1];
            int l = rnd.nextInt(5);
            int t = rnd.nextInt(100);
            Zombie z = null;
            for(int i = 0;i<LevelValue.length;i++) {
                if(t>=LevelValue[i][0]&&t<=LevelValue[i][1]) {
                    z = Zombie.getZombie(Level[i],GamePanel.this,l);
                }
            }
            laneZombies.get(l).add(z);
        });



    }

    // Singleton pattern implementation for GamePanel

    // Advance the game state
    private void advance(){
        for (int i = 0; i < 5 ; i++) {
            for(Zombie z : laneZombies.get(i)){
                z.advance();
            }

            for (int j = 0; j < lanePeas.get(i).size(); j++) {
                Pea p = lanePeas.get(i).get(j);
                p.advance();
            }
            /*for (int j = 0; i < laneBombs.get(i).size(); j++) {
                Bomb b = laneBombs.get(i).get(j);
                b.advance();
            } */

        }

        for (int i = 0; i < activeSuns.size() ; i++) {
            activeSuns.get(i).advance();
        }

    }

    // Paint the game elements on the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage,0,0,null);

        //Draw Plants
        for (int i = 0; i < 45; i++) {
            Collider c = colliders[i];
            if(c.assignedPlant != null){
                Plant p = c.assignedPlant;
                if(p instanceof Peashooter){
                    g.drawImage(peashooterImage,60 + (i%9)*100,129 + (i/9)*120,null);
                }
                if(p instanceof FreezePeashooter){
                    g.drawImage(freezePeashooterImage,60 + (i%9)*100,129 + (i/9)*120,null);
                }
                if(p instanceof Sunflower){
                    g.drawImage(sunflowerImage,60 + (i%9)*100,129 + (i/9)*120,null);
                }
                if (p instanceof FumeShroom) {
                    g.drawImage(fumeShroomImage, 60 +(i%9)*100, 129 + (i/9)*120, null);
                }
                /*if(p instanceof CherryBomb) {
                    g.drawImage(cherryBombImage, 60 + (i%9)*100, 129 + (i/9)*120, null);
                } */
            }
        }

        for (int i = 0; i < 5 ; i++) {
            for(Zombie z : laneZombies.get(i)){
                if(z instanceof NormalZombie){
                    g.drawImage(normalZombieImage,z.posX,90+(i*120),null);
                }else if(z instanceof ConeHeadZombie){
                    g.drawImage(coneHeadZombieImage,z.posX,90+(i*120),null);
                }
            }

            for (int j = 0; j < lanePeas.get(i).size(); j++) {
                Pea p = lanePeas.get(i).get(j);
                if(p instanceof FreezePea){
                    g.drawImage(freezePeaImage, p.posX, 130 + (i * 120), null);
                }else if (p instanceof Puff) {
                    g.drawImage(fumeImage, p.posX + 20, 140 + (i * 120), null);
                } else {
                    g.drawImage(peaImage, p.posX, 130 + (i * 120), null);
                }
            }
            /*for (int j=0; j < laneBombs.get(i).size(); j++) {
                Bomb b = laneBombs.get(i).get(j);
                    g.drawImage(explosionImage, b.posX-100, 130 + (i * 120), null);
            } */
        }

        //if(!"".equals(activePlantingBrush)){
            //System.out.println(activePlantingBrush);
            /*if(activePlantingBrush == GameWindow.PlantType.Sunflower) {
                g.drawImage(sunflowerImage,mouseX,mouseY,null);
            }*/

        //}


    }

    class PlantActionListener implements ActionListener {

        int x,y;

        public PlantActionListener(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(activePlantingBrush == GameWindow.PlantType.Sunflower){
                if(getSunScore()>=50) {
                    colliders[x + y * 9].setPlant(new Sunflower(GamePanel.this, x, y));
                    setSunScore(getSunScore()-50);
                }
            }
            if(activePlantingBrush == GameWindow.PlantType.Peashooter){
                if(getSunScore() >= 100) {
                    colliders[x + y * 9].setPlant(new Peashooter(GamePanel.this, x, y));
                    setSunScore(getSunScore()-100);
                }
            }

            if(activePlantingBrush == GameWindow.PlantType.FreezePeashooter){
                if(getSunScore() >= 175) {
                    colliders[x + y * 9].setPlant(new FreezePeashooter(GamePanel.this, x, y));
                    setSunScore(getSunScore()-175);
                }
            }
            if(activePlantingBrush == GameWindow.PlantType.FumeShroom) {
                if (getSunScore() >= 75) {
                    colliders[x + y * 9].setPlant(new FumeShroom(GamePanel.this, x, y));
                    setSunScore(getSunScore()-75);
                }
            }

            /*if(activePlantingBrush == GameWindow.PlantType.CherryBomb){
                if(getSunScore() >= 150) {
                    colliders[x + y * 9].setPlant(new CherryBomb(GamePanel.this, x, y));
                    setSunScore(getSunScore()-150);
                }
            } */

            activePlantingBrush = GameWindow.PlantType.None;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    // Static variable to track game progress
    static int progress = 0;

    // Update the game progress
    public static void setProgress(int num) {
        progress = progress + num;
        System.out.println(progress);

        if(progress == 150) {
            zombieSpawn.start();
            zombieProducer.stop();
        }
        if(progress == 550) {
            zombieSpawn.stop();
            zombieProducer.stop();
           if("1".equals(LevelData.Lvl)) {
            JOptionPane.showMessageDialog(null,"Level 1 completed !" + '\n' + "Next level.");
            GameWindow.gw.dispose();
            LevelData.write("2");
            GameWindow.gw = new GameWindow();
            progress = 0;
            }  else {
               JOptionPane.showMessageDialog(null,"Level 2 completed !" + '\n' + "New levels will be updated" + '\n' + "Reset data");
               LevelData.write("1");
               System.exit(0);
               progress = 0;
           }

        }
    }
}

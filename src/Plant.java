// The Plant class is an abstract class that serves as a base class for different types of plants
public abstract class Plant {

    public int health;

    public int x;
    public int y;

    public GamePanel gp;

    // Constructor to initialize the Plant object with the given parent game panel, x and y coordinates
    public Plant(GamePanel parent,int x,int y, int health){
        this.x = x;
        this.y = y;
        gp = parent;// Set the parent game panel reference
        this.health = health;
    }

    // Empty stop() method that can be overridden by subclasses to handle stopping any ongoing actions
    public void stop(){}

}

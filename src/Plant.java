/* Name: NH1 - TTH2
Huynh Ngoc Anh Thu, ITCSIU21034
Pham Nguyen Dang Khoi, ITCSIU21196
Nguyen Tien Son, ITITIU21297
Dinh Hoang Thao Nguyen, ITITWE2008
Purpose: A simple version of the game Plants VS Zombies
*/
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

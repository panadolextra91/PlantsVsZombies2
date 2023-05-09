import java.io.*;
import java.util.logging.Logger;

public class LevelData {
    // Variable to store the current level
    static String Lvl = "1";
    
    // 2D array to store different types of zombies for each level
   static String [][] Level = {{"NormalZombie"},{"NormalZombie","ConeHeadZombie"}};
    
    // 3D array to store spawning frequency ranges for each zombie type in each level
   static int [][][] LevelValue = {{{0,99}},{{0,49},{50,99}}} ;
    
    // Constructor for LevelData
   public LevelData() {
       try {
           File f = new File("Level.vbhv");
           
           // Check if the level file exists
           if(!f.exists()) {
               // If the file does not exist, create it and set the level to 1
               BufferedWriter bwr = new BufferedWriter(new FileWriter(f));
               bwr.write("1");
               bwr.close();
               Lvl = "1";
           } else {
               // If the file exists, read the level from the file
               BufferedReader br = new BufferedReader(new FileReader(f));
               Lvl = br.readLine();
           }
       } catch (Exception ex) {
           // Handle exceptions
           
       }
   }
    
   // Method to write the level to the file
   public static void write(String lvl) {
       File f = new File("Level.vbhv");
        try {
            BufferedWriter bwr = new BufferedWriter(new FileWriter(f));
            bwr.write(lvl);
            bwr.close();
            Lvl = lvl;  // Update the current level
        } catch (IOException ex) {
            Logger.getLogger(LevelData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
               
   }
}

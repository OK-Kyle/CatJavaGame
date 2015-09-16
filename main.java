/*
	Main application
*/
import javax.swing.*;

public class main {
    
    public static final int JFRAME_AREA_WIDTH = Constants.JFRAME_AREA_WIDTH;
    public static final int JFRAME_AREA_HEIGHT = Constants.JFRAME_AREA_HEIGHT;;
    
    public static void main(String[] args) {
        JFrame gui = new CatJFrame("Cat Game by Olivia Kyle", 3, 3, JFRAME_AREA_WIDTH, JFRAME_AREA_HEIGHT);
    }
}

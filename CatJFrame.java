/*
	CatJFrame code
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CatJFrame extends JFrame {
    
    public CatJFrame(String title, int x, int y, int width, int height) {
        setTitle(title);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel frameContent = new CatJPanel();
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
        
        frameContent.setPreferredSize(new Dimension(width, height));
        pack();
        frameContent.requestFocusInWindow();
        setVisible(true);
    }
}

/*
	Constructs the Home
	square, and defines its movements.
 */

import java.awt.*;

public class HomeSquare {
    public static final Rectangle HOME_START_AREA = Constants.HOME_START_AREA;
    public static final Rectangle GAME_SCREEN_AREA = Constants.GAME_SCREEN_AREA;
    public static final Color NICE_GRAY_COLOUR = Constants.NICE_GRAY_COLOUR; 
    public static final Color[] COLOURS = Constants.COLOURS;
    
    public static final Rectangle HOME_AREA = Constants.HOME_AREA;    
    public static final int UP = Constants.UP;
    public static final int DOWN = Constants.DOWN;
    
    private Rectangle area;
    private int speed;
    private int direction;
    
    public HomeSquare(int x, int y, int width, int height) {
        area = new Rectangle(HOME_START_AREA);
        direction = DOWN;
        speed = (int)(Math.random() * 5) + 2;
    }
    
    public Rectangle getArea() {
        return area;
    }
    
    public void changeDirection() {
        if(direction == UP) {
            direction = DOWN;
        }else if(direction == DOWN) {
            direction = UP;
        }
        changeSpeed();
    }
    
    public void changeSpeed() {
        speed = (int)(Math.random() * 5) + 2;
    }
    
    public void move() {
        int top = HOME_AREA.y;
        int bottom = HOME_AREA.height;
        
        if(direction == UP) {
            area.y -= speed;
            if(area.y < top + 1) {
                changeDirection();
                area.y = top;
            }
        }else {
            area.y += speed;
            if(area.y + area.height > bottom) {
                changeDirection();
                area.y = bottom - area.height;
            }
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(NICE_GRAY_COLOUR);
        g.fillRect(area.x, area.y, area.width, area.height);
    }
}
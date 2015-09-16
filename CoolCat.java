/*
	Constructs the Cat
 */

import java.awt.*;

public class CoolCat {
    public static final Rectangle LEO_START_AREA = Constants.LEO_START_AREA;
    
    public static final int GAME_SCREEN_AREA_TOP = Constants.GAME_SCREEN_AREA_TOP;
    public static final int GAME_SCREEN_AREA_BOTTOM = Constants.GAME_SCREEN_AREA_BOTTOM;
    public static final int GAME_SCREEN_AREA_LEFT = Constants.GAME_SCREEN_AREA_LEFT;
    public static final int GAME_SCREEN_AREA_RIGHT = Constants.GAME_SCREEN_AREA_RIGHT;
    
    public static final int UP = Constants.UP;
    public static final int DOWN = Constants.DOWN;
    public static final int LEFT = Constants.LEFT;
    public static final int RIGHT = Constants.RIGHT;
    
    private Rectangle area;
    private int speed;
    private int direction;
    
    public CoolCat() {
        area = new Rectangle(LEO_START_AREA);
        direction = UP;
        speed = 10;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public Rectangle getArea() {
        return area;
    }
    
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public boolean hasReachedHome(Rectangle homeArea) {
        if(area.intersects(homeArea)) {
            return true;
        }else {
            return false;
        }
    }
    
    public void move() {
        if(direction == UP) {
            area.y -= speed;
            if (area.y - area.width + area.width / 3 <= GAME_SCREEN_AREA_TOP) {
                setDirection(DOWN);
                area.y = GAME_SCREEN_AREA_TOP; 
            }
        }else if(direction == DOWN) {
            area.y += speed;
            if(area.y + area.width >= GAME_SCREEN_AREA_BOTTOM + area.height) {
                setDirection(UP);
                area.y = GAME_SCREEN_AREA_BOTTOM - area.height;
            }
        }else if(direction == LEFT) {
            area.x -= speed;
            if(area.x - area.width + area.width / 3 <= GAME_SCREEN_AREA_LEFT) {
                setDirection(RIGHT);
                area.x = GAME_SCREEN_AREA_LEFT;
            }
        }else {
            area.x += speed;
            if(area.x + area.width + area.width / 2 >= GAME_SCREEN_AREA_RIGHT - area.width) {
                
            }
        }
        
        if(area.x < GAME_SCREEN_AREA_LEFT || (area.x + area.width > GAME_SCREEN_AREA_RIGHT) || (area.y + area.height > GAME_SCREEN_AREA_BOTTOM) || area.y < GAME_SCREEN_AREA_TOP) {
            if(direction == UP) {
                setDirection(DOWN);
                area.y = GAME_SCREEN_AREA_TOP;
            }else if(direction == DOWN) {
                setDirection(UP);
                area.y = GAME_SCREEN_AREA_BOTTOM - area.height;
            }else if(direction == LEFT) {
                setDirection(RIGHT);
            }else {
                setDirection(LEFT);
            }
        }
    }
    
    public void draw(Graphics g) {
        int x = area.x;
        int y = area.y;
        int width = area.width;
        int height = area.height;
        if(direction == RIGHT) {
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, width + width / 3, height);
            g.fillRect(x, y + height, width / 3, height);
            g.fillRect(x + width, y + height, width / 3, height);
            g.fillRect(x - width, y - height / 4, width / 2, height / 4);
            g.fillRect(x - width / 2, y, width / 2, height / 4);
            g.fillOval(x + width, y - 5, width, height);
            g.fillOval(x + width + width / 4, y - width / 2, width / 4, height / 2);
            g.setColor(Color.BLACK);
            g.fillOval(x + width + width / 2, y, width / 4, height / 4);
        }else if(direction == LEFT) {
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, width + width / 3, height);
            g.fillRect(x, y + height, width / 3, height);
            g.fillRect(x + width, y + height, width / 3, height);
            g.fillRect(x + 2 * width - width / 3 + 2, y - height / 4, width / 2, height / 4);
            g.fillRect(x + width + width / 3, y, width / 2, height / 4);
            g.fillOval(x - width + width / 3, y - 5, width, height);
            g.fillOval(x - width / 4, y - width / 2, width / 4, height / 2);
            g.setColor(Color.BLACK);
            g.fillOval(x - width / 2, y, width / 4, height / 4);
        }else if(direction == UP) {
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, height, width + width / 3);
            g.fillRect(x + 2 * height / 5, y + width + width / 3, height / 4, width + width / 3);
            g.fillOval(x + 1, y - width + width / 3, 9 * width / 10, height);
        }else {
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, height, width + width / 3);
            g.fillRect(x + 2 * height / 5, y - width - width / 3, height / 4, width + width / 3);
            g.fillOval(x + 1, y + width, 9 * width / 10, height);
        }
    }
}
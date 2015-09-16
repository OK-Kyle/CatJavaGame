/*
 * Purpose: Constructs the Sliding
 * Walls, and defines their movement.
 * 
 * Author: Olivia Kyle
 * Date: S2 2013
 */

import java.awt.*;

public class SlidingWall {
    public static final Rectangle ALL_WALLS_AREA = Constants.ALL_WALLS_AREA;
    public static final int MAX_SLIDE_HEIGHT = 120;
    public static final int MIN_SLIDE_HEIGHT = 40;
    public static final int MAX_SLIDE_WIDTH = 25;
    public static final int MIN_SLIDE_WIDTH = 10;
    
    public static final int GAME_SCREEN_AREA_BOTTOM = Constants.GAME_SCREEN_AREA_BOTTOM;
    public static final int GAME_SCREEN_AREA_TOP = Constants.GAME_SCREEN_AREA_TOP;
    public static final Color WALL_COLOUR = Constants.WALL_COLOUR;
    
    public static final int UP = Constants.UP;
    public static final int DOWN = Constants.DOWN;
    
    private Rectangle area;
    private int speed;
    private boolean isVisible;
    private int direction;
    
    public SlidingWall() {
        speed = (int)(Math.random() * 5) + 8;
        isVisible = true;
        
        int randomDirection = (int)(Math.random() * 2) + 1;
        if(randomDirection == 1) {
            direction = UP;
        }else {
            direction = DOWN;
        }
        area = createArea();
    }
 
    public int getSpeed() {
        return speed;
    }
    
    public int getDirection() {
        return direction;
    }
    
    public boolean getIsVisible() {
        return isVisible;
    }
    
    public Rectangle getArea() {   
        return area;
    }
    
    private Rectangle createArea() {
        int x, y, width, height;
        height = (int)(Math.random() * (MAX_SLIDE_HEIGHT - MIN_SLIDE_HEIGHT + 1)) + MIN_SLIDE_HEIGHT;
        width = (int)(Math.random() * (MAX_SLIDE_WIDTH - MIN_SLIDE_WIDTH + 1)) + MIN_SLIDE_WIDTH;
        
        x = (int)(Math.random() * (ALL_WALLS_AREA.width - width) + ALL_WALLS_AREA.x);
        
        if(direction == UP) {
            y = ALL_WALLS_AREA.y + ALL_WALLS_AREA.height;
        }else {
            y = ALL_WALLS_AREA.y - (height);
        }
        
        
        Rectangle wallArea = new Rectangle(x, y, width, height);
        return wallArea;
    }
    
    public boolean intersectsTheWall(Rectangle leoArea) {
        boolean intersects = false;
        if(getArea().intersects(leoArea)) {
            intersects = true;
        }
        return intersects;
    }
    
    public void move() {
        if(direction == UP) {
            area.y -= speed;
            if(area.y <= ALL_WALLS_AREA.y - area.height) {
                isVisible = false;
            }
        }else {
            area.y += speed;
            if(area.y >= ALL_WALLS_AREA.height + ALL_WALLS_AREA.y) {
                isVisible = false;
            }   
            
        }
    }
    
    public void draw(Graphics g) {
        if(isVisible == true) {
            g.setColor(WALL_COLOUR);
            g.fillRect(area.x, area.y, area.width, area.height);
        }
    }
}


/*
	Purpose: Controlls an array of
	Sliding Wall objects, and handles
	intersection by the Cat.
 */

import java.awt.*;

public class WallsManager {
    public static final int MAX_WALLS = Constants.MAX_WALLS;
    public static final Rectangle ALL_WALLS_AREA = Constants.ALL_WALLS_AREA;
    
    private SlidingWall[] walls;
    private int numberOfWalls;
    private int speed;
    
    public WallsManager() {
        walls = new SlidingWall[MAX_WALLS];
        numberOfWalls = 0;
        speed = getSpeed();
    }
    
    public void addAWall() {
        if(numberOfWalls < MAX_WALLS) {
            walls[numberOfWalls] = new SlidingWall();
            numberOfWalls++;
        }
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = getSpeed();
    }
    
    public boolean checkIfLeoAreaIntersectsAWall(Rectangle leoArea) {
        boolean intersects = false;
        for(int i = 0; i < numberOfWalls; i++) {
            if(walls[i].intersectsTheWall(leoArea)) {
                intersects = true;
            }
        }
        return intersects;
    }
    
    public void moveTheWalls() {
        for(int i = 0; i < numberOfWalls; i++) {
            if(walls[i] != null) {
                walls[i].move();
            }
        }
        removeInvisibleWalls();
    }
    
    private void removeInvisibleWalls() {
        SlidingWall currentWall;
        int i = numberOfWalls - 1;
        while(i >= 0) {
            currentWall = walls[i];
            if(currentWall.getIsVisible() == false) {
                moveWallsDownArray(i);
                numberOfWalls--;
            }
            i--;
        }
    }
    
    private void moveWallsDownArray(int fromIndex) {
        SlidingWall currentWall = walls[fromIndex];
        for(int i = fromIndex; i < numberOfWalls - 1; i++) {
            walls[i] = walls[i + 1];
        }
    }
    
    public void drawTheWalls(Graphics g) {
        for(int i = 0; i < numberOfWalls; i++) {
            walls[i].draw(g);
        }
    }
}

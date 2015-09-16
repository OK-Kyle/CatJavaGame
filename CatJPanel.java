/*
	Handles all user interfacing, and
	drawing / moving game components
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CatJPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    
    public static final int JFRAME_AREA_WIDTH = Constants.JFRAME_AREA_WIDTH;
    public static final int JFRAME_AREA_HEIGHT = Constants.JFRAME_AREA_HEIGHT;;
    
    public static final Rectangle HOME_AREA = Constants.HOME_AREA;
    public static final Rectangle LEO_LEFT_AREA = Constants.LEO_LEFT_AREA;
    public static final Rectangle ALL_WALLS_AREA = Constants.ALL_WALLS_AREA;
    public static final Rectangle EXITING_SLIDES_AREA = Constants.EXITING_SLIDES_AREA;
    
    public static final Rectangle GAME_SCREEN_AREA = Constants.GAME_SCREEN_AREA;
    public static final Rectangle HOME_START_AREA = Constants.HOME_START_AREA;
    public static final Rectangle LEO_START_AREA = Constants.LEO_START_AREA;
    
    public static final Color NICE_GRAY_COLOUR = Constants.NICE_GRAY_COLOUR;
    public static final Color GAME_SCREEN_COLOUR = Constants.GAME_SCREEN_COLOUR;
    public static final Color SLIDES_AREA_COLOUR = Constants.SLIDES_AREA_COLOUR;
    public static final Color LEO_AREA_COLOUR = Constants.LEO_AREA_COLOUR; 
    public static final Color HOME_AREA_COLOUR = Constants.HOME_AREA_COLOUR;
    public static final Color WALL_COLOUR = Constants.WALL_COLOUR;
    
    public static final int MAX_WALLS = Constants.MAX_WALLS;
    
    public static final Font TINY_FONT = Constants.TINY_FONT;
    public static final Font SMALL_FONT = Constants.SMALL_FONT;
    public static final Font MEDIUM_FONT = Constants.MEDIUM_FONT;
    public static final Font LARGE_FONT = Constants.LARGE_FONT;
    public static final Font HUGE_FONT = Constants.HUGE_FONT;
    
    public static final int LARGE_FONT_SIZE = Constants.LARGE_FONT_SIZE;
    public static final int HUGE_FONT_SIZE = Constants.HUGE_FONT_SIZE;
    
    public static final Point TICKS_POSITION = Constants.TICKS_POSITION;
    public static final Point WINNER_LOSER_INFO_POSITION = Constants.WINNER_LOSER_INFO_POSITION;  
    public static final Point INFORMATION_POSITION1 = Constants.INFORMATION_POSITION1;
    public static final Point INFORMATION_POSITION2 = Constants.INFORMATION_POSITION2;
    public static final Point INFORMATION_POSITION3 = Constants.INFORMATION_POSITION3;
    
    public static final int TICKS_ALLOWED = Constants.TICKS_ALLOWED; 
    public static final int UP = Constants.UP;
    public static final int DOWN = Constants.DOWN;
    public static final int LEFT = Constants.LEFT;
    public static final int RIGHT = Constants.RIGHT;
    
    public static final int EASY = 0;
    public static final int MEDIUM = 1;
    public static final int HARD = 2;
    
    private CoolCat leo;
    private HomeSquare homeSquare;
    private WallsManager walls;
    private Timer timer;
    private int ticksTaken;
    private int tickCounter;
    private boolean leoHasWon;
    private boolean gameHasEnded;
    private Rectangle titleScreen;
    private boolean isShowingTitleScreen;
    private boolean playAgain;
    private int gameLevel;
    
    public CatJPanel() {
        setBackground(Color.GREEN);
        leo = new CoolCat();
        homeSquare = new HomeSquare(HOME_START_AREA.x, HOME_START_AREA.y, HOME_START_AREA.width, HOME_START_AREA.height);
        walls = new WallsManager();
        timer = new Timer(30, this);
        addKeyListener(this);
        addMouseListener(this);
        ticksTaken = 0;
        tickCounter = 0;
        leoHasWon = false;
        gameHasEnded = false;
        titleScreen = new Rectangle(GAME_SCREEN_AREA.x, GAME_SCREEN_AREA.y, JFRAME_AREA_WIDTH, JFRAME_AREA_HEIGHT);
        isShowingTitleScreen = true;
        playAgain = false;
        gameLevel = EASY;
        newGame();
    }
    
    private boolean setResultAndGetEndOfGame() {
        boolean gameResult = false;
        if(walls.checkIfLeoAreaIntersectsAWall(leo.getArea()) == true) {
            leoHasWon = false;
            gameResult = true;
        }
        if(leo.hasReachedHome(homeSquare.getArea()) == true) {
            leoHasWon = true;
            gameResult = true;
        }
        if(ticksTaken == TICKS_ALLOWED) {
            leoHasWon = false;
            gameResult = true;
        }
        return gameResult;
    }
    
    private void resetGame() {
        leo = new CoolCat();
        walls = new WallsManager();
        ticksTaken = 0;
        tickCounter = 0;
        leoHasWon = false;
        gameHasEnded = false;
        isShowingTitleScreen = false;
        changeGameToLevel();
        playAgain = false;
        timer.start();
        newGame();
    }
    
    private void setGameLevel(int gameLevel) {
        this.gameLevel = gameLevel;
    }
    
    private void changeWallsToLevel() {
        if(gameLevel == 0) {
            walls.setSpeed(walls.getSpeed() - 4);
        }
        if(gameLevel == 1) {
            walls.setSpeed(walls.getSpeed() - 2);
        }
        if(gameLevel == 2) {
            walls.setSpeed(walls.getSpeed());
        }
    }
    
    private void changeLeoToLevel() {
        if(gameLevel == 0) {
            leo.setSpeed(leo.getSpeed());
        }else {
            leo.setSpeed(leo.getSpeed() - 3);
        }
    }
    
    private void changeGameToLevel() {
        if(playAgain && leoHasWon) {
            changeWallsToLevel();
            changeLeoToLevel();
        }
    }
    
    private void newGame() {
        if(playAgain == true) {
            resetGame();
        }
        if(gameHasEnded == true && gameLevel <= 2) {
            gameLevel++;
        }
    }
    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            leo.setDirection(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            leo.setDirection(1);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            leo.setDirection(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            leo.setDirection(3);
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public void mousePressed(MouseEvent e) {
        if(gameHasEnded == false) {
            if(timer.isRunning() == true) {
                timer.stop();
            }else {
                timer.start();
            }
        }else {
            timer.stop();
        }
        Point mousePressed = e.getPoint();
        if(titleScreen != null && titleScreen.contains(mousePressed)) {
            titleScreen = null;
            isShowingTitleScreen = false;
        }
        Rectangle gameArea = new Rectangle(GAME_SCREEN_AREA.x, GAME_SCREEN_AREA.y, JFRAME_AREA_WIDTH, JFRAME_AREA_HEIGHT);
        if(gameHasEnded == true && gameArea.contains(mousePressed)) {
            playAgain = true;
        }
    }
    
    public void mouseClicked(MouseEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseReleased(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
     
    public void actionPerformed(ActionEvent e) {
        if(isShowingTitleScreen == false) {
            leo.move();
            homeSquare.move();
            walls.moveTheWalls();
            int chanceOfNewWall = (int)(Math.random() * 10) + 1;
            if(chanceOfNewWall == 1) {
                walls.addAWall();
            }
            int chanceOfChangeDirection = (int)(Math.random() *20) + 1;
            if(chanceOfChangeDirection == 1) {
                homeSquare.changeDirection();
            }
            if(setResultAndGetEndOfGame() == true) {
                timer.stop();
                gameHasEnded = true;
            }
        }
        
        repaint();
    }
    
    private void increaseTickCounter() {
        if(tickCounter < TICKS_ALLOWED) {
            tickCounter++;
        }
        increaseTicksTaken();
    }
    
    private void increaseTicksTaken() {
        if(tickCounter == 30 && ticksTaken < TICKS_ALLOWED) {
            ticksTaken++;
            tickCounter = 0;
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGameArea(g);
        homeSquare.draw(g);
        walls.drawTheWalls(g);
        drawTicks(g);
        increaseTickCounter();
        leo.draw(g);
        displayWinnerLoser(g);
        drawTitleScreen(g);
    }
    
    private void drawGameArea(Graphics g) {
        g.setColor(NICE_GRAY_COLOUR);
        g.fillRect(LEO_LEFT_AREA.x, LEO_LEFT_AREA.y, LEO_LEFT_AREA.width, LEO_LEFT_AREA.height);
        g.setColor(SLIDES_AREA_COLOUR);
        g.fillRect(ALL_WALLS_AREA.x, ALL_WALLS_AREA.y, ALL_WALLS_AREA.width, ALL_WALLS_AREA.height);
        g.setColor(HOME_AREA_COLOUR);
        g.fillRect(HOME_AREA.x, HOME_AREA.y, HOME_AREA.width, HOME_AREA.height);
        
        g.setColor(GAME_SCREEN_COLOUR);
        g.fillRect(EXITING_SLIDES_AREA.x, EXITING_SLIDES_AREA.y, EXITING_SLIDES_AREA.width, EXITING_SLIDES_AREA.height);
    }
    
    private void drawTicks(Graphics g) {
        g.setColor(WALL_COLOUR);
        g.setFont(LARGE_FONT);
        g.drawString("" + ticksTaken, TICKS_POSITION.x, TICKS_POSITION.y);
    }
    
    private void displayWinnerLoser(Graphics g) {
        g.setColor(Color.PINK);
        g.setFont(HUGE_FONT);
        if(gameHasEnded == true) {
            if(leoHasWon == true) {
                g.drawString("You Win!!", WINNER_LOSER_INFO_POSITION.x, WINNER_LOSER_INFO_POSITION.y);
                g.setFont(MEDIUM_FONT);
                
            }else {
                g.drawString("You Lose", WINNER_LOSER_INFO_POSITION.x, WINNER_LOSER_INFO_POSITION.y);
                g.setFont(MEDIUM_FONT);
                
            }
        }
    }
    
    private void drawTitleScreen(Graphics g) {
        if(titleScreen != null && isShowingTitleScreen == true) {
            g.setColor(NICE_GRAY_COLOUR);
            g.fillRect(titleScreen.x, titleScreen.y, titleScreen.width, titleScreen.height);
            g.setColor(Color.PINK);
            g.setFont(LARGE_FONT);
            g.drawString("Olivia Kyle's Cat Game!", TICKS_POSITION.x, TICKS_POSITION.y);
            g.setFont(HUGE_FONT);
            g.setColor(Color.BLUE);
            g.setFont(MEDIUM_FONT);
			g.drawString("Avoid the sliding walls,", TICKS_POSITION.x + 30, TICKS_POSITION.y + 30);
			g.drawString("Get to the homeSquare before the timer reaches", TICKS_POSITION.x + 30, TICKS_POSITION.y + 50);
			g.setColor(Color.RED);
			g.drawString(" 30 seconds!", TICKS_POSITION.x + 180, TICKS_POSITION.y + 70);
			g.setColor(Color.BLUE);
			g.drawString("Use the arrow keys to move", TICKS_POSITION.x + 30, TICKS_POSITION.y + 90);
			g.drawString("To start the game, click inside the game area.", TICKS_POSITION.x + 30, TICKS_POSITION.y + 110);
        }
    }
} 

/*
	Constants used in the game
 */

import java.awt.*;

public class Constants { 
//-------------------------------------------------------
// size of home and the Cat
//-------------------------------------------------------
    public static final int HOME_LEO_SIZE = 20; 
//-------------------------------------------------------
//  Constants to do with the three parts of the game area
//------------------------------------------------------- 
    public static final int JFRAME_AREA_WIDTH = 600;
    public static final int JFRAME_AREA_HEIGHT = 360;
    
    public static final Rectangle GAME_SCREEN_AREA = new Rectangle(0, 0, JFRAME_AREA_WIDTH - 10, JFRAME_AREA_HEIGHT - 10);
    public static final int GAME_SCREEN_AREA_TOP = GAME_SCREEN_AREA.y;
    public static final int GAME_SCREEN_AREA_BOTTOM = GAME_SCREEN_AREA.y + GAME_SCREEN_AREA.height;
    public static final int GAME_SCREEN_AREA_LEFT = GAME_SCREEN_AREA.x;
    public static final int GAME_SCREEN_AREA_RIGHT = GAME_SCREEN_AREA.x + GAME_SCREEN_AREA.width;
    
    public static final Rectangle HOME_AREA = new Rectangle(GAME_SCREEN_AREA_RIGHT - HOME_LEO_SIZE * 2, GAME_SCREEN_AREA_TOP, HOME_LEO_SIZE * 2, GAME_SCREEN_AREA.height);
    public static final Rectangle HOME_START_AREA = new Rectangle(HOME_AREA.x + HOME_LEO_SIZE / 2, HOME_AREA.y, HOME_LEO_SIZE, HOME_LEO_SIZE);
    
    public static final Rectangle LEO_LEFT_AREA = new Rectangle(GAME_SCREEN_AREA_LEFT, GAME_SCREEN_AREA_TOP, HOME_LEO_SIZE * 2, GAME_SCREEN_AREA.height); 
    public static final Rectangle LEO_START_AREA = new Rectangle(LEO_LEFT_AREA.x + HOME_LEO_SIZE / 2, LEO_LEFT_AREA.y + LEO_LEFT_AREA.height / 2 - HOME_LEO_SIZE / 2, HOME_LEO_SIZE, HOME_LEO_SIZE);
//-------------------------------------------------------
// Constants to do with the sliding walls
//-------------------------------------------------------
    public static final int MAX_WALLS = 50; 
    public static final Rectangle ALL_WALLS_AREA = new Rectangle(LEO_LEFT_AREA.x + LEO_LEFT_AREA.width, GAME_SCREEN_AREA_TOP, HOME_AREA.x - (GAME_SCREEN_AREA_LEFT + LEO_LEFT_AREA.width), GAME_SCREEN_AREA.height);
    public static final int MAX_SLIDE_HEIGHT = 120;
    public static final int MIN_SLIDE_HEIGHT = 80;
    public static final int MAX_SLIDE_WIDTH = 25;
    public static final int MIN_SLIDE_WIDTH = 10;
    //area below the middle part of the game area
    //This rectangle can be used to cover the sliding walls as they move past the bottom of the ALL_WALLS_AREA
    public static final Rectangle EXITING_SLIDES_AREA = new Rectangle(ALL_WALLS_AREA.x, GAME_SCREEN_AREA_BOTTOM, ALL_WALLS_AREA.width, MAX_SLIDE_HEIGHT);
    
//-------------------------------------------------------
// Colours which could be used for the game
//------------------------------------------------------- 
    public static final Color[] COLOURS = {new Color(224,32,32), new Color(145,32,224), new Color(32,32,224), new Color(41,223,225), new Color(27,234,56), new Color(176,228,53), new Color(255,252,29), new Color(255,138,0)};
    public static final Color NICE_GRAY_COLOUR = new Color(157, 161, 158);
    public static final Color GAME_SCREEN_COLOUR = Color.GREEN; 
    public static final Color SLIDES_AREA_COLOUR = Color.BLUE;
    public static final Color LEO_AREA_COLOUR = Color.LIGHT_GRAY; 
    public static final Color HOME_AREA_COLOUR = Color.YELLOW; 
    public static final Color WALL_COLOUR = Color.WHITE;
    
//-------------------------------------------------------
// Constants to define four directions
//-------------------------------------------------------  
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3; 
    
//-------------------------------------------------------
// Some Font sizes and Fonts
//-------------------------------------------------------
    public static final int TINY_FONT_SIZE = 12;
    public static final int VERY_SMALL_FONT_SIZE = 14;
    public static final int SMALL_FONT_SIZE = 16;
    public static final int MEDIUM_FONT_SIZE = 18;
    public static final int LARGE_FONT_SIZE = 30;
    public static final int HUGE_FONT_SIZE = 55;
    
    public static final Font TINY_FONT = new Font("ARIAL BLACK", Font.BOLD, TINY_FONT_SIZE);
    public static final Font VERY_SMALL_FONT = new Font("ARIAL BLACK", Font.BOLD, VERY_SMALL_FONT_SIZE);
    public static final Font SMALL_FONT = new Font("ARIAL BLACK", Font.CENTER_BASELINE, SMALL_FONT_SIZE);
    public static final Font MEDIUM_FONT = new Font("ARIAL", Font.CENTER_BASELINE, MEDIUM_FONT_SIZE);;
    public static final Font LARGE_FONT = new Font("ARIAL", Font.BOLD, LARGE_FONT_SIZE); 
    public static final Font HUGE_FONT = new Font("SansSerif", Font.BOLD, HUGE_FONT_SIZE);
    
    
//-------------------------------------------------------
// Possible x, y position for the game information
//-------------------------------------------------------
    public static final Point TICKS_POSITION = new Point(0, LARGE_FONT_SIZE);
    public static final Point INFORMATION_POSITION1 = new Point(400, 20);
    public static final Point INFORMATION_POSITION2 = new Point(400, 40);
    public static final Point INFORMATION_POSITION3 = new Point(400, 60);
    public static final Point WINNER_LOSER_INFO_POSITION = new Point(ALL_WALLS_AREA.x + 25, ALL_WALLS_AREA.y + HUGE_FONT_SIZE);
//-------------------------------------------------------
// Constant which limits the time allowed per game
//------------------------------------------------------- 
    public static final int TICKS_ALLOWED = 30;
    
    
}

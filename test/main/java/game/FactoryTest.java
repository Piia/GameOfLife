package main.java.game;

import org.junit.Test;
import static org.junit.Assert.*;


public class FactoryTest {
    
    private static final double TEST_ALIVE_PROBABILITY = 0.5;
    private static final int TEST_GAME_SIZE = 10;
    private static final int DEFAULT_GAME_SIZE = 100;
    
   @Test
    public void defaultGameConstructionTest() {
        GameOfLife defaultGame = Factory.defaultGame();
        int[][] defaultGrid = defaultGame.getGrid();
        assertNotNull(defaultGrid);
        assertEquals(defaultGrid.length, DEFAULT_GAME_SIZE);
        assertEquals(defaultGrid[0].length, DEFAULT_GAME_SIZE);
    }
    
    @Test
    public void customGameConstructionTest() {
        GameOfLife customGame = Factory.customGame(TEST_GAME_SIZE, TEST_ALIVE_PROBABILITY);
        int[][] customGameGrid = customGame.getGrid();
        assertNotNull(customGameGrid);
        assertEquals(customGameGrid.length, TEST_GAME_SIZE);
        assertEquals(customGameGrid[0].length, TEST_GAME_SIZE);
    }

}

package main.java.game;

import org.junit.Test;
import static org.junit.Assert.*;


public class RulesTest {
    
    private final int[][] testGrid = {
        {1, 0, 0},
        {1, 0, 0},
        {1, 0, 0}};
    private final int[][] testGridNext = {
        {0, 0, 0},
        {1, 1, 0},
        {0, 0, 0}};
    private final int[][] testGridNextNext = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}};
    
    @Test
    public void RulesNextTest() {
        int[][] next = Rules.next(testGrid);
        int[][] nextNext = Rules.next(next);
        
        assertArrayEquals(next, testGridNext);
        assertArrayEquals(nextNext, testGridNextNext);
        
    }
}

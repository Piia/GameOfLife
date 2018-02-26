package main.java.game;

public class Rules {
    
    /* 
     Rules: 
     1) A living cell stays alive if it has two or three living neighbours.
     2) A dead cell becomes alive if it has exactly three living neighbours.
     */

    
    public static int[][] next(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid.length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                newGrid[i][j] = applyRules(grid, i, j);
            }
        }
        return newGrid;
    }

    private static int applyRules(int[][] grid, int x, int y) {
        int result;
        int aliveNbrs = countAliveNeighbours(grid, x, y);

        if (grid[x][y] == 1) {
            if (aliveNbrs != 2 && aliveNbrs != 3) {
                result = 0;
            } else {
                result = 1;
            }
        } else {
            if (aliveNbrs == 3) {
                result = 1;
            } else {
                result = 0;
            }
        }
        return result;
    }

    private static int countAliveNeighbours(int[][] grid, int x, int y) {
        int count = 0;
        
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) { // do nothing
                } else if (!outOfBounds(grid.length, i, j)) {
                    if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean outOfBounds(int size, int x, int y) {
        return (x < 0) || (x >= size) || (y < 0) || (y >= size);
    }
}
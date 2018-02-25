package game;

public class Factory {

    public static GameOfLife defaultGame() {
         return new GameOfLife(new int[100][100], 0.5);
    }
    
    public static GameOfLife customGame(int size, double probability) {
         return new GameOfLife(new int[size][size], probability);
    }
    
    public static GameOfLife customGame(int[][] grid, double probability) {
         return new GameOfLife(grid, probability);
    }
    
}

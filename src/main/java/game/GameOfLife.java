package game;

import java.util.Observable;
import java.util.Random;

public class GameOfLife extends Observable implements Runnable {

    private int[][] grid;
    private final double cellAliveProbability;
    private static final int FPS = 4;

    public GameOfLife(int[][] grid, double cellAliveProbability) {
        this.grid = grid;
        this.cellAliveProbability = cellAliveProbability;
    }
    
    public int[][] getGrid() {
        return grid;
    }
    
    @Override
    public void run() {
        initiateRandomLife();        
        while(true) {
            update();
            try {
                Thread.sleep(1000/FPS);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    private void update() {
        grid = Rules.next(grid);
        setChanged();
        notifyObservers();
    }
    
    private void initiateRandomLife() {
        Random random = new Random();
        for (int[] row : grid) {
            for (int j = 0; j < grid.length; j++) {
                row[j] = random.nextDouble() < cellAliveProbability ? 1 : 0;
            }
        }
    }
}

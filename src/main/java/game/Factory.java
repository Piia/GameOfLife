package main.java.game;

public class Factory {

    public static GameOfLife defaultGame() {
         return new GameOfLife(new int[100][100], 0.5);
    }
    
    public static GameOfLife customGame(int size, double probability) {
         return new GameOfLife(new int[size][size], probability);
    }
}
package main.java.gui;

import main.java.game.Factory;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        int cellsPerSide = 100;
        double cellsAliveProbability = 0.5;
        int squareSize = 10;
        
        Runnable window = new Window(Factory.customGame(cellsPerSide, 
                cellsAliveProbability), squareSize);
        SwingUtilities.invokeLater(window);
    }
}

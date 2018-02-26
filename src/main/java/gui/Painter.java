package main.java.gui;

import main.java.game.GameOfLife;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Painter extends JPanel {
    
    private GameOfLife game;
    private final int squareSize;

    public Painter(int squareSize) {
        this.setBackground(Color.WHITE);
        this.squareSize = squareSize;
    }
    
    public Painter(GameOfLife game, int squareSize) {
        this.setBackground(Color.WHITE);
        this.game = game;
        this.squareSize = squareSize;
    }
    
    public void setGame(GameOfLife game) {
        this.game = game;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        
        if(game == null) {
            throw new IllegalStateException("Game not initialized in paint()");
        }
        
        int[][] grid = game.getGrid();
        int gridSize = grid.length;
        g.setColor(Color.BLACK);
        
        // grid lines
        for (int i = squareSize; i < squareSize*gridSize; i = i + squareSize) {
            g.drawLine(i, 0, i, squareSize*gridSize);
            g.drawLine(0, i, squareSize*gridSize, i);
        }
        
        // living cells
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == 1) {
                    g.fillRect(i * squareSize, j * squareSize, squareSize, squareSize);
                }
            }
        }
    }
}

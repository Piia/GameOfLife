package gui;

import game.GameOfLife;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public class Window implements Observer, Runnable {

    private final JFrame frame;
    private Painter painter;
    private GameOfLife game;
    private Thread gameThread;
    private final int squareSize;
    private JMenuBar menuBar;

    public Window(GameOfLife game, int squareSize) {
        this.frame = new JFrame("GAME OF LIFE");
        this.game = game;
        this.painter = new Painter(squareSize);
        this.frame.setContentPane(painter);
        this.menuBar = new JMenuBar();
        this.menuBar.add(new JLabel("Initial probability of cells to be alive:"));
        this.menuBar.add(new ProbabilitySlider(new SliderListener(this)));
        this.frame.setJMenuBar(menuBar);
        this.squareSize = squareSize;
    }

    @Override
    public void run() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(game.getGrid().length * squareSize, game.getGrid().length * squareSize);
        frame.setVisible(true);
        startNewGame(game);
    }

    @Override
    public void update(Observable o, Object arg) {
        painter.repaint();
    }
    
    public void startNewGame(GameOfLife newGame) {
        if(gameThread != null) {
            gameThread.interrupt();
        }
        this.game = newGame;
        painter.setGame(game);
        game.addObserver(this);
        
        gameThread = new Thread(game);
        gameThread.setDaemon(true);
        gameThread.start();
    }
    
    public int getGameSize() {
        return game.getGrid().length;
    }

}

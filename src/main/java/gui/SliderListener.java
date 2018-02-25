package gui;

import game.Factory;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
    
    private final Window window;
    private static final double PERCENT = 0.01;
    
    public SliderListener(Window window) {
        this.window = window;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            double probability = (int)source.getValue() * PERCENT;
            int gameSize = window.getGameSize();
            window.startNewGame(Factory.customGame(gameSize, probability));
        }
    }

}

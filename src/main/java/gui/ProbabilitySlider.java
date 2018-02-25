package gui;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class ProbabilitySlider extends JSlider {

    private static final int PROB_MIN = 0;
    private static final int PROB_MAX = 100;
    private static final int PROB_INIT = 50;
    
    public ProbabilitySlider(ChangeListener listener) {
        super(JSlider.HORIZONTAL, PROB_MIN, PROB_MAX, PROB_INIT);
        this.setMajorTickSpacing(10);
        this.setMinorTickSpacing(5);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
        this.addChangeListener(listener);
    }

}

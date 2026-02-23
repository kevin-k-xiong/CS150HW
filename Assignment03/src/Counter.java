import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Counter window shown after successful login. Tracks clicks for buttons A, B, and C.
 */
public class Counter {

    private final JFrame frame;
    private final ClickCounterModel model;
    private final JLabel aLabel;
    private final JLabel bLabel;
    private final JLabel cLabel;
    private final JLabel totalLabel;

    /**
     * Builds and shows the counter UI.
     */
    public Counter() {
        frame = createFrame();
        model = new ClickCounterModel();

        aLabel = new JLabel("A clicks: 0");
        bLabel = new JLabel("B clicks: 0");
        cLabel = new JLabel("C clicks: 0");
        totalLabel = new JLabel("Total clicks: " + ClickCounterModel.getTotalCount());

        JPanel buttonPanel = buildButtonPanel();
        JPanel labelPanel = buildLabelPanel();

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(labelPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Creates and configures the counter frame.
     *
     * @return configured counter frame
     */
    private JFrame createFrame() {
        JFrame counterFrame = new JFrame("Counter");
        counterFrame.setSize(420, 300);
        counterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        counterFrame.setLayout(new BorderLayout(10, 10));
        return counterFrame;
    }

    /**
     * Builds the panel containing the A, B, and C buttons.
     *
     * @return button panel
     */
    private JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        JButton aButton = new JButton("A");
        JButton bButton = new JButton("B");
        JButton cButton = new JButton("C");

        aButton.addActionListener(e -> onAClicked());
        bButton.addActionListener(e -> onBClicked());
        cButton.addActionListener(e -> onCClicked());

        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        buttonPanel.add(cButton);
        return buttonPanel;
    }

    /**
     * Builds the panel containing all click count labels.
     *
     * @return label panel
     */
    private JPanel buildLabelPanel() {
        JPanel labelPanel = new JPanel(new GridLayout(4, 1, 4, 6));
        labelPanel.add(aLabel);
        labelPanel.add(bLabel);
        labelPanel.add(cLabel);
        labelPanel.add(totalLabel);
        return labelPanel;
    }

    /**
     * Handles button A clicks.
     */
    private void onAClicked() {
        int a = model.incrementA();
        aLabel.setText("A clicks: " + a);
        refreshTotalLabel();
    }

    /**
     * Handles button B clicks.
     */
    private void onBClicked() {
        int b = model.incrementB();
        bLabel.setText("B clicks: " + b);
        refreshTotalLabel();
    }

    /**
     * Handles button C clicks.
     */
    private void onCClicked() {
        int c = model.incrementC();
        cLabel.setText("C clicks: " + c);
        refreshTotalLabel();
    }

    /**
     * Refreshes the total count label.
     */
    private void refreshTotalLabel() {
        totalLabel.setText("Total clicks: " + ClickCounterModel.getTotalCount());
    }
}

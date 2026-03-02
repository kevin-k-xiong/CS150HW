import java.awt.*;
import javax.swing.*;

public class ShapesView {
    private JFrame frame;
    private DrawingPanel drawingPanel;
    private JButton addShapeButton;
    private JButton clearAllButton;

    /**
     * Builds the UI bound to the provided model.
     *
     * @param model shapes model
     */
    public ShapesView(ShapesModel model) {
        frame = new JFrame("Shapes MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new DrawingPanel(model.getShapes());
        addShapeButton = new JButton("Add Shape");
        clearAllButton = new JButton("Clear All");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addShapeButton);
        buttonPanel.add(clearAllButton);

        frame.setLayout(new BorderLayout());
        frame.add(drawingPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    /**
     * Returns the Add Shape button.
     *
     * @return add button
     */
    public JButton getAddShapeButton() {
        return addShapeButton;
    }

    /**
     * Returns the Clear All button.
     *
     * @return clear button
     */
    public JButton getClearAllButton() {
        return clearAllButton;
    }

    /**
     * Repaints the drawing panel.
     */
    public void repaintPanel() {
        drawingPanel.repaint();
    }

    /**
     * Displays the window.
     */
    public void show() {
        frame.setVisible(true);
    }
}

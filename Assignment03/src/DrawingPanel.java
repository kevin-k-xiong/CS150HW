import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {

    private ArrayList<Shape> shapes;

    /**
     * Creates a drawing panel bound to the provided shape list.
     *
     * @param shapes model list of shapes to render
     */
    public DrawingPanel(ArrayList<Shape> shapes) {
        this.shapes = shapes;
        this.setPreferredSize(new Dimension(500, 400));
    }

    /**
     * Paints all current shapes.
     *
     * @param g graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape s : this.shapes) {
            s.draw(g);
        }
    }
}

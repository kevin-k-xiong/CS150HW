import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {

    private ArrayList<Shape> shapes;

    public DrawingPanel(ArrayList<Shape> shapes) {
        this.shapes = shapes;
        this.setPreferredSize(new Dimension(500, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape s : this.shapes) {
            s.draw(g);
        }
    }
}

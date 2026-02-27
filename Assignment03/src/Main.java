import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shapes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Draw one shape using your existing DrawingPanel class
            ArrayList<Shape> shapes = new ArrayList<>();
            shapes.add(new Rectangle(100, 100, 80, 60));
            shapes.add(new Circle(40, 40, 50));
            shapes.add(new Triangle(250, 120, 80, 100));
            frame.add(new DrawingPanel(shapes));

            frame.pack(); // uses DrawingPanel preferred size
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

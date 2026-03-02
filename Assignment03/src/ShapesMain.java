import javax.swing.SwingUtilities;

public class ShapesMain {
    /**
     * Starts the UI and MVC.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShapesModel model = new ShapesModel(500, 400);
            ShapesView view = new ShapesView(model);
            ShapesController controller = new ShapesController(model, view);
            controller.start();
        });
    }
}

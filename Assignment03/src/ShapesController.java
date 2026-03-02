import javax.swing.Timer;

public class ShapesController {
    private ShapesModel model;
    private ShapesView view;
    private MoveShape moveShape;
    private Timer timer;

    /**
     * Creates the controller and hooks listeners/timer.
     *
     * @param model application model
     * @param view  application view
     */
    public ShapesController(ShapesModel model, ShapesView view) {
        this.model = model;
        this.view = view;
        this.moveShape = new MoveShape();

        this.view.getAddShapeButton().addActionListener(e -> {
            this.model.addRandomShape();
            this.view.repaintPanel();
        });

        this.view.getClearAllButton().addActionListener(e -> {
            this.model.clearAll();
            this.view.repaintPanel();
        });

        this.timer = new Timer(40, e -> {
            this.model.moveShapes(this.moveShape);
            this.view.repaintPanel();
        });
    }

    /**
     * Starts the app behavior with one shape and active animation.
     */
    public void start() {
        for (int i = 0; i < 10; i++) {
            model.addRandomShape();
        }
        view.show();
        timer.start();
    }
}

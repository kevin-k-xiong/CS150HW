import java.util.ArrayList;
import java.util.Random;

public class ShapesModel {
    /**
     * Internal pairing of a shape with per-frame velocity.
     */
    private static class MovingShape {
        private Shape shape;
        private int dx;
        private int dy;

        /**
         * Creates a moving-shape record.
         *
         * @param shape shape instance
         * @param dx    horizontal velocity
         * @param dy    vertical velocity
         */
        public MovingShape(Shape shape, int dx, int dy) {
            this.shape = shape;
            this.dx = dx;
            this.dy = dy;
        }
    }

    private ArrayList<MovingShape> movingShapes;
    private ArrayList<Shape> shapes;
    private Random random;
    private int panelWidth;
    private int panelHeight;

    /**
     * Creates the model.
     *
     * @param panelWidth  drawable panel width
     * @param panelHeight drawable panel height
     */
    public ShapesModel(int panelWidth, int panelHeight) {
        this.movingShapes = new ArrayList<>();
        this.shapes = new ArrayList<>();
        this.random = new Random();
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    /**
     * Returns the shape list used by the view.
     *
     * @return shapes list
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    /**
     * Adds one random shape at a random valid location.
     */
    public void addRandomShape() {
        int shapeType = random.nextInt(3);
        Shape shape;

        if (shapeType == 0) {
            int size = 40;
            int x = random.nextInt(panelWidth - size + 1);
            int y = random.nextInt(panelHeight - size + 1);
            shape = new Circle(x, y, size);
        } else if (shapeType == 1) {
            int width = 80;
            int height = 60;
            int x = random.nextInt(panelWidth - width + 1);
            int y = random.nextInt(panelHeight - height + 1);
            shape = new Rectangle(x, y, width, height);
        } else {
            int width = 70;
            int height = 70;
            int x = random.nextInt(panelWidth - width + 1);
            int y = random.nextInt(panelHeight - height + 1);
            shape = new Triangle(x, y, height, width);
        }

        int dx = randomSpeed();
        int dy = randomSpeed();
        movingShapes.add(new MovingShape(shape, dx, dy));
        shapes.add(shape);
    }

    /**
     * Removes all shapes from the model.
     */
    public void clearAll() {
        movingShapes.clear();
        shapes.clear();
    }

    /**
     * Moves every shape and bounces them off panel boundaries.
     *
     * @param mover movement helper
     */
    public void moveShapes(MoveShape mover) {
        for (MovingShape movingShape : movingShapes) {
            Shape shape = movingShape.shape;
            int nextX = shape.getX() + movingShape.dx;
            int nextY = shape.getY() + movingShape.dy;

            if (nextX < 0 || nextX + shape.getDrawWidth() > panelWidth) {
                movingShape.dx = -movingShape.dx;
            }

            if (nextY < 0 || nextY + shape.getDrawHeight() > panelHeight) {
                movingShape.dy = -movingShape.dy;
            }

            mover.move(shape, movingShape.dx, movingShape.dy);
        }
    }

    /**
     * Produces a non-zero random speed in range [-3, 3].
     *
     * @return random speed
     */
    private int randomSpeed() {
        int speed = random.nextInt(7) - 3;
        if (speed == 0) {
            return 1;
        }
        return speed;
    }
}

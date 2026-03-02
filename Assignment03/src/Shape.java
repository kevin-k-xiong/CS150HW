import java.awt.Graphics;

public class Shape {
    private int x;
    private int y;

    /**
     * Creates a shape at the given position.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws the shape.
     *
     * @param g graphics context
     */
    public void draw(Graphics g) {
        // default behavior
    }

    /**
     * Returns the x-coordinate.
     *
     * @return x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Moves the shape by the provided delta values.
     *
     * @param dx horizontal movement
     * @param dy vertical movement
     */
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Returns the drawn width used for boundary checks.
     *
     * @return shape width in pixels
     */
    public int getDrawWidth() {
        return 0;
    }

    /**
     * Returns the drawn height used for boundary checks.
     *
     * @return shape height in pixels
     */
    public int getDrawHeight() {
        return 0;
    }
}

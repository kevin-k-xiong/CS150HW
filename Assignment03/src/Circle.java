import java.awt.Graphics;

public class Circle extends Shape {

    private int radius;

    /**
     * Creates a circle.
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param radius circle diameter used for draw width/height
     */
    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    /**
     * Draws the circle outline.
     *
     * @param g graphics context
     */
    @Override
    public void draw(Graphics g) {
        g.drawOval(this.getX(), this.getY(), this.radius, this.radius);
    }

    /**
     * Returns draw width.
     *
     * @return circle width
     */
    @Override
    public int getDrawWidth() {
        return this.radius;
    }

    /**
     * Returns draw height.
     *
     * @return circle height
     */
    @Override
    public int getDrawHeight() {
        return this.radius;
    }
}

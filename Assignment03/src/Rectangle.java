import java.awt.Graphics;

public class Rectangle extends Shape {

    private int width;
    private int height;

    /**
     * Creates a rectangle.
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param width  rectangle width
     * @param height rectangle height
     */
    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * Draws the rectangle outline.
     *
     * @param g graphics context
     */
    @Override
    public void draw(Graphics g) {
        g.drawRect(this.getX(), this.getY(), this.width, this.height);
    }

    /**
     * Returns draw width.
     *
     * @return rectangle width
     */
    @Override
    public int getDrawWidth() {
        return this.width;
    }

    /**
     * Returns draw height.
     *
     * @return rectangle height
     */
    @Override
    public int getDrawHeight() {
        return this.height;
    }
}

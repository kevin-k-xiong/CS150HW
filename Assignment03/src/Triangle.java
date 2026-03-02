import java.awt.Graphics;

public class Triangle extends Shape {
    private int height;
    private int width;

    /**
     * Creates a triangle.
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param height triangle height
     * @param width  triangle width
     */
    public Triangle(int x, int y, int height, int width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    /**
     * Creates a triangle at origin.
     *
     * @param height triangle height
     * @param width  triangle width
     */
    public Triangle(int height, int width) {
        this(0, 0, height, width);
    }

    /**
     * Draws the triangle outline.
     *
     * @param g graphics context
     */
    @Override
    public void draw(Graphics g) {
        int x = this.getX();
        int y = this.getY();

        int[] xPoints = { x, x + this.width / 2, x + this.width };
        int[] yPoints = { y + this.height, y, y + this.height };

        g.drawPolygon(xPoints, yPoints, 3);
    }

    /**
     * Returns draw width.
     *
     * @return triangle width
     */
    @Override
    public int getDrawWidth() {
        return this.width;
    }

    /**
     * Returns draw height.
     *
     * @return triangle height
     */
    @Override
    public int getDrawHeight() {
        return this.height;
    }
}

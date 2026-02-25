import java.awt.Graphics;

public class Triangle extends Shape {
    protected int height;
    protected int width;

    public Triangle(int x, int y, int height, int width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public Triangle(int height, int width) {
        this(0, 0, height, width);
    }

    @Override
    public void draw(Graphics g) {
        
    }
}

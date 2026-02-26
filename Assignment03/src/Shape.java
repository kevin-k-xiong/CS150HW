import java.awt.Graphics;

public class Shape {

    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        // default behavior
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

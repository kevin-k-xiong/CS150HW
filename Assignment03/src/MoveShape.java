public class MoveShape {
    /**
     * Moves the given shape by the provided deltas.
     *
     * @param shape shape to move
     * @param dx    horizontal delta
     * @param dy    vertical delta
     */
    public void move(Shape shape, int dx, int dy) {
        if (shape == null) {
            return;
        }
        shape.move(dx, dy);
    }
}

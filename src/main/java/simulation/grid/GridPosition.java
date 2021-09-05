package simulation.grid;

public class GridPosition {
    protected int vertical;
    protected int horizontal;

    public GridPosition(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", vertical, horizontal);
    }
}

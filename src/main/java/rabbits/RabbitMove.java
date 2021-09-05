package rabbits;

import simulation.grid.GridPosition;

public enum RabbitMove {
    MOVELEFT(0, -1),
    MOVERIGHT(0,1),
    MOVEUP(1, 0),
    MOVEDOWN(-1, 0),
    WAIT(0,0);

    private final int horizontal;
    private final int vertical;

    RabbitMove(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public void execute(Rabbit rabbit) {
        rabbit.position = new GridPosition(
    rabbit.position.getVertical() + vertical,
    rabbit.position.getHorizontal() + horizontal
        );
    }
}

package rabbits;

import simulation.Agent;
import simulation.grid.GridPosition;
import simulation.grid.GridWorld;

public class Rabbit implements Agent<Habitat> {
    protected GridPosition position;

    public Rabbit(GridPosition initialPosition) {
        position = initialPosition;
    }

    @Override
    public void doStep(Habitat world) {
        RabbitMove moves[] = world.possibleMoves(this);
        int chosenMoveIndex = (int) (Math.random() * moves.length);

        RabbitMove chosenMove = moves[chosenMoveIndex];
        chosenMove.execute(this);

        System.out.println(position);
    }
}

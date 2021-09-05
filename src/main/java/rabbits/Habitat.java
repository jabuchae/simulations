package rabbits;

import simulation.Simulation;
import simulation.grid.GridPosition;
import simulation.grid.GridWorld;

import java.util.ArrayList;
import java.util.List;

public class Habitat extends GridWorld {

    public static void main(String[] args) {
        Simulation<Habitat> simulation = new Simulation<>();
        simulation.setWorld(new Habitat(10,10));
        simulation.addAgent(new Rabbit(new GridPosition(5, 5)));
        simulation.start();
    }

    public Habitat(int width, int height) {
        super(width, height);
    }

    public RabbitMove[] possibleMoves(Rabbit rabbit) {
        int horizontalPosition = rabbit.position.getHorizontal();
        int verticalPosition = rabbit.position.getVertical();
        List<RabbitMove> moves = new ArrayList<>();

        if(horizontalPosition + 1 < width) {
            moves.add(RabbitMove.MOVERIGHT);
        }

        if(horizontalPosition - 1 >= 0) {
            moves.add(RabbitMove.MOVELEFT);
        }

        if(verticalPosition + 1 < height) {
            moves.add(RabbitMove.MOVEUP);
        }

        if(verticalPosition - 1 >= 0) {
            moves.add(RabbitMove.MOVEDOWN);
        }

        moves.add(RabbitMove.WAIT);

        RabbitMove[] movesArray = new RabbitMove[moves.size()];
        for (int i=0; i<movesArray.length; i++) {
            movesArray[i] = moves.get(i);
        }
        return movesArray;
    }
}

package simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation<World> {
    private long maxCycles = 1000L;
    private World world;
    private List<Agent<World>> agents = new ArrayList<>();
    private Object[] agentsArray = new Object[0];

    public Simulation() {}
    public Simulation(long maxCycles ) {
        this.maxCycles = maxCycles;
    }

    public void addAgent(Agent<World> agent) {
        agents.add(agent);
    }

    @SuppressWarnings("unchecked")
    private void shuffleAgentsArray() {
        int shuffles = agents.size() * 4;
        for(int i=0; i<shuffles; i++) {
            int index1 = randomAgentIndex();
            int index2 = randomAgentIndex();
            Object agent1 = agentsArray[index1];
            Object agent2 = agentsArray[index2];
            agentsArray[index1] = agent2;
            agentsArray[index2] = agent1;
        }
    }

    private int randomAgentIndex() {
        int index = (int) (Math.random() * agents.size());
        if (index == agents.size()) {
            index--;
        }
        return index;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void start() {
        agentsArray = new Object[agents.size()];
        for (int i=0; i<agentsArray.length; i++) {
            agentsArray[i] = agents.get(i);
        }

        for(long i = 0L; i < maxCycles; i++) {
            shuffleAgentsArray();
            for(Object agent : agentsArray) {
                ((Agent<World>)agent).doStep(world);
            }
        }
    }
}

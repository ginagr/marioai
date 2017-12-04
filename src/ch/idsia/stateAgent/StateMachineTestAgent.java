package ch.idsia.stateAgent;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.TopLevelFSM;


/**
 * Agent file for our AI
 */
public class StateMachineTestAgent implements Agent {

    private String name;
    private boolean[] action;
    TopLevelFSM TSM;
    private static int count;

    public StateMachineTestAgent()
    {
        setName("StateMachineTestAgent");
        reset();
        //creates new TSM
        this.TSM = new TopLevelFSM();
        //reset count
        count = 0;
    }

    /**
     * For every new level/game, reset all variables
     */
    public void reset() {
        action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_SPEED] = true;
        this.TSM = new TopLevelFSM();
        count = 0;
        System.out.println("RESETTING");
    }

    /**
     *
     * @param observation
     * @return the actions of Mario
     */
    public boolean[] getAction(Environment observation)
    {
        //pause mario to make him look like he is thinking (for 30 calls to getAction)
        if(count < 30) {
            action[Mario.KEY_SPEED] = false;
            action[Mario.KEY_LEFT] = false;
            action[Mario.KEY_RIGHT] = false;
            action[Mario.KEY_JUMP] = false;
            count++;
            return action;
        } else {
            count++;
        }
        //randomly choose when mario pauses again (every 500-700 calls to getAction)
        double rand = Math.floor(Math.random() * 500) + 200;
        if(count > rand) {
            count = 0;
        }

        //get Mario actions from TSM
        action = TSM.getAction(observation);
        TSM.update(observation);

        return action;
    }


    public Agent.AGENT_TYPE getType()
    {
        return Agent.AGENT_TYPE.AI;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }
}

package ch.idsia.stateAgent;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.engine.sprites.Sprite;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;

import java.awt.*;
import java.util.Map;

public class StateAgent implements Agent
{
    private String name;
    private boolean[] action;


    public StateAgent()
    {
        setName("StateAgent");
        reset();
    }

    public void reset()
    {
        action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_SPEED] = true;
    }

    public boolean[] getAction(Environment observation)
    {
//        try {Thread.sleep (39);}
//        catch (Exception e){}
        Helper helper = new Helper(observation);

        action[Mario.KEY_SPEED] = action[Mario.KEY_JUMP] =  observation.mayMarioJump() || !observation.isMarioOnGround();
        return action;
    }


    public Agent.AGENT_TYPE getType()
    {
        return Agent.AGENT_TYPE.AI;
    }

    public String getName() {        return name;    }

    public void setName(String Name) { this.name = Name;    }
}

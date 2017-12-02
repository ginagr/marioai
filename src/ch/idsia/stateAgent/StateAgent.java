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

//        byte[][] enemies = observation.getLevelSceneObservationZ(3);

//        for (byte[] aLevelScene : enemies) {
//            for (byte anALevelScene : aLevelScene) {
//                System.out.print(anALevelScene + "\t");
//            }
//            System.out.println("");
//        }
        float[] mario = observation.getMarioFloatPos();
        for(float num: mario) {
            System.out.print(num + " ");
        }
        System.out.println();
        /*
            Options for actions: Mario.KEY_LEFT
                                 Mario.KEY_RIGHT
                                 Mario.KEY_DOWN
                                 Mario.KEY_JUMP
                                 Mario.KEY_SPEED
         */
        action[Mario.KEY_SPEED] = false;
//        action[Mario.KEY_JUMP] =  observation.mayMarioJump() || !observation.isMarioOnGround();
        return action;
    }


    public Agent.AGENT_TYPE getType()
    {
        return Agent.AGENT_TYPE.AI;
    }

    public String getName() {        return name;    }

    public void setName(String Name) { this.name = Name;    }
}

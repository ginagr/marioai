package ch.idsia.stateAgent;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.TopLevelFSM;

import java.util.concurrent.TimeUnit;

public class StateMachineTestAgent implements Agent {

    private String name;
    private boolean[] action;
    TopLevelFSM TSM;
    private static int count;

    public StateMachineTestAgent()
    {
        setName("StateMachineTestAgent");
        reset();
        this.TSM = new TopLevelFSM();
        count = 0;
    }

    public void reset()
    {
        action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_SPEED] = true;
        this.TSM = new TopLevelFSM();
        count = 0;
        System.out.println("RESETTING");
    }

    public boolean[] getAction(Environment observation)
    {
        Helper helper = new Helper(observation);
//        System.out.println("above: " + helper.getQuestionMarkAbove() + " below: " + helper.getQuestionMarkBelow());

//        byte[][] enemies1 = observation.getLevelSceneObservation();
//
//        for (byte[] aLevelScene : enemies1) {
//            for (byte anALevelScene : aLevelScene) {
//                System.out.print(anALevelScene + "\t");
//            }
//            System.out.println("");
//        }

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
        double rand = Math.floor(Math.random() * 500) + 200;
        if(count > rand) {
            count = 0;
        }

        action = TSM.getAction(observation);
        TSM.update(observation);

        return action;
    }


    public Agent.AGENT_TYPE getType()
    {
        return Agent.AGENT_TYPE.AI;
    }

    public String getName() {        return name;    }

    public void setName(String Name) { this.name = Name;    }
}

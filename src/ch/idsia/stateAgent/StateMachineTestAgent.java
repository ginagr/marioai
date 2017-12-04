package ch.idsia.stateAgent;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.astar.AStarSimulator;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.TopLevelFSM;

public class StateMachineTestAgent implements Agent {

    private String name;
    private boolean[] action;
    TopLevelFSM TSM;

    public StateMachineTestAgent()
    {
        setName("StateMachineTestAgent");
        reset();
        this.TSM = new TopLevelFSM();
    }

    public void reset()
    {
        action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_SPEED] = true;
        this.TSM = new TopLevelFSM();
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

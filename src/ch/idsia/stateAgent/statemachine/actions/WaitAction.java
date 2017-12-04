package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

public class WaitAction implements IAction {

    public WaitAction(){};

    public boolean[] getAction(Environment observation){
        //System.out.println("in run action");
        boolean[] action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_RIGHT] = false;
        return action;
    }
}

package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

public class RunAction implements IAction {

    public RunAction(){};

    public boolean[] getAction(Environment observation){
        boolean[] action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_JUMP] = false;
        return action;
    }
}

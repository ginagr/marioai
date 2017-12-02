package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

public class JumpAction implements IAction {

    public JumpAction(){};

    public boolean[] getAction(Environment observation){
        boolean[] action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_JUMP] = true;
        //action[Mario.KEY_RIGHT] = false;
        return action;
    }
}

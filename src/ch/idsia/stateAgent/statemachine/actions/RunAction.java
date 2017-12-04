package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

//action to move to the right
public class RunAction implements IAction {

    public RunAction(){};

    public boolean[] getAction(Environment observation){
        boolean[] action = new boolean[Environment.numberOfButtons];

        //move to the right; dont jump
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_JUMP] = false;
        action[Mario.KEY_SPEED] = false;
        return action;
    }
}

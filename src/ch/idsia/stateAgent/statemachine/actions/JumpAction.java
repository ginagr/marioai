package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

//action to jump to the right
public class JumpAction implements IAction {

    public JumpAction(){};

    //fulfill IAction requirement
    public boolean[] getAction(Environment observation){
        boolean[] action = new boolean[Environment.numberOfButtons];

        //we jump and move to the right
        action[Mario.KEY_JUMP] = true;
        action[Mario.KEY_LEFT] = false;
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_SPEED] = true;

        return action;
    }
}

package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

//action to jump to the left
public class JumpLeftAction implements IAction {

    public JumpLeftAction(){};

    public boolean[] getAction(Environment observation){
        boolean[] action = new boolean[Environment.numberOfButtons];

        //we limit the amount we can jump to the left to precisely backtrack and jump
        //therefore, we do not move to the left when we jump
        action[Mario.KEY_JUMP] = true;
        action[Mario.KEY_RIGHT] = false;
        return action;
    }
}

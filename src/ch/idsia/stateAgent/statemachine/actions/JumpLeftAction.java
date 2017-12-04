package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

public class JumpLeftAction implements IAction {

    public JumpLeftAction(){};

    public boolean[] getAction(Environment observation){
        System.out.println("in jump left action");
        boolean[] action = new boolean[Environment.numberOfButtons];

        action[Mario.KEY_JUMP] = true;
        action[Mario.KEY_LEFT] = false;
        action[Mario.KEY_RIGHT] = false;
        return action;
    }
}

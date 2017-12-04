package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

public class RunLeftAction implements IAction {

    public boolean[] getAction(Environment observation){
//        System.out.println("Hello!");
        boolean[] action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_LEFT] = true;
        action[Mario.KEY_JUMP] = false;
        action[Mario.KEY_SPEED] = false;
        return action;
    }
}

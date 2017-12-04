package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

//action to not move
public class WaitAction implements IAction {

    public WaitAction(){};

    public boolean[] getAction(Environment observation){
        boolean[] action = new boolean[Environment.numberOfButtons];

        //dont move
        action[Mario.KEY_RIGHT] = false;
        action[Mario.KEY_SPEED] = false;
        return action;
    }
}

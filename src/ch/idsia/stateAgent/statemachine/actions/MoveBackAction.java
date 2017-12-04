package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

//action to run to the left
public class MoveBackAction implements IAction {

    @Override
    public boolean[] getAction(Environment observation) {
        boolean[] action = new boolean[Environment.numberOfButtons];

        //run to the left
        action[Mario.KEY_RIGHT] = false;
        action[Mario.KEY_LEFT] = true;

        return action;
    }
}

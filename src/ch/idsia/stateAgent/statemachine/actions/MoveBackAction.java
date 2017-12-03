package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

public class MoveBackAction implements IAction {

    @Override
    public boolean[] getAction(Environment observation) {
        boolean[] action = new boolean[Environment.numberOfButtons];

        action[Mario.KEY_RIGHT] = false;
        action[Mario.KEY_LEFT] = true;

        return action;
    }
}

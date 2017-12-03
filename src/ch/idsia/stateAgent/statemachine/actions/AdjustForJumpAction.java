package ch.idsia.stateAgent.statemachine.actions;

import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.IAction;

public class AdjustForJumpAction implements IAction {

    @Override
    public boolean[] getAction(Environment observation) {
        boolean[] action = new boolean[Environment.numberOfButtons];

        System.out.println("in adjust action");

        action[Mario.KEY_RIGHT] = true;

        return action;
    }

}

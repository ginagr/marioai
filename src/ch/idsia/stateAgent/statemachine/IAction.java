package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

public interface IAction {

    public boolean[] getAction(Environment observation);
}

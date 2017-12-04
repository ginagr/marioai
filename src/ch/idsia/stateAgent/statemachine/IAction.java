package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

//the skeleton of all actions in the state machine
public interface IAction {

    public boolean[] getAction(Environment observation);
}

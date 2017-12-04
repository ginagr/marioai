package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

//requirements to be a state machine; i.e. handle a system of states (or FSMS) and transitions
public interface IStateMachine {
    public void reset();
    public void update(Environment observation);
    public boolean[] getAction(Environment observation);
}

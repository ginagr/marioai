package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

public interface IStateMachine {
    public void reset();
    public void update(Environment observation);
    public boolean[] getAction(Environment observation);
}

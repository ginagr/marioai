package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

public interface ICondition {
    public boolean test(Environment observation);
}

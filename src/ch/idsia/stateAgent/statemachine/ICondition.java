package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

//skeleton for all the conditions in the state machine
public interface ICondition {
    public boolean test(Environment observation);
}

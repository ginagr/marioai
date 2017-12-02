package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

public class Transition {

    private IStateObject targetState;
    private ICondition condition;

    public Transition(IStateObject targetState, ICondition condition){
        this.targetState = targetState;
        this.condition = condition;
    }

    public boolean isTriggered(Environment observation){
        return condition.test(observation);
    };

    public IStateObject getTargetState(){
        return this.targetState;
    }

}

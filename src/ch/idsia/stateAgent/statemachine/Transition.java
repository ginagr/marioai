package ch.idsia.stateAgent.statemachine;

public class Transition {

    private IStateObject targetState;
    private ICondition condition;

    public boolean isTriggered(){
        return condition.test();
    };

    public IStateObject getTargetState(){
        return this.targetState;
    }

}

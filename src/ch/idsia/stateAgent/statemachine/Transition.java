package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

//a transition between two states
public class Transition {

    //holds a target state and a condition
    private IStateObject targetState;
    private ICondition condition;

    //constructor
    public Transition(IStateObject targetState, ICondition condition){
        this.targetState = targetState;
        this.condition = condition;
    }

    //check if the transition has been triggered
    public boolean isTriggered(Environment observation){
        return condition.test(observation);
    };

    //getter
    public IStateObject getTargetState(){
        return this.targetState;
    }

}

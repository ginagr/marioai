package ch.idsia.stateAgent.statemachine;

public class State implements IStateObject{

    IAction action;
    Transition[] transitions;


    public boolean[] getAction(){ return this.action.getAction(); }

    public Transition[] getTransitions(){
        return this.transitions;
    }





}

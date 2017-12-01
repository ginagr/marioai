package ch.idsia.stateAgent.statemachine;

public interface IStateObject {

    public Transition[] getTransitions();
    public boolean[] getAction();
}

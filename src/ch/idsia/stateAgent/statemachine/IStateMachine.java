package ch.idsia.stateAgent.statemachine;

public interface IStateMachine {
    public void reset();
    public void update();
    public boolean[] getAction();
}

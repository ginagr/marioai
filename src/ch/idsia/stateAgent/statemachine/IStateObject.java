package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;
import java.util.ArrayList;

public interface IStateObject {

    public void addTransition(Transition n);
    public ArrayList<Transition> getTransitions();
    public boolean[] getAction(Environment observation);

    public void printMyAction();
}

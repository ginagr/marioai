package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;
import java.util.ArrayList;

//requirements to be an object of a state machine
public interface IStateObject {

    //each object must have transitions
    public void addTransition(Transition n);
    public ArrayList<Transition> getTransitions();
    public boolean[] getAction(Environment observation);

    public void printMyAction();
}

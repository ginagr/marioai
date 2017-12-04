package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;
import java.util.ArrayList;

public class State implements IStateObject{

    IAction action;
    ArrayList<Transition> transitions;

    public State(IAction action, ArrayList<Transition> transitions){
        this.action = action;
        this.transitions = transitions;
    }

    public boolean[] getAction(Environment observation){ return this.action.getAction(observation); }

    public ArrayList<Transition> getTransitions(){
        return this.transitions;
    }

    public void addTransition(Transition n){
        transitions.add(n);
    }

    @Override
    public void printMyAction() {
//        System.out.println(this.action.getClass());
    }
}

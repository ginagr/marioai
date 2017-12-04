package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;
import java.util.ArrayList;

//a basic state in the state machine
public class State implements IStateObject{

    //holds the action for when it is the current state
    IAction action;
    //holds what it can transition to
    ArrayList<Transition> transitions;

    //constructor for the state class
    public State(IAction action, ArrayList<Transition> transitions){
        this.action = action;
        this.transitions = transitions;
    }

    //passes off getting the action to the IAction obejct
    public boolean[] getAction(Environment observation){ return this.action.getAction(observation); }

    //gets the transitions for the state
    public ArrayList<Transition> getTransitions(){
        return this.transitions;
    }

    //add new transitions to the transition list
    public void addTransition(Transition n){
        transitions.add(n);
    }

    @Override
    //for debugging purposes
    public void printMyAction() {
//        System.out.println(this.action.getClass());
    }
}

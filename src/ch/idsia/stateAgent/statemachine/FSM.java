package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

import java.util.ArrayList;

public class FSM implements IStateMachine, IStateObject{

    //the FSM keeps track of its current states; if its part of a larger hierarchical state machine,
    //it can also keep track of the state machines it can transitions to

    private IStateObject[] states;
    private IStateObject resetState;
    private IStateObject currentState;

    private ArrayList<Transition> transitions;

    //for the purposes of this project, wre only use a single layer state machine, so transitions is always null
    public FSM(IStateObject resetState, ArrayList<Transition> transitions){
        this.resetState = resetState;
        this.currentState = resetState;
        this.transitions = transitions;
    }

    //the state machine can always be reset
    public void reset(){
        this.currentState = resetState;
    }

    //the critical function that finds the first valid transition of the current state and moves to that next state
    public void update(Environment observation){
         Transition triggered = null;

         //loop through all transitions
         for(Transition transition: currentState.getTransitions()){
             //once we hit the first valid transition, we select it
             if(transition.isTriggered(observation)){
                 triggered = transition;
                 break;
             }
         }

        //make sure we found a valid transition
         if(triggered != null){
             IStateObject targetState = triggered.getTargetState();

             targetState.printMyAction();
             //switch to the state targeted by the transition as the current state
             this.currentState = targetState;
         }

    }

    @Override
    //adds transitions to the list of transitions
    public void addTransition(Transition n){
        transitions.add(n);
    }

    //gets all the transitions from this machine
    public ArrayList<Transition> getTransitions() {
        return this.transitions;
    }

    //passes off getting the action to the state selected in the FSM
    public boolean[] getAction(Environment observation){
        return currentState.getAction(observation);
    }

    //getters and setters
    public IStateObject getResetState(){
        return this.resetState;
    }

    public IStateObject getCurrentState(){
        return this.currentState;
    }

    //for debugging purposes
    public void printMyAction() {
        System.out.println("no");
    }

}

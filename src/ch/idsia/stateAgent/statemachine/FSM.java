package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;

import java.util.ArrayList;

public class FSM implements IStateMachine, IStateObject{

    private IStateObject[] states;
    private IStateObject resetState;
    private IStateObject currentState;

    private ArrayList<Transition> transitions;

    public FSM(IStateObject resetState, ArrayList<Transition> transitions){
        this.resetState = resetState;
        this.currentState = resetState;
        this.transitions = transitions;
    }

    public void reset(){
        this.currentState = resetState;
    }

    public void update(Environment observation){
         Transition triggered = null;

         for(Transition transition: currentState.getTransitions()){
             if(transition.isTriggered(observation)){
                 triggered = transition;
                 break;
             }
         }

         if(triggered != null){
             IStateObject targetState = triggered.getTargetState();

             targetState.printMyAction();

             this.currentState = targetState;
         }

    }

    @Override
    public void addTransition(Transition n){
        transitions.add(n);
    }

    public ArrayList<Transition> getTransitions() {
        return this.transitions;
    }

    public boolean[] getAction(Environment observation){
        return currentState.getAction(observation);
    }


    public IStateObject getResetState(){
        return this.resetState;
    }

    public IStateObject getCurrentState(){
        return this.currentState;
    }

    public void printMyAction() {
        System.out.println("no");
    }

}

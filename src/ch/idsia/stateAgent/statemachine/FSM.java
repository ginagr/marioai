package ch.idsia.stateAgent.statemachine;

public class FSM implements IStateMachine, IStateObject{

    private IStateObject[] states;
    private IStateObject resetState;
    private IStateObject currentState;

    private Transition[] transitions;

    public FSM(IStateObject resetState, Transition[] transitions){
        this.resetState = resetState;
        this.currentState = resetState;
        this.transitions = transitions;
    }

    public void reset(){
        this.currentState = resetState;
    }

    public void update(){
         Transition triggered = null;

         for(Transition transition: currentState.getTransitions()){
             if(transition.isTriggered()){
                 triggered = transition;
                 break;
             }
         }

         if(triggered != null){
             IStateObject targetState = triggered.getTargetState();

             this.currentState = targetState;
         }

    }

    @Override
    public Transition[] getTransitions() {
        return this.transitions;
    }

    public boolean[] getAction(){
        return currentState.getAction();
    }


    public IStateObject getResetState(){
        return this.resetState;
    }

    public IStateObject getCurrentState(){
        return this.currentState;
    }

}

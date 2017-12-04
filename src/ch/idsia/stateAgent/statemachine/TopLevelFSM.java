//this class gets handled by the agent
package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.actions.*;
import ch.idsia.stateAgent.statemachine.conditions.*;

import java.util.ArrayList;

//the object the agent uses to control the system
public class TopLevelFSM {

    FSM sm;

    public TopLevelFSM(){

        //declare all the new actions for the machine
        IAction run = new RunAction();
        IAction jump = new JumpAction();
        IAction moveBack = new MoveBackAction();
        IAction runLeft = new RunLeftAction();
        IAction jumpLeft = new JumpLeftAction();
        IAction wait = new WaitAction();
        //IAction adjustForJump = new AdjustForJumpAction();

        //declare all the new conditions for the machine
        ICondition jumpCond = new JumpCondition();
        ICondition runCond = new RunCondition();
        ICondition reverseCond = new StuckAgainstBoundaryCondition();
        ICondition jumpAgainCond = new FreedFromBoundaryCondition();
        ICondition lostBlockCond = new GetLostBlockCondition();
        ICondition noLostBlockCond = new NoLostBlockCondition();
        ICondition pirhannaCond = new PirhannaInPipeCondition();
        ICondition noPirhannaCond = new NoPirhannaInPipeCondition();
        //ICondition adjustForJumpCond = new TryJumpAgainCondition();

        //build the states for the state machine; the most central ones are the runState and jumpState
        State runState = new State(run, new ArrayList<Transition>() );
        State jumpState = new State(jump, new ArrayList<Transition>());
        State moveBackState = new State(moveBack, new ArrayList<Transition>());
        //State runLeftState = new State(runLeft, new ArrayList<Transition>());
        //State jumpLeftState = new State(jumpLeft, new ArrayList<Transition>());
        State waitState = new State(wait, new ArrayList<Transition>());
        //State adjustForJumpState = new State(adjustForJump, new ArrayList<Transition>());

        //transitions between the different states are declared; each transition holds a condition and target state
        Transition RunToJump = new Transition(jumpState, jumpCond);
        Transition JumpToRun = new Transition(runState, runCond);
        Transition JumpToMoveBack = new Transition(moveBackState, reverseCond);
        Transition MoveBackToJump = new Transition(jumpState, jumpAgainCond);
        //Transition RunLeftToJumpLeft = new Transition(jumpLeftState, jumpCond);
        //Transition JumpLeftToRunLeft = new Transition(runLeftState, runCond);
        //Transition RunToRunLeft = new Transition(runLeftState, lostBlockCond);
        //Transition RunLeftToRun = new Transition(runState, noLostBlockCond);
        Transition RunToWait = new Transition(waitState, pirhannaCond);
        Transition WaitToRun = new Transition(runState, noPirhannaCond);

        //transitions are added to their respective source states; this has to be done this way because
        //states have transitions and transitions have states

        //runState.addTransition(RunToRunLeft);
        runState.addTransition(RunToWait);
        runState.addTransition(RunToJump);

        jumpState.addTransition(JumpToMoveBack);
        jumpState.addTransition(JumpToRun);

        moveBackState.addTransition(MoveBackToJump);

        //runLeftState.addTransition(RunLeftToRun);
        //runLeftState.addTransition(RunLeftToJumpLeft);

        //jumpLeftState.addTransition(JumpLeftToRunLeft);

        waitState.addTransition(WaitToRun);

        //build the FSM from these initializations
        this.sm = new FSM(runState, null);
    }

    //pass off all responsibilities to the FSM element

    public void reset(){ sm.reset(); }

    public void update(Environment observation){ sm.update(observation); }

    public boolean[] getAction(Environment observation){
        return sm.getAction(observation);
    }

}

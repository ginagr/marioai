//this class gets handled by the agent
package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.actions.*;
import ch.idsia.stateAgent.statemachine.conditions.*;

import java.util.ArrayList;

public class TopLevelFSM {

    FSM sm;

    public TopLevelFSM(){

        IAction run = new RunAction();
        IAction jump = new JumpAction();
        IAction moveBack = new MoveBackAction();
        IAction runLeft = new RunLeftAction();
        IAction jumpLeft = new JumpLeftAction();
        IAction wait = new WaitAction();
        //IAction adjustForJump = new AdjustForJumpAction();

        ICondition jumpCond = new JumpCondition();
        ICondition runCond = new RunCondition();
        ICondition reverseCond = new StuckAgainstBoundaryCondition();
        ICondition jumpAgainCond = new FreedFromBoundaryCondition();
        ICondition lostBlockCond = new GetLostBlockCondition();
        ICondition noLostBlockCond = new NoLostBlockCondition();
        ICondition pirhannaCond = new PirhannaInPipeCondition();
        ICondition noPirhannaCond = new NoPirhannaInPipeCondition();
        //ICondition adjustForJumpCond = new TryJumpAgainCondition();

        State runState = new State(run, new ArrayList<Transition>() );
        State jumpState = new State(jump, new ArrayList<Transition>());
        State moveBackState = new State(moveBack, new ArrayList<Transition>());
        State runLeftState = new State(runLeft, new ArrayList<Transition>());
        State jumpLeftState = new State(jumpLeft, new ArrayList<Transition>());
        State waitState = new State(wait, new ArrayList<Transition>());
        //State adjustForJumpState = new State(adjustForJump, new ArrayList<Transition>());

        Transition RunToJump = new Transition(jumpState, jumpCond);
        Transition JumpToRun = new Transition(runState, runCond);
        Transition JumpToMoveBack = new Transition(moveBackState, reverseCond);
        Transition MoveBackToJump = new Transition(jumpState, jumpAgainCond);
        Transition RunLeftToJumpLeft = new Transition(jumpLeftState, jumpCond);
        Transition JumpLeftToRun = new Transition(runState, noLostBlockCond);
        Transition RunToRunLeft = new Transition(runLeftState, lostBlockCond);
        //Transition RunLeftToRun = new Transition(runState, noLostBlockCond);
        Transition RunToWait = new Transition(waitState, pirhannaCond);
        Transition WaitToRun = new Transition(runState, noPirhannaCond);

        //Transition AdjustForJumpToJump = new Transition(jumpState, adjustForJumpCond);

        runState.addTransition(RunToRunLeft);
        runState.addTransition(RunToWait);
        runState.addTransition(RunToJump);

        jumpState.addTransition(JumpToMoveBack);
        jumpState.addTransition(JumpToRun);

        moveBackState.addTransition(MoveBackToJump);

        //runLeftState.addTransition(RunLeftToRun);
        runLeftState.addTransition(RunLeftToJumpLeft);

        jumpLeftState.addTransition(JumpLeftToRun);

        waitState.addTransition(WaitToRun);


        //adjustForJumpState.addTransition(AdjustForJumpToJump);

        this.sm = new FSM(runState, null);
    }

    public void reset(){ sm.reset(); }

    public void update(Environment observation){ sm.update(observation); }

    public boolean[] getAction(Environment observation){
        return sm.getAction(observation);
    }


    //place functions to be used only by the top level here;
}

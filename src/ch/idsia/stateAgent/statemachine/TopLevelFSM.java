//this class gets handled by the agent
package ch.idsia.stateAgent.statemachine;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.statemachine.actions.AdjustForJumpAction;
import ch.idsia.stateAgent.statemachine.actions.JumpAction;
import ch.idsia.stateAgent.statemachine.actions.MoveBackAction;
import ch.idsia.stateAgent.statemachine.actions.RunAction;
import ch.idsia.stateAgent.statemachine.conditions.*;

import java.util.ArrayList;

public class TopLevelFSM {

    FSM sm;

    public TopLevelFSM(){

        IAction run = new RunAction();
        IAction jump = new JumpAction();
        IAction moveBack = new MoveBackAction();
        //IAction adjustForJump = new AdjustForJumpAction();

        ICondition jumpCond = new JumpCondition();
        ICondition runCond = new RunCondition();
        ICondition reverseCond = new StuckAgainstBoundaryCondition();
        ICondition jumpAgainCond = new FreedFromBoundaryCondition();
        //ICondition adjustForJumpCond = new TryJumpAgainCondition();

        State runState = new State(run, new ArrayList<Transition>() );
        State jumpState = new State(jump, new ArrayList<Transition>());
        State moveBackState = new State(moveBack, new ArrayList<Transition>());
        //State adjustForJumpState = new State(adjustForJump, new ArrayList<Transition>());

        Transition RunToJump = new Transition(jumpState, jumpCond);
        Transition JumpToRun = new Transition(runState, runCond);
        Transition JumpToMoveBack = new Transition(moveBackState, reverseCond);
        Transition MoveBackToJump = new Transition(jumpState, jumpAgainCond);
        //Transition AdjustForJumpToJump = new Transition(jumpState, adjustForJumpCond);

        runState.addTransition(RunToJump);

        jumpState.addTransition(JumpToMoveBack);
        jumpState.addTransition(JumpToRun);

        moveBackState.addTransition(MoveBackToJump);

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

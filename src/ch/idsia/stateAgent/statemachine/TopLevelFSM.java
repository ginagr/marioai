//this class gets handled by the agent
package ch.idsia.stateAgent.statemachine;

public class TopLevelFSM extends FSM {

    TopLevelFSM(IStateObject resetState){
        super(resetState,null);
    }

    //place functions to be used only by the top level here;
}

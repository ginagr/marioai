package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

//test if we are far enough from a ledge to try jumping again
public class FreedFromBoundaryCondition implements ICondition {

    public boolean test(Environment observation){
        Helper helper = new Helper(observation);

        //tests for if we are no longer stuck on a ledge
        return !helper.getIsMarioStuck();
    }
}

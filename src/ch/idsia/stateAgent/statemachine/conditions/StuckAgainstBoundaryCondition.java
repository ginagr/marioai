package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

//check if mario has gotten too close to the ledge to jump
public class StuckAgainstBoundaryCondition implements ICondition{

    public boolean test(Environment observation){
        Helper helper = new Helper(observation);

        //check if mario is stuck on a ledge
        return helper.getIsMarioStuck();

    }
}

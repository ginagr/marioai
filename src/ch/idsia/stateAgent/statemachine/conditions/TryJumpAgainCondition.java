package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

//checks if we can try jumping again
public class TryJumpAgainCondition implements ICondition {

    public boolean test(Environment observation){
        Helper helper = new Helper(observation);

        //checks that mario got far enough from the ledge to try jumping again
        return helper.getIsMarioFarEnough();
    }
}
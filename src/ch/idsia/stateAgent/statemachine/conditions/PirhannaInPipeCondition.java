package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

//checks if the pirhanna plant is out of its pipe
public class PirhannaInPipeCondition implements ICondition {

    public boolean test(Environment observation) {
        Helper helper = new Helper(observation);

        //checks for the presence of a pirhanna plant
        return helper.getCannonAhead();
    }

}

package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

//checks for if there the pihranna plant has receded into its pipe
public class NoPirhannaInPipeCondition implements ICondition {

    public boolean test(Environment observation) {
        Helper helper = new Helper(observation);

        //check if the pihranna plant is present
        return !helper.getCannonAhead();
    }

}

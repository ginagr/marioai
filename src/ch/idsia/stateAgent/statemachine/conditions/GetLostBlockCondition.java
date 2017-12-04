package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

//condition for if mario forgot to collect a block
public class GetLostBlockCondition implements ICondition {

    public boolean test(Environment observation) {
        Helper helper = new Helper(observation);

        //checks if there is an unopened question mark block behind mario
        return helper.getQuestionMarkBehind();
    }
}

package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

//checks if mario should be moving to the right
public class RunCondition implements ICondition {

    public boolean test(Environment observation){
        Helper helper = new Helper(observation);

        //check that mario should not be hitting any of the jump conditions
        return !helper.getShouldJump() && !helper.getQuestionMarkAbove() && !helper.getEnemyAheadOnLevel();
    }
}

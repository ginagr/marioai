package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

//checks if mario should jump
public class JumpCondition implements ICondition {

    public boolean test(Environment observation){
        Helper helper = new Helper(observation);

        //checks all the conditions where mario should jump
        return helper.getShouldJump() || /*helper.getRoadBlock()*/  helper.getQuestionMarkAbove() || helper.getEnemyAheadOnLevel();
    }
}

package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

public class JumpCondition implements ICondition {

    public boolean test(Environment observation){
        Helper helper = new Helper(observation);
        System.out.println("in jump condition: " + (helper.getShouldJump() || helper.getRoadBlock() ||
                helper.getQuestionMarkAbove() || helper.getEnemyAheadOnLevel()));
        return helper.getShouldJump() || helper.getRoadBlock() || helper.getQuestionMarkAbove() || helper.getEnemyAheadOnLevel();
    }
}

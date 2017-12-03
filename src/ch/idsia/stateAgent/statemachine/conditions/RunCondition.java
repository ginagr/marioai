package ch.idsia.stateAgent.statemachine.conditions;

import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.ICondition;

public class RunCondition implements ICondition {

    public boolean test(Environment observation){
        Helper helper = new Helper(observation);


        byte[][] levelScene = observation.getLevelSceneObservation();
        for(byte[] byterow : levelScene){
            for(byte bt : byterow){
                System.out.print(bt);
            }
            System.out.println();
        }

        //System.out.println("in run condition: " + (!helper.getShouldJump() && !helper.getRoadBlock()));
        return !helper.getShouldJump() && !helper.getRoadBlock();
    }
}

package ch.idsia.stateAgent;

import ch.idsia.ai.agents.Agent;
import ch.idsia.mario.engine.sprites.Mario;
import ch.idsia.mario.environments.Environment;
import ch.idsia.stateAgent.astar.AStarSimulator;
import ch.idsia.stateAgent.helpers.Helper;
import ch.idsia.stateAgent.statemachine.TopLevelFSM;

public class StateMachineTestAgent implements Agent {

    private String name;
    private boolean[] action;
    TopLevelFSM TSM;
    private AStarSimulator sim;
    private int tickCounter = 0;
    private float lastX = 0;
    private float lastY = 0;
    int errCount = 0;

    public StateMachineTestAgent()
    {
        setName("StateMachineTestAgent");
        reset();
        this.TSM = new TopLevelFSM();
    }

    public void reset()
    {
        action = new boolean[Environment.numberOfButtons];
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_SPEED] = true;
        sim = new AStarSimulator();
    }

    public boolean[] getAction(Environment observation) {
        long startTime = System.currentTimeMillis();
        tickCounter++;
        String s = "Fire";
        if (!sim.levelScene.mario.fire) {
            s = "Large";
        } else if (!sim.levelScene.mario.large) {
            s = "Small";
        }
        boolean[] ac = new boolean[5];
        ac[Mario.KEY_RIGHT] = true;
        ac[Mario.KEY_SPEED] = true;
        if (sim.levelScene.verbose > 0) {
            System.out.println("Next action! Tick " + tickCounter + " Simulated Mariosize: " + s);
        }
        byte[][] scene = observation.getLevelSceneObservationZ(0);
        float[] enemies = observation.getEnemiesFloatPos();
        if (sim.levelScene.verbose > 2) {
            System.out.println("Simulating using action: " + sim.printAction(action));
        }
        sim.advanceStep(action);

        if (sim.levelScene.verbose > 5) {
            System.out.println("Simulated sprites: ");
            sim.levelScene.dumpSprites();
        }
        float[] f = observation.getMarioFloatPos();
        if (sim.levelScene.verbose > 5) {
            System.out.println("Sim Mario Pos: "
                    + sim.levelScene.mario.x + " " + sim.levelScene.mario.y + " " +
                    " a: " + sim.levelScene.mario.xa + " " + sim.levelScene.mario.ya );
        }
        if (sim.levelScene.mario.x != f[0] || sim.levelScene.mario.y != f[1]) {
            if (f[0] == lastX && f[1] == lastY) {
                return ac;
            }
            //System.out.print("i");
            if (sim.levelScene.verbose > 0) {
                System.out.println("Inacurate!");
            }
            if (sim.levelScene.verbose > 0) {
                System.out.println("Real: "+f[0]+" "+f[1]
                        + " Est: "+ sim.levelScene.mario.x + " " + sim.levelScene.mario.y +
                        " Diff: " + (f[0]- sim.levelScene.mario.x) + " " + (f[1]-sim.levelScene.mario.y));
            }
            sim.levelScene.mario.x = f[0];
            sim.levelScene.mario.xa = (f[0] - lastX) *0.89f;
            if (Math.abs(sim.levelScene.mario.y - f[1]) > 0.1f) {
                sim.levelScene.mario.ya = (f[1] - lastY) * 0.85f;// + 3f;
            }

            sim.levelScene.mario.y = f[1];
            errCount++;
            //if (errCount > 1)
            //	errAgent.lastX++;
        }
        sim.setLevelPart(scene, enemies);

        lastX = f[0];
        lastY = f[1];

//        action = sim.optimise();

        if (sim.levelScene.verbose > 1) {
            System.out.println("Returning action: " + sim.printAction(action));
        }
        sim.timeBudget += 39 - (int)(System.currentTimeMillis() - startTime);
//        byte[][] enemies = observation.getLevelSceneObservationZ(0);
//
//        for (byte[] aLevelScene : enemies) {
//            for (byte anALevelScene : aLevelScene) {
//                System.out.print(anALevelScene + "\t");
//            }
//            System.out.println("");
//        }

//        System.out.println();
//        Helper helper = new Helper(observation);
//        System.out.println(helper.getShouldJump());
        action = TSM.getAction(observation);
        TSM.update(observation);

        return action;
    }


    public Agent.AGENT_TYPE getType()
    {
        return Agent.AGENT_TYPE.AI;
    }

    public String getName() {        return name;    }

    public void setName(String Name) { this.name = Name;    }
}

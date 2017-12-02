package ch.idsia.stateAgent.helpers;

import ch.idsia.mario.environments.Environment;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Helper {

    private Environment env;

    public Helper(Environment env){
        this.env = env;
    }

    /**
     * @return number of enemies in current scene
     */
    public int getNumberOfEnemies() {
        int count = 0;
        byte[][] levelScene = env.getEnemiesObservation();
        for (byte[] aLevelScene : levelScene) {
            for (byte anALevelScene : aLevelScene) {
                if(anALevelScene != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @return map of <Sprite byte, number of occurrences> in current scene
     */
    public Map<Byte, Integer> getTypeOfEnemies() {
        Map<Byte, Integer> sprites = new HashMap<>();
        byte[][] levelScene = env.getEnemiesObservation();
        for (byte[] aLevelScene : levelScene) {
            for (byte anALevelScene : aLevelScene) {
                if(anALevelScene != 0) {
                    sprites.merge(anALevelScene, 1, Integer::sum);
                }
            }
        }
        return sprites;
//        Map<Byte, Integer> map = helper.getTypeOfEnemies();
//        for(Map.Entry m:map.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue());
//        }
    }

    /**
     * @return number of coins in current scene
     */
    public int getNumberOfCoins() {
        int count = 0;
        byte[][] levelScene = env.getLevelSceneObservationZ(0);
        for (byte[] aLevelScene : levelScene) {
            for (byte anALevelScene : aLevelScene) {
                if(anALevelScene == 34) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @return number of question marks in current scene
     */
    public int getQuestionMarkBlock() {
        int count = 0;
        byte[][] levelScene = env.getLevelSceneObservation();
        for (byte[] aLevelScene : levelScene) {
            for (byte anALevelScene : aLevelScene) {
                if(anALevelScene == 21) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean getAboveQuestionBlock() {
        byte[][] levelScene = env.getLevelSceneObservation();
        boolean above = false;
        env.getMarioFloatPos();

        return above;
    }

    /**
     * @return Point array of coordinates that are question mark blocks in current scene
     */
    public Point[] getQuestionMarkCoordinates() {
        Point[] coor = new Point[getQuestionMarkBlock()];
        int count = 0;
        byte[][] levelScene = env.getLevelSceneObservation();
        for (int i = 0; i < levelScene.length; i++) {
            for (int j = 0; j < levelScene[i].length; j++) {
                if(levelScene[i][j] == 21) {
                    Point temp = new Point(i, j);
                    coor[count] = temp;
                    count++;
                }
            }
        }
        return coor;
    }

//    public void getMarioSize() {
//        String s = "Fire";
//        if (!sim.levelScene.mario.fire)
//            s = "Large";
//        if (!sim.levelScene.mario.large)
//            s = "Small";
//        if (sim.levelScene.verbose > 0) System.out.println("Next action! Tick " + tickCounter + " Simulated Mariosize: " + s);
//
//    }

    /**
     * @return true if close to a gap, false if not
     */
    public boolean getGapDanger() {
        byte[][] levelScene = env.getLevelSceneObservation();
        for (int x = 9; x < 13; x++) {
            boolean f = true;
            for(int y = 12; y < 22; y++) {
                if  (levelScene[y][x] != 0) {
                    f = false;
                }
            }
            if (f && levelScene[12][11] != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if road block ahead, false if not
     */
    public boolean getRoadBlock() {
        byte[][] levelScene = env.getLevelSceneObservation();
        for(int x = 12; x < 15; x++) {
            for(int y = 0; y < 22; y++){
                if(levelScene[y][x] == 20) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean getShouldJump() {
        byte[][] levelScene = env.getLevelSceneObservation();
        int top = 0;
        for(int y = 0; y < 22; y++) {
            if(levelScene[y][11] == -10) {
                top = y;
                y = 22;
            }
        }
        for(int x = 12; x < 15; x++) {
            for(int y = 0; y < 22; y++){
                if(levelScene[y][x] == -10) {
                    if(top > y) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

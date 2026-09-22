package empty;

import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class RobotPlayer {
    public static void run(RobotController rc) throws GameActionException {
        while (true) {
            Clock.yield();
        }
    }
}

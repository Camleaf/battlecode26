package mk1;

import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.MapInfo;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.UnitType;
import battlecode.common.GameConstants;

import mk1.Navigate;

public class RobotPlayer {
    

    public static void run(RobotController rc) throws GameActionException {
        
        int turn = 0;
        while (true) {
            turn++;
        

            if (rc.getType() == UnitType.RAT_KING) {
                King.run(rc);
                if (turn==1) if (rc.canBuildRat(rc.getLocation().translate(2,0))) {
                    rc.buildRat(rc.getLocation().translate(2,0));
                }
            } else {
                Rat.run(rc);
            }



            Clock.yield();
        }
    }


    class King {
        static void run(RobotController rc) throws GameActionException{
        }
    }



    class Rat {
        static void run(RobotController rc) throws GameActionException{
            Navigate.greedyNav(rc, new MapLocation(0,20));
        }
    }
}

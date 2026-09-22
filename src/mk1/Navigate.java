package mk1;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

public class Navigate {
    
    public static void greedyNav(RobotController rc, MapLocation target) throws GameActionException{
        Direction greedyDir = rc.getLocation().directionTo(target);
        MapLocation adjLoc = rc.adjacentLocation(greedyDir);
        
        if (!rc.sensePassability(adjLoc) || rc.senseRobotAtLocation(adjLoc)!=null){
            if (rc.canRemoveDirt(adjLoc)) {
                rc.removeDirt(adjLoc);
            };
            
            

            return;
            // need solution to search surrounding corners
        }

        if (rc.canTurn()){
            rc.turn(greedyDir);
        }

        if (rc.canMove(greedyDir)) rc.move(greedyDir);

    }
    
}


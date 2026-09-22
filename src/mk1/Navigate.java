package mk1;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

public class Navigate {
    

    static Direction lastDirection;

    public static void bugNav(RobotController rc, MapLocation target) throws GameActionException{
        
        if (lastDirection == null) {
            lastDirection = rc.getDirection();
        }

        Direction toTarget = rc.getLocation().directionTo(target);


        if (!rc.canMove(toTarget)) {
            toTarget = lastDirection; 
            toTarget = toTarget.rotateLeft();
            
            if (rc.canTurn(toTarget)) rc.turn(toTarget);
            if (rc.canMove(toTarget)) rc.move(toTarget);

        } else {
            if (rc.canTurn(toTarget)) {
                rc.turn(toTarget);
            }
            rc.move(toTarget);
        }
        lastDirection = toTarget;
    } 
}


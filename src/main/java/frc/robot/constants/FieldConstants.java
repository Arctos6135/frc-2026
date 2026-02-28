package frc.robot.constants;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

//These are the field constants I think we will need
public class FieldConstands {
    //All mesurments are from the game manual and are in metres 
    public static final double FIELD_WIDTH = 8.07; //Y distance 
    public static final double FIELD_LENGTH = 16.54; //X distance
    public static final double FIELD_WIDTH_MIDPOINT = 8.07/2.0; //Y bisector
    public static final double FIELD_LENGTH_CENTRELINE = 16.54/2.0; //x bisector
    public static final double ROBOT_START_LINE_TO_ALLINENCE_WALL = 4.03;
    public static final double HUB_HALF_SIZE = 1.19;
    public static final double ROBOT_START_LINE_TO_CENTRELINE = FIELD_LENGTH_CENTRELINE - ROBOT_START_LINE_TO_ALLINENCE_WALL;
    
    public static final double RED_START_LINE = FIELD_LENGTH_CENTRELINE + ROBOT_START_LINE_TO_CENTRELINE;
    public static final double BLUE_START_LINE = FIELD_LENGTH_CENTRELINE - ROBOT_START_LINE_TO_CENTRELINE;

    public static final Translation2d RED_HUB_CENTRE = new Translation2d(RED_START_LINE - HUB_HALF_SIZE, FIELD_WIDTH_MIDPOINT);
    public static final Translation2d BLUE_HUB_CENTRE = new Translation2d(BLUE_START_LINE + HUB_HALF_SIZE, FIELD_WIDTH_MIDPOINT);
}
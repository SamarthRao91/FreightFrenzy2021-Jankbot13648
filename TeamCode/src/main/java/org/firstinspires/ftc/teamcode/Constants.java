package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@Config
public class Constants {
    // Drive Base Motor Names
    public static final String FRONT_LEFT_DRIVE_NAME = "fl";
    public static final String FRONT_RIGHT_DRIVE_NAME = "fr";
    public static final String REAR_LEFT_DRIVE_NAME = "rl";
    public static final String REAR_RIGHT_DRIVE_NAME = "rr";

    //Subsysystem
    public static final String INTAKE_MOTOR_NAME = "im";
    public static final String CLAW_SERVO_NAME ="cs";
    public static final String EXTENDER_SERVO_NAME ="es";
    public static final String TURRET_SERVO_NAME ="ts";
    public static final String QUACK_SPINNER_NAME = "qs";
    public static final String ELEVATOR_MOTOR_NAME = "em";

    public static final String CAPSTONE_DETECTION_CAMERA_NAME_LEFT = "Webcam 1";
    public static final String CAPSTONE_DETECTION_CAMERA_NAME_RIGHT = "Webcam 2";
    public static int CAMERA_RESOLUTION_WIDTH = 1280;
    public static int CAMERA_RESOLUTION_HEIGHT = 720;
    //elevator pid stuff

    //turret constants
    public static double turret_position; //stores angle of turret
    public static double turret_right_safepos = 0.11; //storage angle to not hit capstone
    public static double turret_left_safepos =0.9; //stores angle to not hit duck spinner
    public static double turret_zeropos = 0.495;
    //elevator constants
    public static double elevator_postion; //stores current position in inches
    public static double elevator_minpos = .25; //minimum position of elevator to stop movement @Todo - this one needs to be checked
    public static double elevator_maxpos = 26.5; //maximum position of elevator
    public static double elevator_minimumsafepos = 4.5; //position in which turret clears the bottom if extender is retracted
    public static double elevator_safepos = 14; //position in which everything clears duck spinner if extender is extended
    public static double elevator_tolerance = 1;
    public static double elevator_pcoeff = 1;
    public static double elevator_icoeff = 0;
    public static double elevator_dcoeff = 0;

    //extender constants
    public static double ex_position; //stores current position of extender in servo rotaton
    public static double ex_maxpos =0; //maximum rotation of extender
    public static double ex_minpos=1; //minimum rotation of extender
    public static double ex_capstoneextension; //stores position of capstone

    public static double extenderPosition1;
    public static double extenderPosition2;

    //claw constants
    public static double claw_open=0.47;
    public static double claw_close=0.35;
    public static double openClawFully =0.7;
}
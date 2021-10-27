package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
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
    public static final String QUACK_SPINNER_NAME = "qs";
    public static final String ELEVATOR_MOTOR_NAME = "em";

    public static final String CAPSTONE_DETECTION_CAMERA_NAME_LEFT = "Webcam 1";
    public static final String CAPSTONE_DETECTION_CAMERA_NAME_RIGHT = "Webcam 2";
    public static int CAMERA_RESOLUTION_WIDTH = 1280;
    public static int CAMERA_RESOLUTION_HEIGHT = 720;

}
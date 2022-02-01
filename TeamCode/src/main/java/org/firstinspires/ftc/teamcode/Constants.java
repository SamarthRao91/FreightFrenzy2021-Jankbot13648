package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;

public class Constants {

    @Config
    public static class DriveBase {
        public static String FRONT_LEFT_DRIVE_MOTOR_NAME = "fl";
        public static String FRONT_RIGHT_DRIVE_MOTOR_NAME = "fr";
        public static String REAR_LEFT_DRIVE_MOTOR_NAME = "rl";
        public static String REAR_RIGHT_DRIVE_MOTOR_NAME = "rr";
        public static String LEFT_DISTANCE_SENSOR_NAME = "ds2";
        public static String RIGHT_DISTANCE_SENSOR_NAME = "ds1";
    }

    @Config
    public static class Intake {
        public static String INTAKE_MOTOR_NAME = "im";
        public static String DISTANCE_SENSOR_NAME = "ds";
    }

    @Config
    public static class Elevator {
        public static String ELEVATOR_MOTOR_NAME = "em";

        // Minimum position of elevator to stop movement
        // TODO: Check Value
        public static int MINIMUM_POSITION = 0;

        // Maximum position of elevator
        public static int MAXIMUM_POSITION = 2500;

        // Position in which turret clears the bottom if extender is retracted // min safe pos
        public static int SAFE_TURRET_POSITION = 550;

        // Position in which everything clears duck spinner if extender is extended
        public static int SAFE_EXTENDER_POSITION = 1224;

        public static String LIMIT_SWITCH_NAME = "ls";

        public static double ELEVATOR_P_COEFF = 0.06;
        public static double ELEVATOR_I_COEFF = 0.025;
        public static double ELEVATOR_D_COEFF = 0.001;
        public static double ELEVATOR_F_COEFF = 0.001;

        public static double ELEVATOR_I_COEFF_MIN = -20;
        public static double ELEVATOR_I_COEFF_MAX = 20;

        public static double ELEVATOR_PID_TOLERANCE = 10;
    }

    @Config
    public static class Manipulator {

        @Config
        public static class Turret {
            public static String TURRET_MOTOR_NAME = "tm";

            public static int RIGHT_MAXIMUM_POSITION = 880;

            public static int LEFT_MAXIMUM_POSITION = -880;

            public static int ZERO_POSITION = 0;

            public static double TURRET_P_COEFF = 0.02;
            public static double TURRET_I_COEFF = 0.005;
            public static double TURRET_D_COEFF = 0.0003;
            public static double TURRET_F_COEFF = 0.0;

            public static double TURRET_I_COEFF_MIN = -25;
            public static double TURRET_I_COEFF_MAX = 25;

            public static double TURRET_PID_TOLERANCE = 10;
            public static double POT_ZERO_VALUE = 1.11;
        }

        @Config
        public static class Arm {
            public static String ARM1_NAME = "as1";
            public static String ARM2_NAME = "as2";

            public static double ARM1_UPPER_BOUND = 0.1;
            public static double ARM1_LOWER_BOUND = 1.0;
        }

        @Config
        public static class Claw {
            public static String CLAW_SERVO_NAME = "cs";
            public static String PUSHER_SERVO = "ps";
            public static String DISTANCE_SENSOR_NAME = "sdc";

            public static double OPEN_POSITION = 0.18;
            public static double CLOSE_POSITION = 0.05;
            public static double CAPSTONE_OPEN_FULLY = 0.7;
        }
        @Config
        public static class Pusher {
            public static String PUSHER_NAME = "ps";

            public static double PUSHER_UP_POS = .2;
            public static double PUSHER_PREP_POS = 0.88;
            public static double PUSHER_PUSH_POS = 1;
        }
    }

    @Config
    public static class DuckSpinner {
        public static String DUCK_SPINNER_MOTOR_NAME = "qs";
        public static String RED_WALL_SERVO = "rws";

        public static double RED_WALL_UP = 0;
        public static double RED_WALL_DOWN = 1;
    }

    @Config
    public static class Vision {
        public static String CAPSTONE_DETECTION_CAMERA_NAME_LEFT = "Webcam 1";
        public static String CAPSTONE_DETECTION_CAMERA_NAME_RIGHT = "Webcam 2";

        public static int CAMERA_RESOLUTION_WIDTH = 1280;
        public static int CAMERA_RESOLUTION_HEIGHT = 720;
    }

    @Config
    public static  class CapstoneGrabber {
        public static String CAPSTONE_GRABBER_NAME = "cas";

        public static double[] CAPSTONE_GRABBER_POSITIONS = {0.5, 0.97, 0.67, 0.77};
    }
}
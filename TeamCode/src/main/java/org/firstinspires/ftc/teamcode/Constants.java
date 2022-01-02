package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;

@Config
public class Constants {

    @Config
    public static final class DriveBase {
        public static final String FRONT_LEFT_DRIVE_MOTOR_NAME = "fl";
        public static final String FRONT_RIGHT_DRIVE_MOTOR_NAME = "fr";
        public static final String REAR_LEFT_DRIVE_MOTOR_NAME = "rl";
        public static final String REAR_RIGHT_DRIVE_MOTOR_NAME = "rr";
        public static final String LEFT_DISTANCE_SENSOR_NAME = "ds2";
        public static final String RIGHT_DISTANCE_SENSOR_NAME = "ds1";
    }

    @Config
    public static final class Intake {
        public static final String INTAKE_MOTOR_NAME = "im";
        public static final String DISTANCE_SENSOR_NAME = "ds";
    }

    @Config
    public static final class Elevator {
        public static final String ELEVATOR_MOTOR_NAME = "em";

        // Minimum position of elevator to stop movement
        // TODO: Check Value
        public static final int MINIMUM_POSITION = 25;

        // Maximum position of elevator
        public static final int MAXIMUM_POSITION = 2500;

        // Position in which turret clears the bottom if extender is retracted // min safe pos
        public static final int SAFE_TURRET_POSITION = 550;

        // Position in which everything clears duck spinner if extender is extended
        public static final int SAFE_EXTENDER_POSITION = 1224;

        public static final String LIMIT_SWITCH_NAME = "ls";
    }

    @Config
    public static final class Manipulator {

        @Config
        public static final class Turret {
            public static final String TURRET_MOTOR_NAME = "tm";

            public static final int RIGHT_MAXIMUM_POSITION = 880;

            public static final int LEFT_MAXIMUM_POSITION = -880;

            public static final int ZERO_POSITION = 0;
        }

        @Config
        public static final class Arm {
            public static final String ARM1_NAME = "as1";
            public static final String ARM2_NAME = "as2";

            public static final double ARM1_UPPER_BOUND = 0.1;
            public static final double ARM1_LOWER_BOUND = .99;
        }

        @Config
        public static final class Claw {
            public static final String CLAW_SERVO_NAME = "cs";
            public static final String PUSHER_SERVO = "ps";
            public static final String DISTANCE_SENSOR_NAME = "sdc";

            public static double OPEN_POSITION = 0.20;
            public static double CLOSE_POSITION = 0.05;
            public static final double CAPSTONE_OPEN_FULLY = 0.7;
        }
        @Config
        public static final class Pusher {
            public static final String PUSHER_NAME = "ps";

            public static final double PUSHER_UP_POS = 0.8;
            public static final double PUSHER_PREP_POS = 0.15;
            public static final double PUSHER_PUSH_POS = 0;
        }
    }

    @Config
    public static final class DuckSpinner {
        public static final String DUCK_SPINNER_MOTOR_NAME = "qs";
        public static final String RED_WALL_SERVO = "rws";

        public static final double RED_WALL_UP = 0;
        public static final double RED_WALL_DOWN = 1;
    }

    @Config
    public static final class Vision {
        public static final String CAPSTONE_DETECTION_CAMERA_NAME_LEFT = "Webcam 1";
        public static final String CAPSTONE_DETECTION_CAMERA_NAME_RIGHT = "Webcam 2";

        public static final int CAMERA_RESOLUTION_WIDTH = 1280;
        public static final int CAMERA_RESOLUTION_HEIGHT = 720;
    }

    @Config
    public static  class CapstoneGrabber {
        public static final String CAPSTONE_GRABBER_NAME = "cas";

        public static double[] CAPSTONE_GRABBER_POSITIONS = {0.5, 0.97, 0.67, 0.77};
    }
}
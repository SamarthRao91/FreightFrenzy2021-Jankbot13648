package org.firstinspires.ftc.teamcode;

public class CurrentState {

    public static class ElevatorState
    {
        public static boolean isRunning = false;

        public static void resetState()
        {
            isRunning = false;
        }
    }

    public static class ManipulatorState
    {
        public static double currentTurretPos = Constants.Manipulator.Turret.ZERO_POSITION;
        public static double currentExtenderPos = Constants.Manipulator.Extender.MIN_POS;
        public static boolean sleeping = false;
        public static boolean resetting = false;

        public static void resetState()
        {
            currentTurretPos = Constants.Manipulator.Turret.ZERO_POSITION;
            currentExtenderPos = Constants.Manipulator.Extender.MIN_POS;
            sleeping = false;
            resetting = false;
        }
    }

    public static void resetState() {
        ElevatorState.resetState();
        ManipulatorState.resetState();
    }
}

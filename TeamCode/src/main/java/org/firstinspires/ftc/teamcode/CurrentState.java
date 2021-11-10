package org.firstinspires.ftc.teamcode;

public class CurrentState {
    public static class ManipulatorState
    {
        public static double currentTurretPos = Constants.Manipulator.Turret.ZERO_POSITION;
        public static double currentExtenderPos = Constants.Manipulator.Extender.MIN_POS;
        public static boolean sleeping = false;

        public static void resetState()
        {
            currentTurretPos = Constants.Manipulator.Turret.ZERO_POSITION;
            currentExtenderPos = Constants.Manipulator.Extender.MIN_POS;
            sleeping = false;
        }
    }

    public static void resetState() {
        ManipulatorState.resetState();
    }
}

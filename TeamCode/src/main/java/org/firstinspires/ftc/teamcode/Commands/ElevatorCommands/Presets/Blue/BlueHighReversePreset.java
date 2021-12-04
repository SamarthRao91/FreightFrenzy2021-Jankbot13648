package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Blue;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class BlueHighReversePreset extends SuperStructureToPosition {
    public BlueHighReversePreset(Elevator elevator, Manipulator manipulator) {
        super(
                elevator,
                manipulator,
                1400 + 450,
                1,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS,
                Constants.Manipulator.Claw.CLOSE_POSITION
        );
    }
}

package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Blue;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class BlueAutoReverseMiddlePreset extends SuperStructureToPosition {
    public BlueAutoReverseMiddlePreset(Elevator elevator, Manipulator manipulator) {
        super(
                elevator,
                manipulator,
                975,
                1,
                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS+0.11,
                Constants.Manipulator.Claw.CLOSE_POSITION
        );
    }
}

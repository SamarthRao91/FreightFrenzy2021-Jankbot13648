package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Blue;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class BlueAutoMiddlePreset extends SuperStructureToPosition {
    public BlueAutoMiddlePreset(Elevator elevator, Manipulator manipulator) {
        super(
                elevator,
                manipulator,
                925,
                1,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS + .18,
                Constants.Manipulator.Claw.CLOSE_POSITION
        );
    }
}

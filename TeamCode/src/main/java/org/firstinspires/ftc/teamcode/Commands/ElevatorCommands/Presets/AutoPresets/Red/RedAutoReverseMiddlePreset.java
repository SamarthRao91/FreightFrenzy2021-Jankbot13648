package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedAutoReverseMiddlePreset extends SuperStructureToPosition {
    public RedAutoReverseMiddlePreset(Elevator elevator, Manipulator manipulator) {
        super(
                elevator,
                manipulator,
                975,
                1,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS + .11,
                Constants.Manipulator.Claw.CLOSE_POSITION
        );
    }
}

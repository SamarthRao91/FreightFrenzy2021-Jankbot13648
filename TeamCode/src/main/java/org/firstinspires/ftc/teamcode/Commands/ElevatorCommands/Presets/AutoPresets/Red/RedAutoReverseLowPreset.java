package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedAutoReverseLowPreset extends SuperStructureToPosition {
    public RedAutoReverseLowPreset(Elevator elevator, Manipulator manipulator) {
        super(
                elevator,
                manipulator,
                445,
                1,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS,
                Constants.Manipulator.Claw.CLOSE_POSITION
        );
    }
}

package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedAutoLowPreset extends SuperStructureToPosition {
    public RedAutoLowPreset(Elevator elevator, Manipulator manipulator) {
        super(
                elevator,
                manipulator,
                445,
                1,
                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS + 0.18,
                Constants.Manipulator.Claw.CLOSE_POSITION
        );
    }
}

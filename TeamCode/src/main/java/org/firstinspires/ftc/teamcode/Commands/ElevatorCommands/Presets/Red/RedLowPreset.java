package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedLowPreset extends SuperStructureToPosition {
    public RedLowPreset(Elevator elevator, Manipulator manipulator) {
        super(
                elevator,
                manipulator,
                Constants.Elevator.SAFE_TURRET_POSITION + 200,
                1,
                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS + 0.2,
                Constants.Manipulator.Claw.CLOSE_POSITION
        );
    }
}

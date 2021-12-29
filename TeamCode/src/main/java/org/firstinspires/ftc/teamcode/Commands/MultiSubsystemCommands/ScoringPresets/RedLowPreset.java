package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedLowPreset extends ParallelCommandGroup {

    public RedLowPreset(Elevator elevator, Manipulator manipulator) {
        addCommands(
                new ElevatorToPosition(elevator, 50, 1),
                new InstantCommand(() -> manipulator.setArm(0.25)),
                new TurretToPosition(manipulator, Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION + 125, .66)

        );

        addRequirements(elevator, manipulator);
    }
}

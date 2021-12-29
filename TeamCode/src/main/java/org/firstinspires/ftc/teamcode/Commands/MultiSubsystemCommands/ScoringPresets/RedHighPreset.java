package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedHighPreset extends ParallelCommandGroup {

    public RedHighPreset(Elevator elevator, Manipulator manipulator) {
        addCommands(
                new ElevatorToPosition(elevator, 1000, 1),
                new InstantCommand(() -> manipulator.setArm(0.55)),
                new TurretToPosition(manipulator, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION - 250, .33),
                new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_PREP_POS))

        );

        addRequirements(elevator, manipulator);
    }
}

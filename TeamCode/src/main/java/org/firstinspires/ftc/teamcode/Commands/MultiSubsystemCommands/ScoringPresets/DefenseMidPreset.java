package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class DefenseMidPreset extends SequentialCommandGroup {

    public DefenseMidPreset(Elevator elevator, Manipulator manipulator) {

        addCommands(
                new ParallelCommandGroup(
                        new ElevatorToPosition(elevator, 275, 1),
                        new InstantCommand(() -> manipulator.setArm(0.32)),
                        new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_PREP_POS))

                ),
                new TurretToPosition(manipulator, 0, 1)

        );

        addRequirements(elevator, manipulator);
    }
}

package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class DefenseHighPreset extends SequentialCommandGroup {

    public DefenseHighPreset(Elevator elevator, Manipulator manipulator) {

        addCommands(
                new ParallelCommandGroup(
                        new ElevatorToPosition(elevator, 300, 1),
                        new InstantCommand(() -> manipulator.setArm(0.50)),
                        new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_PREP_POS))

                ),
                new TurretToPosition(manipulator, 0, 1)

        );

        addRequirements(elevator, manipulator);
    }
}

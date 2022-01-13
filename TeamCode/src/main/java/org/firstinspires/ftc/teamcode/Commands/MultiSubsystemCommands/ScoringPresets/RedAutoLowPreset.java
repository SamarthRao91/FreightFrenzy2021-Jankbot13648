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

public class RedAutoLowPreset extends SequentialCommandGroup { //only to be used in auto

    public RedAutoLowPreset(Elevator elevator, Manipulator manipulator) {

            addCommands(
                    new ParallelCommandGroup(
                            new InstantCommand(() -> manipulator.setArm(0.18)),
                            new TurretToPosition(manipulator, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION - 50, 1),
                            new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_PREP_POS)),
                            new ElevatorToPosition(elevator, 150, 1)
                    ),
                    new WaitCommand(375),
                    new ElevatorToPosition(elevator, 825, 1)
            );

        addRequirements(elevator, manipulator);
    }
}

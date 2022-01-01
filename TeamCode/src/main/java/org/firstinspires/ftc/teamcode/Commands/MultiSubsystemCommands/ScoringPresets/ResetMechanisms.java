package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class ResetMechanisms extends SequentialCommandGroup {
    public ResetMechanisms(Elevator elevator, Manipulator manipulator) {
        addCommands(
                new ElevatorToPosition(elevator, 0, 1).alongWith(new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - .2))).alongWith(new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_UP_POS))).alongWith(new InstantCommand(() -> manipulator.closeClaw())),//slows turret if slides are far away
                new TurretToPosition(manipulator, 0, 1),
                new WaitCommand(500),
                new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND)),
                new WaitCommand(250),
                new InstantCommand(() -> manipulator.openClaw())
        );

        manipulator.manualPickUp = false;

        addRequirements(elevator, manipulator);
    }
}



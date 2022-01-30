package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.PushGamepiece;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class PushAndReset extends SequentialCommandGroup{
    public PushAndReset(Elevator elevator, Manipulator manipulator) {
        addCommands(
                new PushGamepiece(manipulator),
                new WaitCommand(250),
                new ElevatorToPosition(elevator, 0, 1).alongWith(new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - .47))).alongWith(new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_UP_POS))).alongWith(new InstantCommand(() -> manipulator.closeClaw())).alongWith(new WaitCommand(375)),//slows turret if slides are far away
                new TurretToPosition(manipulator, 0, .75),
                new WaitCommand(250),
                new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND)),
                new WaitCommand(375),
                new InstantCommand(() -> manipulator.openClaw())
        );

        manipulator.manualPickUp = false;

        addRequirements(elevator, manipulator);
    }
}

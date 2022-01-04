package org.firstinspires.ftc.teamcode.Commands.AutoCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.PushGamepiece;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class PushAndResetAndIntake extends SequentialCommandGroup {
    public PushAndResetAndIntake(Elevator elevator, Manipulator manipulator, Intake intake) {
        addCommands(
                new PushGamepiece(manipulator).alongWith(new InstantCommand(() -> intake.setIntake(.2))),
                new WaitCommand(10),
                new ElevatorToPosition(elevator, 200, 1).alongWith(new InstantCommand(() -> manipulator.setArm(.65))),//slows turret if slides are far away
                new TurretToPosition(manipulator, 0, 1).alongWith(new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_UP_POS))).alongWith(new InstantCommand(() -> manipulator.closeClaw())).alongWith(new ElevatorToPosition(elevator, 0, 1)).alongWith(new InstantCommand(() -> intake.setIntake(-.2))),
                new WaitCommand(1),
                new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND)),
                new WaitCommand(250),
                new InstantCommand(() -> manipulator.openClaw()),
                new InstantCommand(() -> intake.setIntake(1)),
                new WaitCommand(500)


        );
    }
}

package org.firstinspires.ftc.teamcode.Commands.AutoCommands;

import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.FixTurret;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManipulatorDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.PushGamepiece;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretResetWithPot;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class PushAndResetAndIntakeRed extends SequentialCommandGroup {
    public PushAndResetAndIntakeRed(Elevator elevator, Manipulator manipulator, Intake intake) {
        addCommands(
                new PushGamepiece(manipulator).alongWith(new InstantCommand(() -> intake.setIntake(.2))),
                new WaitCommand(10),
                new ElevatorToPosition(elevator, 200, 1).alongWith(new InstantCommand(() -> manipulator.setArm(.5))).alongWith(new TurretToPosition(manipulator, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION - 400, .5)),//slows turret if slides are far away
                new TurretToPosition(manipulator, 0, 1).alongWith(new InstantCommand(() -> manipulator.setArm(.8))).alongWith(new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_UP_POS))).alongWith(new InstantCommand(() -> manipulator.closeClaw())).alongWith(new ElevatorToPosition(elevator, -2, 1)).alongWith(new InstantCommand(() -> intake.setIntake(-.2))),
                new WaitCommand(250),
                new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND)),
                new WaitCommand(250),
                new InstantCommand(() -> manipulator.openClaw()),
                new InstantCommand(() -> manipulator.setTurretError()),
                new ConditionalCommand(new FixTurret(manipulator), new WaitCommand(1), () -> (manipulator.getTurretError() > .1)
                ),
                new InstantCommand(() -> intake.setIntake(1)),
                new WaitCommand(750)


        );
    }
}

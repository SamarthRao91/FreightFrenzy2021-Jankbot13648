package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Blue;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class PickupAndHighPresetBlue extends SequentialCommandGroup {

    public PickupAndHighPresetBlue(Elevator elevator, Manipulator manipulator, Intake intake) {
        addCommands(
                new InstantCommand(() -> intake.setIntake(-1)),
                new ManualPickup(manipulator),

                new WaitCommand(375),
                new InstantCommand(() -> intake.setIntake(-.75)),
                new TurretToPosition(manipulator, Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION + 200, 1).alongWith(new InstantCommand(() -> manipulator.setArm(0.46))).alongWith(new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_PREP_POS))).alongWith(new ElevatorToPosition(elevator, 150, 1)),
                new ElevatorToPosition(elevator, 1075, 1),
                new InstantCommand(() -> intake.setIntake(0))



        );
    }
}

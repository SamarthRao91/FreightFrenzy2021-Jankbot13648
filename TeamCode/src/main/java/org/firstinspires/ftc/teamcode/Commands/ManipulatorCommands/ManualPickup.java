package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Intake;

public class ManualPickup extends SequentialCommandGroup {

    public ManualPickup(Manipulator manipulator, Intake intake) {
        addCommands(
                new InstantCommand(manipulator::closeClaw),
                new WaitCommand(100),
                new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - 0.4)),
                new InstantCommand(() -> intake.setIntake(-0.8)),
                new WaitCommand(100),
                new InstantCommand(() -> intake.setIntake(0))

        );

        manipulator.manualPickUp = true;

        addRequirements(manipulator);
    }
}

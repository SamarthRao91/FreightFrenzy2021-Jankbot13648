package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class ManualPickup extends SequentialCommandGroup {

    public ManualPickup(Manipulator manipulator) {
        addCommands(
                new InstantCommand(manipulator::closeClaw),
                new WaitCommand(100),
                new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - 0.2))
        );

        manipulator.manualPickUp = true;

        addRequirements(manipulator);
    }
}

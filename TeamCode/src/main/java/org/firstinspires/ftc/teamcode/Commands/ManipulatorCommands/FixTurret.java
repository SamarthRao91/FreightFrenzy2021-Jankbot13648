package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class FixTurret extends SequentialCommandGroup {
    Manipulator manipulator;

    public FixTurret(Manipulator manipulator) {
        this.manipulator = manipulator;






            addCommands(
                    new ManualPickup(manipulator),
                    new WaitCommand(500),
                    new TurretResetWithPot(manipulator),
                    new InstantCommand(() -> manipulator.setSpeed(0)),
                    new InstantCommand(() -> manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND)),
                    new WaitCommand(30000)
            );



        addRequirements(manipulator);
    }
}
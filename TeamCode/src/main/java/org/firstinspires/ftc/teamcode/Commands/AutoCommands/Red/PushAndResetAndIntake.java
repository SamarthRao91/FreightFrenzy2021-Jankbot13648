package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.PushAndReset;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class PushAndResetAndIntake extends SequentialCommandGroup {
    public PushAndResetAndIntake(Elevator elevator, Manipulator manipulator, Intake intake) {
        addCommands(
                new PushAndReset(elevator, manipulator),
                new WaitCommand(250),
                new InstantCommand(() -> intake.setIntake(1))

        );
    }
}

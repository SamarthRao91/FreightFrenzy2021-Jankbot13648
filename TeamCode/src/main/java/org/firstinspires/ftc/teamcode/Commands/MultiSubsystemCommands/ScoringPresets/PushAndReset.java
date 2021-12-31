package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.PushGamepiece;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class PushAndReset extends SequentialCommandGroup{
    public PushAndReset(Elevator elevator, Manipulator manipulator) {
        addCommands(
                new PushGamepiece(manipulator),
                new WaitCommand(250),
                new ResetMechanisms(elevator, manipulator)
        );

        addRequirements(elevator, manipulator);
    }
}

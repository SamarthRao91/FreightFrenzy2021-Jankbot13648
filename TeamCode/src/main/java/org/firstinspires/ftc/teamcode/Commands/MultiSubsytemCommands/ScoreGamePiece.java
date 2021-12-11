package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms.ResetMechanisms;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class ScoreGamePiece extends SequentialCommandGroup {

    public ScoreGamePiece(Elevator elevator, Manipulator manipulator)
    {
        addCommands(
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.OPEN_POSITION)),
                new ElevatorToPosition(elevator, 1400 + 450 + 400, 1),
                new WaitCommand(250),
                new InstantCommand(() -> manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS)),
                new WaitCommand(500),
                new ResetMechanisms(elevator, manipulator),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.OPEN_POSITION)),
                new WaitCommand(375)
        );

        addRequirements(elevator, manipulator);
    }

}

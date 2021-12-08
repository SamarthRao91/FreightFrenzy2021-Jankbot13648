package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;


import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class DropGamePiece extends SequentialCommandGroup {

    public DropGamePiece(Elevator elevator, Manipulator manipulator)
    {
        addCommands(
                () -> manipulator.setClawPosition(Constants.Manipulator.Claw.OPEN_POSITION),
                new WaitCommand(0.250),
                () -> manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS),
                new WaitCommand(0.500)
        );

        addRequirements(elevator, manipulator);
    }

}

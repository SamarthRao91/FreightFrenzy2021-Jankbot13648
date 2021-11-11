package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class ManualPickup extends SequentialCommandGroup {

    public ManualPickup(Elevator elevator, Manipulator manipulator)
    {
        addCommands(
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new WaitCommand(250),
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_TURRET_POSITION, 1)
        );

        addRequirements(elevator, manipulator);
    }
}

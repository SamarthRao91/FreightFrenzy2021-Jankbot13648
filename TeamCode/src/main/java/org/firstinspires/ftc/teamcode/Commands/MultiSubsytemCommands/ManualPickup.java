package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;


import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class ManualPickup extends SequentialCommandGroup {

    public ManualPickup(Elevator elevator, Manipulator manipulator)
    {
        addCommands(
                () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new WaitCommand(0.250),
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_TURRET_POSITION, 1)
        );

        addRequirements(elevator, manipulator);
    }

    public ManualPickup(Elevator elevator, Manipulator manipulator, Intake intake)
    {
        addCommands(
                () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new WaitCommand(0.250),
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_TURRET_POSITION, 1),
                () -> intake.setIntake(-0.66),
                new WaitCommand(1),
                () -> intake.setIntake(0)
        );

        addRequirements(elevator, manipulator, intake);
    }
}

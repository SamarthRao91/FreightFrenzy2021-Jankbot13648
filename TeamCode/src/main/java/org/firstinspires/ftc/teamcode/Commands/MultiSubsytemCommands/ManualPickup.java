package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class ManualPickup extends SequentialCommandGroup {

    public ManualPickup(Elevator elevator, Manipulator manipulator)
    {
        addCommands(
                new InstantCommand(() -> manipulator.setTurretPosition(Constants.Manipulator.Turret.ZERO_POSITION)),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new WaitCommand(250),
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_TURRET_POSITION, 1)
        );

        addRequirements(elevator, manipulator);
    }

    public ManualPickup(Elevator elevator, Manipulator manipulator, Intake intake)
    {
        addCommands(
                new InstantCommand(() -> manipulator.setTurretPosition(Constants.Manipulator.Turret.ZERO_POSITION)),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new WaitCommand(250),
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_TURRET_POSITION, 1),
                new InstantCommand(() -> intake.setIntake(-0.8)),
                new WaitCommand(1000),
                new InstantCommand(() -> intake.setIntake(0))
        );

        addRequirements(elevator, manipulator, intake);
    }
}

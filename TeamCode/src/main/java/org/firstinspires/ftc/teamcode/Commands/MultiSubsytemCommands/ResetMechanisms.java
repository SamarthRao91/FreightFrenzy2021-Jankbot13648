package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class ResetMechanisms extends SequentialCommandGroup {

    public ResetMechanisms(Elevator elevator, Manipulator manipulator)
    {
        addCommands(
                //new ManipulatorToPosition(manipulator, manipulator.getTurretPosition(), Constants.Manipulator.Extender.MIN_POS, Constants.Manipulator.Claw.CLOSE_POSITION),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new InstantCommand(() -> manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS)),
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_EXTENDER_POSITION + 200, 1),
                new InstantCommand(() -> manipulator.setTurretPosition(Constants.Manipulator.Turret.ZERO_POSITION)),
                new WaitCommand(500),
                new ElevatorToPosition(elevator, Constants.Elevator.MINIMUM_POSITION, 1),
                new WaitCommand(250),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.OPEN_POSITION))
        );

        addRequirements(elevator, manipulator);
    }
}

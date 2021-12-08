package org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms;

import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class BlueBiasedResetMechanisms extends SequentialCommandGroup {

    public BlueBiasedResetMechanisms(Elevator elevator, Manipulator manipulator)
    {
        addCommands(
                //new ManipulatorToPosition(manipulator, manipulator.getTurretPosition(), Constants.Manipulator.Extender.MIN_POS, Constants.Manipulator.Claw.CLOSE_POSITION),
                () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                () -> manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS)),
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_EXTENDER_POSITION + 200, 1),
                () -> manipulator.setTurretPosition(0.51),
                new WaitCommand(0.750),
                new ElevatorToPosition(elevator, Constants.Elevator.MINIMUM_POSITION, 1),
                new WaitCommand(0.175),
                () -> manipulator.setClawPosition(Constants.Manipulator.Claw.OPEN_POSITION)
        );

        addRequirements(elevator, manipulator);
    }
}

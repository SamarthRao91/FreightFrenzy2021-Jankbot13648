package org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.TurretToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
public class BlueLowPreset extends SequentialCommandGroup {

    public BlueLowPreset(Elevator elevator, Manipulator manipulator, Intake intake) {

        if(!manipulator.manualPickUp)
        {
            addCommands(
                    new ManualPickup(manipulator, intake),
                    new WaitCommand(175),
                    new SequentialCommandGroup(
                            new ElevatorToPosition(elevator, 50, 1),
                            new InstantCommand(() -> manipulator.setArm(0.25)),
                            new TurretToPosition(manipulator, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION - 125, 1)
                    )
            );
        }

        else
        {
            addCommands(
                    new SequentialCommandGroup(
                            new ElevatorToPosition(elevator, 50, 1),
                            new InstantCommand(() -> manipulator.setArm(0.25)),
                            new TurretToPosition(manipulator, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION - 125, 1)
                    )
            );
        }

        addRequirements(elevator, manipulator);
    }
}

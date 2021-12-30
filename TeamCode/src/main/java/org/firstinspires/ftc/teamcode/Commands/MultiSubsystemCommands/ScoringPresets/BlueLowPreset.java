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

public class BlueLowPreset extends SequentialCommandGroup {

    public BlueLowPreset(Elevator elevator, Manipulator manipulator) {

        if(!manipulator.manualPickUp)
        {
            addCommands(
                    new ManualPickup(manipulator),
                    new WaitCommand(175),
                    new ParallelCommandGroup(
                            new ElevatorToPosition(elevator, 50, 1),
                            new InstantCommand(() -> manipulator.setArm(0.25)),
                            new TurretToPosition(manipulator, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION - 125, .66)
                    )
            );
        }

        else
        {
            addCommands(
                    new ParallelCommandGroup(
                            new ElevatorToPosition(elevator, 50, 1),
                            new InstantCommand(() -> manipulator.setArm(0.25)),
                            new TurretToPosition(manipulator, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION - 125, .66)
                    )
            );
        }

        addRequirements(elevator, manipulator);
    }
}

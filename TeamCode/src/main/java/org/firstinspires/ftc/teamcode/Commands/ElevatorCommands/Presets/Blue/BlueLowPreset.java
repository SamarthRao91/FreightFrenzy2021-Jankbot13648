package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Blue;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class BlueLowPreset extends SequentialCommandGroup {
    public BlueLowPreset(Elevator elevator, Manipulator manipulator) {
        addCommands(
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_TURRET_POSITION + 200, 1),
                new InstantCommand(() -> manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION)),
                new WaitCommand(500),
                new InstantCommand(() -> manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS + 0.2))
        );
    }
}

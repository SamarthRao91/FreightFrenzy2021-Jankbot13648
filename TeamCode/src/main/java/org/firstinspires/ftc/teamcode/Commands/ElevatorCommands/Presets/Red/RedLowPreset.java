package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class RedLowPreset extends SequentialCommandGroup {
    public RedLowPreset(Elevator elevator, Manipulator manipulator) {
        addCommands(
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_TURRET_POSITION, 1),
                new InstantCommand(() -> manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION + 0.0625)),
                new WaitCommand(500),
                new InstantCommand(() -> manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS + 0.15))
        );
    }
}

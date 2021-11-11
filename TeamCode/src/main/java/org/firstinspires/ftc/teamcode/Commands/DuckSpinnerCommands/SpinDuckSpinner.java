package org.firstinspires.ftc.teamcode.Commands.DuckSpinnerCommands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;

public class SpinDuckSpinner extends SequentialCommandGroup {
    public SpinDuckSpinner(DuckSpinner duckSpinner, boolean inverted, double startSpeed, double endSpeed)
    {
        if(!inverted)
        {
            addCommands(
                    new DuckWheelToPosition(duckSpinner, 675, startSpeed),
                    new DuckWheelToPosition(duckSpinner, 325, endSpeed)
            );
        }

        else
        {
            addCommands(
                    new DuckWheelToPosition(duckSpinner, -675, startSpeed),
                    new DuckWheelToPosition(duckSpinner, -325, endSpeed)
            );
        }

        addRequirements(duckSpinner);
    }
}

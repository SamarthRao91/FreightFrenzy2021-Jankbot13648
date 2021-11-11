package org.firstinspires.ftc.teamcode.Commands.DuckSpinnerCommands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;

public class SpinDuckSpinner extends SequentialCommandGroup {
    public SpinDuckSpinner(DuckSpinner duckSpinner, boolean inverted)
    {
        if(!inverted)
        {
            addCommands(
                    new DuckWheelToPosition(duckSpinner, 675, 0.2),
                    new DuckWheelToPosition(duckSpinner, 325, 0.3)
            );
        }

        else
        {
            addCommands(
                    new DuckWheelToPosition(duckSpinner, -675, 0.6),
                    new DuckWheelToPosition(duckSpinner, -325, 1)
            );
        }

        addRequirements(duckSpinner);
    }
}

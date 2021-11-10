package org.firstinspires.ftc.teamcode.Commands.DuckSpinnerCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;

public class SpinDuckWheel extends CommandBase {

    private final DuckSpinner duckSpinner;

    private final boolean inverted;

    public SpinDuckWheel(DuckSpinner duckSpinner, boolean inverted) {
        this.duckSpinner = duckSpinner;
        this.inverted = inverted;

        addRequirements(duckSpinner);
    }

    @Override
    public void initialize()
    {
        if(!inverted)
        {
            duckSpinner.setTargetPosition(1000);
        }

        else
        {
            duckSpinner.setTargetPosition(-1000);
        }
    }

    @Override
    public void execute()
    {
        if(!inverted)
        {
            if (duckSpinner.getPosition() >= 675) {
                duckSpinner.setSpeed(1);
            } else {
                duckSpinner.setSpeed(0.6);

            }
        }

        else {
            if (duckSpinner.getPosition() <= -675) {
                duckSpinner.setSpeed(-1);
            } else {
                duckSpinner.setSpeed(-0.6);
            }
        }
    }

    @Override
    public void end(boolean isInterrupted)
    {
        duckSpinner.setSpeed(0);
    }

    @Override
    public boolean isFinished()
    {
        return duckSpinner.atTargetPosition();
    }
}

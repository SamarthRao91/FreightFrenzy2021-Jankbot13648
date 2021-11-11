package org.firstinspires.ftc.teamcode.Commands.DuckSpinnerCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;

public class DuckWheelToPosition extends CommandBase {

    private final DuckSpinner duckSpinner;

    private final int target;
    private final double speed;

    public DuckWheelToPosition(DuckSpinner duckSpinner, int target, double speed) {
        this.duckSpinner = duckSpinner;
        this.target = target;
        this.speed = speed;

        addRequirements(duckSpinner);
    }

    @Override
    public void initialize()
    {
        duckSpinner.resetEncoder();
        duckSpinner.setTargetPosition(target);
    }

    @Override
    public void execute()
    {
        duckSpinner.setSpeed(speed);
    }

    @Override
    public void end(boolean isInterrupted)
    {
        duckSpinner.setSpeed(0);
        duckSpinner.resetEncoder();
    }

    @Override
    public boolean isFinished()
    {
        return duckSpinner.atTargetPosition();
    }
}

package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class TurretToPosition extends CommandBase {
    private final Manipulator manipulator;

    private final int target;
    private final double speed;

    public TurretToPosition(Manipulator manipulator, int target, double speed) {
        this.manipulator = manipulator;
        this.target = target;
        this.speed = speed;

        addRequirements(manipulator);
    }

    @Override
    public void initialize()
    {
        manipulator.setTurretTargetPosition(target);
    }

    @Override
    public void execute()
    {
        FtcDashboard.getInstance().getTelemetry().addData("Turret Position", manipulator.getPosition());
        FtcDashboard.getInstance().getTelemetry().update();

        manipulator.setSpeed(speed);
    }

    @Override
    public void end(boolean isInterrupted)
    {
        manipulator.setSpeed(0);
        manipulator.setRunMode(Motor.RunMode.RawPower);
    }

    @Override
    public boolean isFinished()
    {
        return manipulator.atTargetPosition();
    }
}
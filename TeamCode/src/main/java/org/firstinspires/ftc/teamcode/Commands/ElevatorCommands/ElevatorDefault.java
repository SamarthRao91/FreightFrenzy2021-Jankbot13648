package org.firstinspires.ftc.teamcode.Commands.ElevatorCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.Elevator;

import java.util.function.DoubleSupplier;

public class ElevatorDefault extends CommandBase {

    private final Elevator elevator;

    private final DoubleSupplier speed;

    public ElevatorDefault(Elevator elevator, DoubleSupplier speed) {
        this.elevator = elevator;
        this.speed = speed;

        addRequirements(elevator);
    }

    @Override
    public void execute()
    {
        FtcDashboard.getInstance().getTelemetry().addData("Input Speed", speed.getAsDouble());
        FtcDashboard.getInstance().getTelemetry().update();

        elevator.setSpeed(speed.getAsDouble());
    }
}

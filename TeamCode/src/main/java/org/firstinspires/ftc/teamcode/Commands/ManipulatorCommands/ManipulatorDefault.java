package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ManipulatorDefault extends CommandBase {

    private final Manipulator manipulator;

    private final DoubleSupplier leftStickY;

    private final DoubleSupplier speed;

    public ManipulatorDefault(Manipulator manipulator, DoubleSupplier leftStickY, DoubleSupplier speed)
    {
        this.manipulator = manipulator;
        this.speed = speed;

        this.leftStickY = leftStickY;

        addRequirements(manipulator);
    }


    @Override
    public void execute() {
        manipulator.moveArm(-leftStickY.getAsDouble()/100);
        manipulator.setSpeed(speed.getAsDouble());
        if (manipulator.readColorSensor() > 600)
        {
            manipulator.closeClaw();
            new WaitCommand(250);
            manipulator.setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND - 0.4);
        }
        double update = manipulator.update();

       /* FtcDashboard.getInstance().getTelemetry().addData("Manipulator Target", manipulator.getTarget());
        FtcDashboard.getInstance().getTelemetry().addData("Current Manipulator Position", manipulator.getPosition());
        FtcDashboard.getInstance().getTelemetry().addData("Update (Speed To Get To Target)", update);
        FtcDashboard.getInstance().getTelemetry().addData("Last Error", manipulator.getLastError());
        FtcDashboard.getInstance().getTelemetry().addData("Offset", manipulator.getEncoderOffset());*/

       // FtcDashboard.getInstance().getTelemetry().update();
    }


}

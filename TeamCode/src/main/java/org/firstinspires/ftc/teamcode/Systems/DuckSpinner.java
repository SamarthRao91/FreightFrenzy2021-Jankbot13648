package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.DuckSpinner.DUCK_SPINNER_MOTOR_NAME;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DuckSpinner extends SubsystemBase {

    private Motor spinner;

    public DuckSpinner(HardwareMap hardwareMap) {
        spinner = hardwareMap.get(Motor.class, DUCK_SPINNER_MOTOR_NAME);
        spinner.setInverted(false);
        spinner.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        spinner.setRunMode(Motor.RunMode.PositionControl);
        spinner.setPositionCoefficient(0.05);
        spinner.setPositionTolerance(10);
    }

    public void setTargetPosition(int targetPosition)
    {
        spinner.setTargetPosition(targetPosition);
    }

    public void setSpeed(double speed)
    {
        spinner.set(speed);
    }

    public boolean atTargetPosition()
    {
        return spinner.atTargetPosition();
    }

    public int getPosition()
    {
        return spinner.getCurrentPosition();
    }
}



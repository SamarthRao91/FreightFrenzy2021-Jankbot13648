package org.firstinspires.ftc.teamcode.Systems;


import static org.firstinspires.ftc.teamcode.Constants.Elevator.ELEVATOR_MOTOR_NAME;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants;

public class Elevator extends SubsystemBase {
    private Motor elevatorMotor;
    DigitalChannel ls;

    public Elevator(HardwareMap hardwareMap) {
        elevatorMotor = hardwareMap.get(Motor.class, ELEVATOR_MOTOR_NAME);
        ls = hardwareMap.get(DigitalChannel.class, Constants.Elevator.LIMIT_SWITCH_NAME);
        elevatorMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        elevatorMotor.setRunMode(Motor.RunMode.PositionControl);
        elevatorMotor.setPositionCoefficient(0.05);
        elevatorMotor.setPositionTolerance(10);
    }

    public void setTargetPosition(int targetPosition)
    {
        elevatorMotor.setTargetPosition(targetPosition);
    }

    public void setSpeed(double speed)
    {
        elevatorMotor.set(speed);
    }

    public boolean atTargetPosition()
    {
        return elevatorMotor.atTargetPosition();
    }

    public int getPosition()
    {
        return elevatorMotor.getCurrentPosition();
    }
}


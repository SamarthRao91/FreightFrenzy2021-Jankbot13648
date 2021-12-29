package org.firstinspires.ftc.teamcode.Systems;


import static org.firstinspires.ftc.teamcode.Constants.Elevator.ELEVATOR_MOTOR_NAME;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.MotorWithVeloLimit;

public class Elevator extends SubsystemBase {
    private MotorWithVeloLimit elevatorMotor;
    DigitalChannel ls;

    public Elevator(HardwareMap hardwareMap) {
        elevatorMotor = new MotorWithVeloLimit(hardwareMap, ELEVATOR_MOTOR_NAME);
        elevatorMotor.setInverted(true);
        elevatorMotor.encoder.setDirection(Motor.Direction.FORWARD);
        elevatorMotor.resetEncoder();
        ls = hardwareMap.get(DigitalChannel.class, Constants.Elevator.LIMIT_SWITCH_NAME);
        elevatorMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        elevatorMotor.setRunMode(Motor.RunMode.RawPower);
        elevatorMotor.setPositionCoefficient(0.1);
        elevatorMotor.setPositionTolerance(10);
    }

    public void setTargetPosition(int targetPosition)
    {
        elevatorMotor.setRunMode(Motor.RunMode.PositionControl);
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

    public void setRunMode(Motor.RunMode runMode)
    {
        elevatorMotor.setRunMode(runMode);
    }

    public int getPosition()
    {
        return elevatorMotor.getCurrentPosition();
    }


}


package org.firstinspires.ftc.teamcode.Systems;


import static org.firstinspires.ftc.teamcode.Constants.Elevator.ELEVATOR_MOTOR_NAME;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Util.MotorWithVeloLimit;

public class Elevator extends SubsystemBase {
    private Motor elevatorMotor;
    private PIDFController elevatorController;

    DigitalChannel ls;

    public Elevator(HardwareMap hardwareMap) {

        elevatorController = new PIDFController(
                new PIDCoefficients(
                        Constants.Elevator.ELEVATOR_P_COEFF,
                        Constants.Elevator.ELEVATOR_I_COEFF,
                        Constants.Elevator.ELEVATOR_D_COEFF
                )
        );

        elevatorController.setOutputBounds(-1.0, 1.0);

        elevatorMotor = new Motor(hardwareMap, ELEVATOR_MOTOR_NAME);
        elevatorMotor.setInverted(true);
        elevatorMotor.encoder.setDirection(Motor.Direction.FORWARD);
        elevatorMotor.resetEncoder();
        elevatorMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        elevatorMotor.setRunMode(Motor.RunMode.RawPower);
        elevatorMotor.setPositionCoefficient(0.1);
        elevatorMotor.setPositionTolerance(10);

        ls = hardwareMap.get(DigitalChannel.class, Constants.Elevator.LIMIT_SWITCH_NAME);
    }

    public void setTargetPosition(int targetPosition) {
        elevatorController.setTargetPosition(targetPosition);
    }

    public void setSpeed(double speed) {
        elevatorMotor.set(speed);
    }

    public boolean atTargetPosition() {
        return elevatorController.getLastError() < Constants.Elevator.ELEVATOR_PID_TOLERANCE;
    }

    public void setRunMode(Motor.RunMode runMode) {
        elevatorMotor.setRunMode(runMode);
    }

    public int getPosition() {
        return elevatorMotor.getCurrentPosition();
    }

    public double update() { return elevatorController.update(elevatorMotor.getCurrentPosition()); }

    public void setControllerBounds(double bound)
    {
        elevatorController.setOutputBounds(-bound, bound);
    }

    @Override
    public void periodic() {
        update();
    }
}


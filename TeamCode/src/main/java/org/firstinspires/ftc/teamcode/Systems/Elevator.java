package org.firstinspires.ftc.teamcode.Systems;


import static org.firstinspires.ftc.teamcode.Constants.Elevator.ELEVATOR_MOTOR_NAME;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Util.MotorWithVeloLimit;

public class Elevator extends SubsystemBase {
    private Motor elevatorMotor;
    DigitalChannel ls;

    private PIDFController elevatorController;
    private double speedConstraints = 1.0;

    public Elevator(HardwareMap hardwareMap) {

        elevatorController = new PIDFController(
                Constants.Elevator.ELEVATOR_P_COEFF,
                Constants.Elevator.ELEVATOR_I_COEFF,
                Constants.Elevator.ELEVATOR_D_COEFF,
                Constants.Elevator.ELEVATOR_F_COEFF
        );

        elevatorController.setTolerance(Constants.Elevator.ELEVATOR_PID_TOLERANCE);
        elevatorController.setIntegrationBounds(
                Constants.Elevator.ELEVATOR_I_COEFF_MIN,
                Constants.Elevator.ELEVATOR_I_COEFF_MAX
        );

        elevatorMotor = new Motor(hardwareMap, ELEVATOR_MOTOR_NAME);
        elevatorMotor.setInverted(true);
        elevatorMotor.encoder.setDirection(Motor.Direction.FORWARD);
        elevatorMotor.resetEncoder();
        elevatorMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        elevatorMotor.setRunMode(MotorWithVeloLimit.RunMode.RawPower);

        ls = hardwareMap.get(DigitalChannel.class, Constants.Elevator.LIMIT_SWITCH_NAME);
    }

    public void setTargetPosition(int targetPosition, double speed)
    {
        speedConstraints = speed;
        elevatorController.setSetPoint(targetPosition);
    }

    public void setSpeed(double speed)
    {
        elevatorMotor.set(speed);
    }

    public boolean atTargetPosition()
    {
        return elevatorController.atSetPoint();
    }

    public int getPosition()
    {
        return elevatorMotor.getCurrentPosition();
    }

    public double update()
    {return Math.max(Math.min(elevatorController.calculate(getPosition()), speedConstraints), -speedConstraints);}

    @Override
    public void periodic() {
        update();
    }
}

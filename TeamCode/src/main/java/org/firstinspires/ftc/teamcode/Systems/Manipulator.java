package org.firstinspires.ftc.teamcode.Systems;


import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.Constants.Manipulator.Turret.TURRET_MOTOR_NAME;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Util.MotorWithVeloLimit;

public class Manipulator extends SubsystemBase {

    private MotorWithVeloLimit turretMotor;
    public Servo arm1;
    public Servo arm2;
    public Servo claw;
    public Servo pusher;

    public boolean manualPickUp = false;

    public PIDFController turretController;

    public Manipulator(HardwareMap hardwareMap) {
        arm1 = hardwareMap.get(Servo.class, Constants.Manipulator.Arm.ARM1_NAME);
        arm2 = hardwareMap.get(Servo.class, Constants.Manipulator.Arm.ARM2_NAME);
        claw = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.CLAW_SERVO_NAME);
        pusher = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.PUSHER_SERVO);

        turretController = new PIDFController(
                new PIDCoefficients(
                        Constants.Manipulator.Turret.TURRET_P_COEFF,
                        Constants.Manipulator.Turret.TURRET_I_COEFF,
                        Constants.Manipulator.Turret.TURRET_D_COEFF
                )
        );

        turretController.setOutputBounds(-1.0, 1.0);

        turretMotor = new MotorWithVeloLimit(hardwareMap, TURRET_MOTOR_NAME);
        turretMotor.setInverted(true);
        turretMotor.encoder.setDirection(Motor.Direction.FORWARD);
        turretMotor.resetEncoder();
        turretMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        turretMotor.setRunMode(Motor.RunMode.RawPower);
        turretMotor.setPositionCoefficient(0.006);
        turretMotor.setPositionTolerance(10);
    }

    public void setArm(double newPos)
    {
        arm1.setPosition(newPos);
        arm2.setPosition(1-newPos);
    }

    public void moveArm(double amount)
    {
        if(amount != 0)
        {
            manualPickUp = false;

            if(amount + getArm1Position() > Constants.Manipulator.Arm.ARM1_LOWER_BOUND)
            {
                setArm(Constants.Manipulator.Arm.ARM1_LOWER_BOUND);
            }

            else
                setArm(Math.max(amount + getArm1Position(), Constants.Manipulator.Arm.ARM1_UPPER_BOUND));
        }
    }
    public void setPusher(double newPos)
    {
        pusher.setPosition(newPos);;
    }

    public void closeClaw()
    {
        claw.setPosition(Constants.Manipulator.Claw.CLOSE_POSITION);
    }

    public void openClaw()
    {
        claw.setPosition(Constants.Manipulator.Claw.OPEN_POSITION);
    }

    public double getArm1Position()
    {
        return arm1.getPosition();
    }

    public void setTurretTargetPosition(int targetPosition)
    {
        turretController.setTargetPosition(targetPosition);
    }

    public double getTarget()
    {
        return turretController.getTargetPosition();
    }

    public double getLastError()
    {
        return turretController.getLastError();
    }

    public void setSpeed(double speed)
    {
        turretMotor.set(speed);
    }

    public boolean atTargetPosition()
    {
        return Math.abs(turretController.getLastError()) < Math.abs(Constants.Manipulator.Turret.TURRET_PID_TOLERANCE);
    }

    public double update()
    {
        return turretController.update(getPosition());
    }

    public int getPosition()
    {
        return turretMotor.getCurrentPosition();
    }

    public void setControllerBounds(double bound)
    {
        turretController.setOutputBounds(-bound, bound);
    }

    @Override
    public void periodic() {
        update();
    }
}

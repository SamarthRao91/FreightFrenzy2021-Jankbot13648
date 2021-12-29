package org.firstinspires.ftc.teamcode.Systems;


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

    public Manipulator(HardwareMap hardwareMap) {
        arm1 = hardwareMap.get(Servo.class, Constants.Manipulator.Arm.ARM1_NAME);
        arm2 = hardwareMap.get(Servo.class, Constants.Manipulator.Arm.ARM2_NAME);
        claw = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.CLAW_SERVO_NAME);
        pusher = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.PUSHER_SERVO);

        turretMotor = new MotorWithVeloLimit(hardwareMap, TURRET_MOTOR_NAME);
        turretMotor.setInverted(true);
        turretMotor.encoder.setDirection(Motor.Direction.FORWARD);
        turretMotor.resetEncoder();
        turretMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        turretMotor.setRunMode(Motor.RunMode.RawPower);
        turretMotor.setPositionCoefficient(0.1);
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
        turretMotor.setRunMode(Motor.RunMode.PositionControl);
        turretMotor.setTargetPosition(targetPosition);
    }

    public void setSpeed(double speed)
    {
        turretMotor.set(speed);
    }

    public boolean atTargetPosition()
    {
        return turretMotor.atTargetPosition();
    }

    public void setRunMode(Motor.RunMode runMode)
    {
        turretMotor.setRunMode(runMode);
    }

    public int getPosition()
    {
        return turretMotor.getCurrentPosition();
    }


}

package org.firstinspires.ftc.teamcode.Systems;


import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.Constants.Manipulator.Turret.TURRET_MOTOR_NAME;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Util.MotorWithVeloLimit;
import org.opencv.core.Mat;

public class Manipulator extends SubsystemBase {

    private Motor turretMotor;
    public Servo arm1;
    public Servo arm2;
    public Servo claw;
    public Servo pusher;
    public AnalogInput pot;
    private ColorSensor cs;
    private int encoderOffset = 0;

    private PIDFController turretController;

    public boolean manualPickUp = false;
    private double speedConstraints = 1.0;

    public Manipulator(HardwareMap hardwareMap) {
        arm1 = hardwareMap.get(Servo.class, Constants.Manipulator.Arm.ARM1_NAME);
        arm2 = hardwareMap.get(Servo.class, Constants.Manipulator.Arm.ARM2_NAME);
        claw = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.CLAW_SERVO_NAME);
        pusher = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.PUSHER_SERVO);
        pot = hardwareMap.get(AnalogInput.class, "pot");
        cs = hardwareMap.get(ColorSensor.class, "cs");

        turretController = new PIDFController(
                Constants.Manipulator.Turret.TURRET_P_COEFF,
                Constants.Manipulator.Turret.TURRET_I_COEFF,
                Constants.Manipulator.Turret.TURRET_D_COEFF,
                Constants.Manipulator.Turret.TURRET_F_COEFF
        );

        turretController.setTolerance(Constants.Manipulator.Turret.TURRET_PID_TOLERANCE);

        turretController.setIntegrationBounds(
                Constants.Manipulator.Turret.TURRET_I_COEFF_MIN,
                Constants.Manipulator.Turret.TURRET_I_COEFF_MAX
        );

        turretMotor = new MotorWithVeloLimit(hardwareMap, TURRET_MOTOR_NAME);
        turretMotor.setInverted(true);
        turretMotor.encoder.setDirection(Motor.Direction.FORWARD);
        turretMotor.resetEncoder();
        turretMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        turretMotor.setRunMode(Motor.RunMode.RawPower);
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

    public void setTurretTargetPosition(int targetPosition, double speed)
    {
        speedConstraints = speed;
        turretController.setSetPoint(targetPosition);
    }

    public void setSpeed(double speed)
    {
        turretMotor.set(speed);
    }

    public boolean atTargetPosition()
    {
        return turretController.atSetPoint();
    }

    public int getPosition()
    {
        return turretMotor.getCurrentPosition() - encoderOffset;
    }

    public double getPotValue() { return pot.getVoltage();}

    public void resetTurretEncoder(){
        encoderOffset = turretMotor.getCurrentPosition();
    }

    public int readColorSensor() {
        return cs.red();
    }

    public double update()
    {
        return Math.max(Math.min(turretController.calculate(getPosition()), speedConstraints), -speedConstraints);
    }

    @Override
    public void periodic() {
        update();
    }

    public double getTarget() {
        return turretController.getSetPoint();
    }

    public double getLastError() {
        return turretController.getPositionError();
    }

    public int getEncoderOffset() {
        return encoderOffset;
    }
}
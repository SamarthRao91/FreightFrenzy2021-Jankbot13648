package org.firstinspires.ftc.teamcode.Systems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SensorDistance;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Constants;

public class Manipulator extends SubsystemBase {

    private Servo turret;
    private Servo extender;
    private Servo claw;
    private DistanceSensor scoringDetectionDS;

    public Manipulator(HardwareMap hardwareMap) {
        turret = hardwareMap.get(Servo.class, Constants.Manipulator.Turret.TURRET_SERVO_NAME);
        extender = hardwareMap.get(Servo.class, Constants.Manipulator.Extender.EXTENDER_SERVO_NAME);
        claw = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.CLAW_SERVO_NAME);

        scoringDetectionDS = hardwareMap.get(DistanceSensor.class, Constants.Intake.DISTANCE_SENSOR_NAME);
    }

    public void setTurretPosition(double newPos) {
        turret.setPosition(newPos);
    }

    public void setExtenderPosition(double newValue)
    {
        extender.setPosition(newValue);
    }

    public void setClawPosition(double newValue)
    {
        claw.setPosition(newValue);
    }

    public double getTurretPosition() {
        return turret.getPosition();
    }

    public void moveTurretPosition(double amount) {
        if (amount != 0) {
            if (amount + getTurretPosition() > Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION) {
                turret.setPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
            } else
                turret.setPosition(Math.max(amount + getTurretPosition(), Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION));
        }
    }

    public double getExtenderPosition()
    {
        return extender.getPosition();
    }

    public void moveExtenderPosition(double amount) {
        if (amount != 0) {
            if (getExtenderPosition() + amount < Constants.Manipulator.Extender.MIN_POS) {
                extender.setPosition(Constants.Manipulator.Extender.MIN_POS);
            } else
                extender.setPosition(Math.min(getExtenderPosition() + amount, Constants.Manipulator.Extender.MAX_POS));
        }
    }

    public double getClawPosition()
    {
        return claw.getPosition();
    }

    public boolean dsTripped()
    {
        return scoringDetectionDS.getDistance(DistanceUnit.INCH) <= 0.5;
    }
}

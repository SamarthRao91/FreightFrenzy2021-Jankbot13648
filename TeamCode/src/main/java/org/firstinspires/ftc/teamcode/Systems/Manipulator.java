package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.Manipulator.Claw.*;
import static org.firstinspires.ftc.teamcode.Constants.Manipulator.Extender.*;
import static org.firstinspires.ftc.teamcode.Constants.Manipulator.Turret.*;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class Manipulator {

    private Servo turret;
    private Servo extender;
    private Servo claw;

    private Elevator elevatorInstance;

    public Manipulator(HardwareMap hardwareMap, Elevator elevator)
    {
        turret = hardwareMap.get(Servo.class, TURRET_SERVO_NAME);
        extender = hardwareMap.get(Servo.class, EXTENDER_SERVO_NAME);
        claw = hardwareMap.get(Servo.class, CLAW_SERVO_NAME);

        elevatorInstance = elevator;
    }

    public boolean safeToTurret(double newPos)
    {
        //safe turret position is min safe
       return elevatorInstance.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION && (turret.getPosition() != ZERO_POSITION) || //blocks turret from extending in intake position
            (extender.getPosition() < 0 || elevatorInstance.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION) && elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION &&
                    ((newPos < RIGHT_MAXIMUM_POSITION && turret.getPosition() > RIGHT_MAXIMUM_POSITION) || (newPos > LEFT_MAXIMUM_POSITION && turret.getPosition() < RIGHT_MAXIMUM_POSITION));
    }

    // TODO: Add Safe To Extender Checks To Everything
    public boolean safeToExtender(double turretPos)
    {
        return elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION ||
                (turretPos > 0.68 || turretPos < 0.517);
    }

    public void setTurretPosition(double newPos)
    {
        turret.setPosition(newPos);
    }

    public void moveTurretPosition(double amount)
    {
        turret.setPosition(getTurretPosition() + amount);
    }

    public void setExtenderPosition(double newPos)
    {
        extender.setPosition(newPos);
    }

    public void moveExtenderPosition(double amount)
    {
        extender.setPosition(getExtenderPosition() + amount);
    }

    public double getTurretPosition()
    {
        return turret.getPosition();
    }

    public double getExtenderPosition()
    {
        return extender.getPosition();
    }

    public void clawToPosition(double newPos)
    {
        claw.setPosition(newPos);
    }

    public void openClaw()
    {
        clawToPosition(OPEN_POSITION);
    }

   public void capstoneOpenClaw()
   {
       clawToPosition(CAPSTONE_OPEN_FULLY);
   }

   public void closeClaw()
   {
       clawToPosition(CLOSE_POSITION);
   }
}

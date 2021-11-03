package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.Manipulator.Turret.*;
import static org.firstinspires.ftc.teamcode.Constants.Manipulator.Extender.*;
import static org.firstinspires.ftc.teamcode.Constants.Manipulator.Claw.*;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Const;
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

    public boolean safeToTurret(double newpos)
    {
        //safe turret position is min safe
       return elevatorInstance.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION && (turret.getPosition() != ZERO_POSITION) || //blocks turret from extending in intake position
            (extender.getPosition() < 0 || elevatorInstance.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION) && elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION &&
                    ((newpos < RIGHT_MAXIMUM_POSITION && turret.getPosition() > RIGHT_MAXIMUM_POSITION) || (newpos > LEFT_MAXIMUM_POSITION && turret.getPosition() < RIGHT_MAXIMUM_POSITION));
    }

    public boolean safeToExtender()
    {
        return elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION && turret.getPosition() > RIGHT_MAXIMUM_POSITION && turret.getPosition() < LEFT_MAXIMUM_POSITION;
    }

    public void setTurretPosition(double newPos)
    {
        if(safeToTurret(newPos))
        {
            if(newPos > RIGHT_MAXIMUM_POSITION)
            {
                turret.setPosition(RIGHT_MAXIMUM_POSITION);
            }

            else {
                turret.setPosition(Math.max(newPos, LEFT_MAXIMUM_POSITION));
            }
        }
    }

    public void moveTurret(double amount)
    {
        turret.setPosition(getTurretPosition() + amount);
    }

    public void setExtenderPosition(double newPos)
    {
        if(safeToExtender())
        {
            if(newPos > MAX_POS)
            {
                extender.setPosition(MAX_POS);
            }

            else {
                extender.setPosition(Math.max(newPos, MIN_POS));
            }
        }
    }

    public void moveExtender(double amount)
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

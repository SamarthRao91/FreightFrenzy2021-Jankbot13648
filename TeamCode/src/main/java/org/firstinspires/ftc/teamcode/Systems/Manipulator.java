package org.firstinspires.ftc.teamcode.Systems;

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
        turret = hardwareMap.get(Servo.class, Constants.Manipulator.Turret.TURRET_SERVO_NAME);
        extender = hardwareMap.get(Servo.class, Constants.Manipulator.Extender.EXTENDER_SERVO_NAME);
        claw = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.CLAW_SERVO_NAME);

        elevatorInstance = elevator;
    }

    public boolean safeToTurret(double newPos)
    {
        //safe turret position is min safe
       return elevatorInstance.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION && (turret.getPosition() != Constants.Manipulator.Turret.ZERO_POSITION) || //blocks turret from extending in intake position
            (extender.getPosition() < 0 || elevatorInstance.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION) && elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION &&
                    ((newPos < Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION && turret.getPosition() > Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION) || (newPos > Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION && turret.getPosition() < Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION));
    }

    public boolean safeToExtender(double turretPos)
    {
        return elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION ||
                (turretPos > 0.68 || turretPos < 0.517);
    }

    public void setTurretPosition(double newPos)
    {
        double lastExtenderPosition = extender.getPosition();
        extender.setPosition(Constants.Manipulator.Extender.MIN_POS);

        turret.setPosition(newPos);

        if(safeToExtender(newPos))
        {
            extender.setPosition(lastExtenderPosition);
        }
    }

    // TODO: Test With Hardware
    public void moveTurretPosition(double amount)
    {
        double lastExtenderPosition = Constants.Manipulator.Extender.MIN_POS;

        if(amount > 0.2)
        {
            lastExtenderPosition = getExtenderPosition();
            extender.setPosition(Constants.Manipulator.Extender.MIN_POS);

            turret.setPosition(getTurretPosition() + amount/500);

        }

        else if (amount <= 0.2 && safeToExtender(getTurretPosition()))
        {
            extender.setPosition(lastExtenderPosition);
        }
    }

    public void setExtenderPosition(double newPos)
    {
        extender.setPosition(newPos);
    }

    public void moveExtenderPosition(double amount)
    {
        extender.setPosition(getExtenderPosition() + (amount/500));
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
        clawToPosition(Constants.Manipulator.Claw.OPEN_POSITION);
    }

   public void capstoneOpenClaw()
   {
       clawToPosition(Constants.Manipulator.Claw.CAPSTONE_OPEN_FULLY);
   }

   public void closeClaw()
   {
       clawToPosition(Constants.Manipulator.Claw.CLOSE_POSITION);
   }
}

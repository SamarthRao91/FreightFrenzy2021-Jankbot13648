package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Constants;

public class Manipulator {

    private Servo turret;
    private Servo extender;
    private Servo claw;
    private DistanceSensor scoringDetectionDS;

    private final Elevator elevatorInstance;

    public Manipulator(HardwareMap hardwareMap, Elevator[] elevator)
    {
        turret = hardwareMap.get(Servo.class, Constants.Manipulator.Turret.TURRET_SERVO_NAME);
        extender = hardwareMap.get(Servo.class, Constants.Manipulator.Extender.EXTENDER_SERVO_NAME);
        claw = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.CLAW_SERVO_NAME);

        scoringDetectionDS = hardwareMap.get(DistanceSensor.class, Constants.Intake.DISTANCE_SENSOR_NAME);

        elevatorInstance = elevator[0];
    }

    // TODO: TEST
    public boolean safeToTurret(double newPos)
    {
        //safe turret position is min safe
       return (elevatorInstance.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION && (getExtenderPosition() != Constants.Manipulator.Extender.MIN_POS && (newPos > 0.68 || newPos < 0.517)))
               || elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION;
    }

    public boolean safeToExtender(double turretPos)
    {
        return elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION
                || (turretPos > 0.68 || turretPos < 0.517);
    }

    public void setSuperStructure(int elevatorPos, int turretPos, int extenderPos, boolean[] isOpModeActive)
    {
        elevatorInstance.getElevatorMotor()[0].setTargetPosition(elevatorPos);
        elevatorInstance.getElevatorMotor()[0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevatorInstance.getElevatorMotor()[0].setPower(0.5);

        while(elevatorInstance.getElevatorMotor()[0].isBusy() && isOpModeActive[0])
        {
            if(elevatorInstance.getPosition() >= Constants.Elevator.SAFE_TURRET_POSITION)
            {
                turret.setPosition(turretPos);
            }

            if(elevatorInstance.getPosition() >= Constants.Elevator.SAFE_EXTENDER_POSITION)
            {
                extender.setPosition(extenderPos);
            }
        }

        if(getTurretPosition() != turretPos && safeToTurret(turretPos))
        {
            setTurretPosition(turretPos);
        }

        if(getExtenderPosition() != extenderPos && safeToExtender(turretPos))
        {
            setExtenderPosition(extenderPos);
        }

        elevatorInstance.getElevatorMotor()[0].setPower(0);
        elevatorInstance.getElevatorMotor()[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setTurretPosition(double newPos)
    {
        if(newPos > Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION)
        {
            turret.setPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
        }

        else
            turret.setPosition(Math.max(newPos, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION));
    }

    public void moveTurretPosition(double amount)
    {
        if(amount != 0)
        {
            if(amount + getTurretPosition() > Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION)
            {
                turret.setPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
            }

            else
                turret.setPosition(Math.max(amount + getTurretPosition(), Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION));
        }
    }

    public void setExtenderPosition(double newPos)
    {
        if(newPos < Constants.Manipulator.Extender.MIN_POS)
        {
            extender.setPosition(Constants.Manipulator.Extender.MIN_POS);
        }
        else
            extender.setPosition(Math.min(newPos, Constants.Manipulator.Extender.MAX_POS));
    }

    public void moveExtenderPosition(double amount)
    {
        if(amount != 0)
        {
            if(getExtenderPosition() + amount < Constants.Manipulator.Extender.MIN_POS)
            {
                extender.setPosition(Constants.Manipulator.Extender.MIN_POS);
            }
            else
                extender.setPosition(Math.min(getExtenderPosition() + amount, Constants.Manipulator.Extender.MAX_POS));
        }
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

   public void checkDistanceSensor(boolean[] isOpModeActive)
   {
       if( scoringDetectionDS.getDistance(DistanceUnit.INCH) <= 0.2)
       {
           closeClaw();
           // TODO: Add Time Wait For Servo
           elevatorInstance.setPosition(300, isOpModeActive);
       }
   }
}

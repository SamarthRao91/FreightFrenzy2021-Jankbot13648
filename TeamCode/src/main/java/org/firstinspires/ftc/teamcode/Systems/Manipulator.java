package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.CurrentState;
import org.firstinspires.ftc.teamcode.Util.StopWatch;

public class Manipulator {

    private Servo turret;
    private Servo extender;
    private Servo claw;
    private DistanceSensor scoringDetectionDS;

    private final Elevator elevatorInstance;
    private final Intake intakeInstance;

    private StopWatch timer;

    public Manipulator(HardwareMap hardwareMap, Elevator elevator, Intake intake) {
        turret = hardwareMap.get(Servo.class, Constants.Manipulator.Turret.TURRET_SERVO_NAME);
        extender = hardwareMap.get(Servo.class, Constants.Manipulator.Extender.EXTENDER_SERVO_NAME);
        claw = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.CLAW_SERVO_NAME);

        timer = new StopWatch();

        scoringDetectionDS = hardwareMap.get(DistanceSensor.class, Constants.Intake.DISTANCE_SENSOR_NAME);

        elevatorInstance = elevator;
        intakeInstance = intake;
    }

    public void sleep(int amount) {
        timer.setTime(amount);
        CurrentState.ManipulatorState.sleeping = true;
    }

    public boolean isTimerExpired()
    {
        return timer.isExpired();
    }

    public void resetMechanisms()
    {
        CurrentState.ManipulatorState.resetting = true;

        if(!CurrentState.ManipulatorState.sleeping)
        {
            sleep(750);
        }

        else if(isTimerExpired())
        {
            CurrentState.ManipulatorState.sleeping = false;

            closeClaw();
            setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
            elevatorInstance.setPosition(Constants.Elevator.SAFE_TURRET_POSITION + 100);
            resetTurret();


            sleep(750);
            elevatorInstance.setPosition(Constants.Elevator.MINIMUM_POSITION);
            elevatorInstance.resetElevator();
            openClaw();
            sleep(250);
        }

        CurrentState.ManipulatorState.resetting = false;
    }

    // TODO: TEST
    public boolean safeToTurret(double newPos) {
        //safe turret position is min safe
        return (elevatorInstance.getPosition() > Constants.Elevator.SAFE_TURRET_POSITION && (getExtenderPosition() != Constants.Manipulator.Extender.MIN_POS && (newPos > 0.68 || newPos < 0.517)))
                || elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION;
    }

    public boolean safeToExtender(double turretPos) {
        return elevatorInstance.getPosition() > Constants.Elevator.SAFE_EXTENDER_POSITION
                || (turretPos > 0.68 || turretPos < 0.517);
    }

    public void setSuperStructure(int elevatorPos, double turretPos, double extenderPos) {
        elevatorInstance.setPosition(elevatorPos);

        CurrentState.ManipulatorState.currentTurretPos = turretPos;
        CurrentState.ManipulatorState.currentExtenderPos = extenderPos;
    }

    public void queryAtPosition()
    {
        if(!CurrentState.ElevatorState.isRunning && !elevatorInstance.isBusy())
        {
            elevatorInstance.stopElevator();

            if(getTurretPosition() != CurrentState.ManipulatorState.currentTurretPos
                    && safeToTurret(CurrentState.ManipulatorState.currentTurretPos))
            {
                turret.setPosition(CurrentState.ManipulatorState.currentTurretPos);
            }

            if(getExtenderPosition() != CurrentState.ManipulatorState.currentExtenderPos
                    && safeToExtender(CurrentState.ManipulatorState.currentExtenderPos))
            {
                turret.setPosition(CurrentState.ManipulatorState.currentExtenderPos);
            }
        }

        else{
            if (elevatorInstance.getPosition() >= Constants.Elevator.SAFE_TURRET_POSITION) {
                turret.setPosition(CurrentState.ManipulatorState.currentTurretPos);
            }

            if (elevatorInstance.getPosition() >= Constants.Elevator.SAFE_EXTENDER_POSITION) {
                extender.setPosition(CurrentState.ManipulatorState.currentExtenderPos);
            }
        }
    }

    public void resetTurret() {
        turret.setPosition(Constants.Manipulator.Turret.ZERO_POSITION);
    }

    public void setTurretPosition(double newPos) {
        if (newPos > Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION) {
            turret.setPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
        } else
            turret.setPosition(Math.max(newPos, Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION));
    }

    public void moveTurretPosition(double amount) {
        if (amount != 0) {
            if (amount + getTurretPosition() > Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION) {
                turret.setPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
            } else
                turret.setPosition(Math.max(amount + getTurretPosition(), Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION));
        }
    }

    public void setExtenderPosition(double newPos) {
        if (newPos <= Constants.Manipulator.Extender.MIN_POS) {
            extender.setPosition(Constants.Manipulator.Extender.MIN_POS);
        } else
            extender.setPosition(Math.min(newPos, Constants.Manipulator.Extender.MAX_POS));
    }

    public void moveExtenderPosition(double amount) {
        if (amount != 0) {
            if (getExtenderPosition() + amount < Constants.Manipulator.Extender.MIN_POS) {
                extender.setPosition(Constants.Manipulator.Extender.MIN_POS);
            } else
                extender.setPosition(Math.min(getExtenderPosition() + amount, Constants.Manipulator.Extender.MAX_POS));
        }
    }

    public double getTurretPosition() {
        return turret.getPosition();
    }

    public double getExtenderPosition() {
        return extender.getPosition();
    }

    public void clawToPosition(double newPos) {
        claw.setPosition(newPos);
    }

    public void openClaw() {
        clawToPosition(Constants.Manipulator.Claw.OPEN_POSITION);
    }

    public void capstoneOpenClaw() {
        clawToPosition(Constants.Manipulator.Claw.CAPSTONE_OPEN_FULLY);
    }

    public void closeClaw() {
        clawToPosition(Constants.Manipulator.Claw.CLOSE_POSITION);
    }

    public void manualPickup()
    {
        claw.close();
        elevatorInstance.setPosition(300);
    }

    public void checkDistanceSensor() {
        if (scoringDetectionDS.getDistance(DistanceUnit.INCH) <= 0.2) {
            closeClaw();
            intakeInstance.setIntake(0, 0.25);

            StopWatch timer  = new StopWatch(100);
            while(!timer.isExpired());
            elevatorInstance.setPosition(300);

        }
    }
}

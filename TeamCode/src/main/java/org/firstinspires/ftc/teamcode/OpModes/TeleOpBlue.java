package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.*;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;

import java.util.Timer;

@TeleOp(name = "TeleOp - Blue")
public class TeleOpBlue extends LinearOpMode {

    //different subsystems
    MecanumDrive drive;
    Elevator elevator;
    Manipulator manipulator;
    DuckSpinner spinner;
    Intake intake;

    public void resetMechanisms()
    {
            manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
            sleep(500);
            manipulator.setTurretPosition(Constants.Manipulator.Turret.ZERO_POSITION);
            elevator.setPosition(Constants.Elevator.MINIMUM_POSITION);
            if(elevator.islimitPressed())
            {
                elevator.setPosition(0);
            }

    }
    private DistanceSensor scoringAutomation;
    @Override
    public void runOpMode() {

        drive = new MecanumDrive(hardwareMap);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap, elevator);
        spinner = new DuckSpinner(hardwareMap);
        intake = new Intake(hardwareMap);
        scoringAutomation = hardwareMap.get(DistanceSensor.class, Constants.AutomationStuff.DISTANCE_SENSOR_NAME);

        Rev2mDistanceSensor sensorTimeOffFlight = (Rev2mDistanceSensor) scoringAutomation;
        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive())
        {
            Vector2d input = new Vector2d(
                    -gamepad1.left_stick_y,
                    -gamepad1.left_stick_x
            ).rotated(-drive.getRawExternalHeading());

            drive.setWeightedDrivePower(
                    new Pose2d(
                            input.getX(),
                            input.getY(),
                            -gamepad1.right_stick_x
                    )
            );

            //distance sensor automation
           if( scoringAutomation.getDistance(DistanceUnit.INCH) <= 2)
           {
               manipulator.closeClaw();
               elevator.setPosition(300);
           }

            intake.setIntake(gamepad1.right_trigger);
            intake.setIntake(-gamepad1.left_trigger);

            if(gamepad1.a)
            {
                resetMechanisms();
            }

            else if(gamepad1.b)
            {   //low preset
                elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad1.y)
            {   //high preset
                elevator.setPosition(1400);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad1.x)
            {
                //score game piece
                manipulator.openClaw();
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
                resetMechanisms();
            }

            else if(gamepad1.start)
            {
                //high reverse preset
                elevator.setPosition(1400);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            //driver 2 controls

            elevator.setSpeed(-gamepad2.right_stick_y);
            if(elevator.islimitPressed() && -gamepad2.right_stick_y/2 < 0)
            {
                elevator.setPosition(0);
            }
            manipulator.moveTurret(-gamepad2.left_stick_x/150);
            manipulator.moveExtender(-gamepad2.left_stick_y/100);

            if(gamepad2.a)
            {
                resetMechanisms();
            }

            else if(gamepad2.b)
            {   //low preset
                elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad2.y)
            {   //high preset
                elevator.setPosition(1400);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad2.start)
            {
                //high reverse preset
                elevator.setPosition(1400);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            if(gamepad2.x)
            {
                manipulator.openClaw();
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
                resetMechanisms();
            }

            if(gamepad2.dpad_down)
            {
                manipulator.closeClaw();
            }

            else if(gamepad2.dpad_up)
            {
                manipulator.openClaw();
            }

            else if(gamepad2.dpad_right)
            {
                manipulator.capstoneOpenClaw();
            }


            if(gamepad2.right_trigger == 1)
            {
                manipulator.setTurretPosition(0.5);
            }
            telemetry.addData("ID", String.format("%x", sensorTimeOffFlight.getModelID()));
            telemetry.addData("did time out", Boolean.toString(sensorTimeOffFlight.didTimeoutOccur()));
            telemetry.update();
        }
    }
}

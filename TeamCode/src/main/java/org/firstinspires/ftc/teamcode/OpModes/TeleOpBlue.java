package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

@TeleOp(name = "TeleOp - Blue - Built")
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
            elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION + 100);
            manipulator.setTurretPosition(Constants.Manipulator.Turret.ZERO_POSITION);
            sleep(1250);
       // manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
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
                    gamepad1.left_bumper?-gamepad1.left_stick_y/4:-gamepad1.left_stick_y,
                    gamepad1.left_bumper?-gamepad1.left_stick_x/4:-gamepad1.left_stick_x
            ).rotated(-drive.getRawExternalHeading());

            drive.setWeightedDrivePower(
                    new Pose2d(
                            input.getX(),
                            input.getY(),
                            -gamepad1.right_stick_x
                    )
            );

            if(gamepad1.dpad_up)
            {
                drive.resetHeading();
            }

            //distance sensor automation
           if( scoringAutomation.getDistance(DistanceUnit.INCH) <= 0.5)
           {
               sleep(1);
               manipulator.closeClaw();
               elevator.setPosition(300);
           }
           if(gamepad1.right_trigger ==1 )
           {
               intake.setIntake(1);
           }
           else if(gamepad1.left_trigger ==1)
           {
               intake.setIntake(-1);
           }
           else
           {
               intake.setIntake(0);
           }

            if(gamepad1.a)
            {
                resetMechanisms();
            }

            else if(gamepad1.b)
            {   //low preset
                elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION + 300);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
                sleep(700);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS + 0.1);
            }

            else if(gamepad1.y)
            {   //high preset
                elevator.setPosition(1400+200);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad1.x)
            {
                //score game piece
                manipulator.openClaw();
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
               // resetMechanisms();
            }

            else if(gamepad1.start)
            {
                //high reverse preset
                elevator.setPosition(1400+200);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            //driver 2 controls

            elevator.setSpeed(-gamepad2.right_stick_y);
            if(elevator.islimitPressed() && -gamepad2.right_stick_y/2 < 0)
            {
                elevator.setPosition(0);
            }
            manipulator.moveTurretPosition(-gamepad2.left_stick_x);
            manipulator.moveExtenderPosition(-gamepad2.left_stick_y);

            if(gamepad2.a)
            {
                resetMechanisms();
            }

            else if(gamepad2.b)
            {   //low preset
                //elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION);
                elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION + 300);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
                sleep(700);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS+0.1);
            }

            else if(gamepad2.y)
            {   //high preset
                elevator.setPosition(1400+200);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad2.start)
            {
                //high reverse preset
                elevator.setPosition(1400+200);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            if(gamepad2.x)
            {
                manipulator.openClaw();
                sleep(500);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
                sleep(500);
                //resetMechanisms();
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

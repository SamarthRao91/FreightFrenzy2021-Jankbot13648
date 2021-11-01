package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.*;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
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
        if(elevator.getPosition() != Constants.Elevator.MINIMUM_POSITION
                && manipulator.getExtenderPosition() != Constants.Manipulator.Extender.MIN_POS
                && manipulator.getTurretPosition() != Constants.Manipulator.Turret.ZERO_POSITION)
        {
            elevator.setPosition(Constants.Elevator.SAFE_EXTENDER_POSITION);
            manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
            manipulator.setTurretPosition(Constants.Manipulator.Turret.ZERO_POSITION);
            elevator.setPosition(Constants.Elevator.MINIMUM_POSITION);
        }
    }

    @Override
    public void runOpMode() {

        drive = new MecanumDrive(hardwareMap);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap, elevator);
        spinner = new DuckSpinner(hardwareMap);
        intake = new Intake(hardwareMap);

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

            intake.setIntake(gamepad1.right_trigger, gamepad1.left_trigger);

            if(gamepad1.a)
            {
                resetMechanisms();
            }

            else if(gamepad1.b)
            {   //low preset
                elevator.setPosition(300);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad1.y)
            {   //high preset
                elevator.setPosition(600);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
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
                elevator.setPosition(600);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            //driver 2 controls

            elevator.setSpeed(gamepad2.right_stick_y/2);
            manipulator.moveTurret(gamepad2.left_stick_x/2);
            manipulator.moveExtender(gamepad2.left_stick_y/2);

            if(gamepad2.a)
            {
                resetMechanisms();
            }

            else if(gamepad2.b)
            {   //low preset
                elevator.setPosition(300);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad2.y)
            {   //high preset
                elevator.setPosition(600);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION);
                manipulator.setExtenderPosition(Constants.Manipulator.Extender.MAX_POS);
            }

            else if(gamepad2.start)
            {
                //high reverse preset
                elevator.setPosition(600);
                manipulator.setTurretPosition(Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION);
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
        }
    }
}

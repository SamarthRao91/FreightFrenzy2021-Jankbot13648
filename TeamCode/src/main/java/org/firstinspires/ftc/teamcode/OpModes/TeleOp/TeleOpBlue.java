package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

@TeleOp(name = "TeleOp - Blue")
public class TeleOpBlue extends LinearOpMode {

    //different subsystems
    MecanumDrive drive;
    Elevator elevator;
    Manipulator manipulator;
    DuckSpinner spinner;
    Intake intake;

    public void resetMechanisms() {
        manipulator.sleep(750);
        manipulator.closeClaw();
        manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
        elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION + 100);
        manipulator.resetTurret();
        manipulator.sleep(750);
        elevator.setPosition(Constants.Elevator.MINIMUM_POSITION);
        elevator.resetElevator();
        manipulator.openClaw();
        manipulator.sleep(250);
    }

    @Override
    public void runOpMode() {

        drive = new MecanumDrive(hardwareMap);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap, elevator, intake);
        spinner = new DuckSpinner(hardwareMap);
        intake = new Intake(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive()) {

            Vector2d input = new Vector2d(
                    gamepad1.left_bumper ? gamepad1.left_stick_y / 4 : gamepad1.left_stick_y,
                    gamepad1.left_bumper ? -gamepad1.left_stick_x / 4 : -gamepad1.left_stick_x
            ).rotated(drive.getRawExternalHeading());

            drive.setWeightedDrivePower(
                    new Pose2d(
                            input.getX(),
                            input.getY(),
                            -gamepad1.right_stick_x
                    )
            );

            elevator.setSpeed(-gamepad2.right_stick_y);
            intake.setIntake(gamepad1.right_trigger, gamepad1.left_trigger);

            manipulator.checkDistanceSensor();
            manipulator.moveTurretPosition(gamepad2.left_stick_x / 250);
            manipulator.moveExtenderPosition(-gamepad2.left_stick_y / 200);

            if (gamepad1.a || gamepad2.a) {
                resetMechanisms();
            }

            if (gamepad1.b || gamepad2.b) {
                lowPreset();
            }

            if (gamepad1.y || gamepad2.y) {
                highPreset();
            }

            if (gamepad1.x || gamepad2.x) {
                scoreGamePiecePreset();
            }

            if (gamepad1.start || gamepad2.start) {
                highReversePreset();
            }

            if (gamepad1.dpad_up) {
                drive.resetHeading();
            }

            if (gamepad2.dpad_down) {
                manipulator.closeClaw();
            } else if (gamepad2.dpad_up) {
                manipulator.openClaw();
            } else if (gamepad2.dpad_right) {
                manipulator.capstoneOpenClaw();
            }

            if (gamepad2.left_bumper) {
                manipulator.manualPickup();
            }

            spinner.spinSpinner(gamepad2.right_trigger, -gamepad2.left_trigger);
        }
    }

    public void lowPreset() {
        manipulator.setSuperStructure(
                Constants.Elevator.SAFE_TURRET_POSITION + 500,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS + 0.2
        );
    }

    public void highPreset() {
        manipulator.setSuperStructure(
                1400 + 300,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS
        );
    }

    public void highReversePreset() {
        manipulator.setSuperStructure(
                1400 + 200,
                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS
        );
    }

    public void scoreGamePiecePreset() {
        manipulator.openClaw();
        manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
        manipulator.sleep(500);
        resetMechanisms();
    }
}

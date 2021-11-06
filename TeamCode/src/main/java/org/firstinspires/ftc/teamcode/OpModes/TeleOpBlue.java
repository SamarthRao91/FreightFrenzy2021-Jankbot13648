package org.firstinspires.ftc.teamcode.OpModes;

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
        manipulator.setSuperStructure(
                Constants.Elevator.SAFE_TURRET_POSITION,
                Constants.Manipulator.Turret.ZERO_POSITION,
                Constants.Manipulator.Extender.MIN_POS,
                new boolean[]{opModeIsActive()}
                );

        elevator.setPosition(Constants.Elevator.MINIMUM_POSITION, new boolean[]{opModeIsActive()});

    }

    @Override
    public void runOpMode() {

        drive = new MecanumDrive(hardwareMap);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap, new Elevator[]{elevator});
        spinner = new DuckSpinner(hardwareMap);
        intake = new Intake(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive()) {
            Vector2d input = new Vector2d(
                    gamepad1.left_bumper ? -gamepad1.left_stick_y / 4 : -gamepad1.left_stick_y,
                    gamepad1.left_bumper ? -gamepad1.left_stick_x / 4 : -gamepad1.left_stick_x
            ).rotated(-drive.getRawExternalHeading());

            drive.setWeightedDrivePower(
                    new Pose2d(
                            input.getX(),
                            input.getY(),
                            -gamepad1.right_stick_x
                    )
            );

            elevator.setSpeed(-gamepad2.right_stick_y);
            manipulator.checkDistanceSensor(new boolean[]{opModeIsActive()});
            manipulator.moveTurretPosition(gamepad2.left_stick_x / 250);
            manipulator.moveExtenderPosition(-gamepad2.left_stick_y / 200);

            intake.setIntake(Math.min(gamepad1.right_trigger * -gamepad1.left_trigger, 1));

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

            if (gamepad2.right_bumper) {
                manipulator.setTurretPosition(0.5);
            }
        }
    }

    public void lowPreset() {
        manipulator.setSuperStructure(
                Constants.Elevator.SAFE_TURRET_POSITION + 300,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS,
                new boolean[]{opModeIsActive()}
        );
    }

    public void highPreset() {
        manipulator.setSuperStructure(
                1400 + 200,
                Constants.Manipulator.Turret.LEFT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS,
                new boolean[]{opModeIsActive()}
        );
    }

    public void highReversePreset() {
        manipulator.setSuperStructure(
                1400 + 200,
                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS,
                new boolean[]{opModeIsActive()}
        );
    }

    public void scoreGamePiecePreset() {

        manipulator.openClaw();
        manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
        //sleep(500);
        //resetMechanisms();
    }
}

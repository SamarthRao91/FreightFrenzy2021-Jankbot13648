package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ANG_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.TRACK_WIDTH;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.acmerobotics.roadrunner.trajectory.constraints.AngularVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MinVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.ProfileAccelerationConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.CapstoneDetectionCamera;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.Util.StopWatch;

import java.util.Arrays;

@Autonomous(name = "Blue Bottom Auto")
public class Blue_Bottom_Auto extends LinearOpMode {

    MecanumDrive drive;
    Elevator elevator;
    Manipulator manipulator;
    DuckSpinner spinner;
    Intake intake;
    CapstoneDetectionCamera capstoneDetectionCamera;
    CapstonePipeline.CapstonePosition capstonePosition;

    //trajectories------------------------
    //0 0 is the robot starting position

    //aligns the robot right next to the goal
    public Trajectory BB_traj1 = BuildTrajectory(new Pose2d())
            .lineToSplineHeading(new Pose2d(12, 12, 0),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();
    //brings the robot close to the duck wheel (TUNE THIS POSITION CAREFULLY)
    public Trajectory BB_traj2 = BuildTrajectory(BB_traj1.end())
            .lineToSplineHeading(new Pose2d(-11, 8, 0),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();
    //prepares robot for intaking
    public Trajectory BB_traj3 = BuildTrajectory(BB_traj2.end())
            .lineToSplineHeading(new Pose2d(-8, 14, 90),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();
    //strafes up to intake
    public Trajectory BB_traj4 = BuildTrajectory(BB_traj3.end())
            .lineToSplineHeading(new Pose2d(0, 14, 90),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();
    //drives forwards for second intake pass
    public Trajectory BB_traj5 = BuildTrajectory(BB_traj4.end())
            .lineToSplineHeading(new Pose2d(0, 8, 90),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();
    //strafes down for second intake pass
    public Trajectory BB_traj6 = BuildTrajectory(BB_traj5.end())
            .lineToSplineHeading(new Pose2d(-13, 8, 90),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();
    //align to goal for the second time
    public Trajectory BB_traj7 = BuildTrajectory(BB_traj6.end())
            .lineToSplineHeading(new Pose2d(12, 12, 0),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();
    //park
    public Trajectory BB_traj8 = BuildTrajectory(BB_traj7.end())
            .lineToSplineHeading(new Pose2d(-20, 30, 0),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    @Override
    public void runOpMode() {

        drive = new MecanumDrive(hardwareMap);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap, new Elevator[]{elevator}, new Intake[]{intake});
        spinner = new DuckSpinner(hardwareMap);
        intake = new Intake(hardwareMap);
        capstoneDetectionCamera = new CapstoneDetectionCamera(hardwareMap);

        while (!isStarted()) {
            capstonePosition = capstoneDetectionCamera.getPosition();
        }

        //automous---------------------------
        //auto has been started

        if(!isStopRequested())
        {
            // TODO: Deploy Intake

            highPreset();

            drive.followTrajectory(BB_traj1);
            scoreGamePiecePreset();

            drive.followTrajectory(BB_traj2);
            //spin duck spinner

            //intake the duck
            intake.setIntake(0.33, 0); //slow speed to prevent duck from flying
            drive.followTrajectory(BB_traj3);
            drive.followTrajectory(BB_traj4);
            drive.followTrajectory(BB_traj5);
            drive.followTrajectory(BB_traj6);
            intake.setIntake(0.0, 0);

            //pick up possesed duck and score
            manipulator.manualPickup();
            drive.followTrajectory(BB_traj7);
            highPreset();
            scoreGamePiecePreset();

            //park
            drive.followTrajectory(BB_traj8);
        }

        requestOpModeStop();

    }

    //methods-----------------------------

    public void resetMechanisms() {
        StopWatch timer = new StopWatch(750);
        while (!timer.isExpired());
        manipulator.closeClaw();
        manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
        elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION + 100);
        manipulator.resetTurret();
        StopWatch timer1 = new StopWatch(750);
        timer1.setTime(750);
        while (!timer1.isExpired());
        elevator.setPosition(Constants.Elevator.MINIMUM_POSITION);
        elevator.resetElevator();
        manipulator.openClaw();
    }

    public void highPreset() {
        manipulator.setSuperStructure(
                1400 + 300,
                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS,
                new boolean[]{opModeIsActive()}
        );
    }

    public void scoreGamePiecePreset() {

        manipulator.openClaw();
        manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
        //sleep(500);
        resetMechanisms();
    }

    public TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(MAX_ANG_VEL),
                new MecanumVelocityConstraint(MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(MAX_ACCEL));
    }
}
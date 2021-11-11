package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ANG_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.TRACK_WIDTH;

import com.acmerobotics.roadrunner.drive.Drive;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
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

@Autonomous(name = "Red Bottom Auto")
public class Red_Bottom_Auto extends LinearOpMode {

    MecanumDrive drive;
    Elevator elevator;
    Manipulator manipulator;
    DuckSpinner spinner;
    Intake intake;
    CapstoneDetectionCamera capstoneDetectionCamera;
    CapstonePipeline.CapstonePosition capstonePosition;

    //trajectories------------------------
    //0 0 is the robot starting position

    @Override
    public void runOpMode() {

        drive = new MecanumDrive(hardwareMap);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap, elevator, intake);
        spinner = new DuckSpinner(hardwareMap);
        intake = new Intake(hardwareMap);
        capstoneDetectionCamera = new CapstoneDetectionCamera(hardwareMap);

        Trajectory RB_traj1 = BuildTrajectory(new Pose2d(0,0, Math.toRadians(180)))
                .lineTo(new Vector2d(20, 26),
                        MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
                .build();
        //brings the robot close to the duck wheel (TUNE THIS POSITION CAREFULLY)
        Trajectory RB_traj2 = BuildTrajectory(RB_traj1.end())
                .lineTo(new Vector2d(-8, 6.5),
                        MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
                .build();
        //prepares robot for intaking
        Trajectory RB_traj3 = BuildTrajectory(RB_traj2.end())
                .lineToSplineHeading(new Pose2d(-8, 16, Math.toRadians(-90)),
                        MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
                .build();
        //strafes up to intake
        Trajectory RB_traj4 = BuildTrajectory(RB_traj3.end())
                .lineToSplineHeading(new Pose2d(8, 16, Math.toRadians(-90)),
                        MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
                .build();
        //drives forwards for second intake pass
        Trajectory RB_traj5 = BuildTrajectory(RB_traj4.end())
                .lineToSplineHeading(new Pose2d(8, 11, Math.toRadians(-90)),
                        MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
                .build();
        //strafes down for second intake pass
        Trajectory RB_traj6 = BuildTrajectory(RB_traj5.end())
                .lineToSplineHeading(new Pose2d(-16, 11, Math.toRadians(-90)),
                        MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
                .build();
        //align to goal for the second time
        Trajectory RB_traj7 = BuildTrajectory(RB_traj6.end())
                .lineToSplineHeading(new Pose2d(20, 26, Math.toRadians(180)),
                        MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
                .build();
        //park
        Trajectory RB_traj8 = BuildTrajectory(RB_traj7.end())
                .lineTo(new Vector2d(-25, 35),
                        MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
                .build();

        drive.setPoseEstimate(new Pose2d(0,0,Math.toRadians(180)));
        manipulator.closeClaw();

        while (!isStarted()) {
            capstonePosition = capstoneDetectionCamera.getPosition();
        }
        
        //automous---------------------------
        //auto has been started

        if(!isStopRequested())
        {
            // TODO: Deploy Intake

             highPreset();

            drive.followTrajectory(RB_traj1);

            scoreGamePiecePreset();


            drive.followTrajectory(RB_traj2);
            //spin duck spinner

            spinner.spinReverseSlow();

            //intake the duck
            intake.setIntake(1.0, 0); //slow speed to prevent duck from flying
            drive.followTrajectory(RB_traj3);
            drive.followTrajectory(RB_traj4);

            drive.followTrajectory(RB_traj5);
            drive.followTrajectory(RB_traj6);
            manipulator.closeClaw();
            sleep(100);
            manipulator.manualPickup();


            //pick up possesed duck and score

            drive.followTrajectory(RB_traj7);
            intake.setIntake(0.0, 0);

            highPreset();

            scoreGamePiecePreset();


            //park
            drive.followTrajectory(RB_traj8);


        }

        requestOpModeStop();

    }

    //methods-----------------------------

    public void resetMechanisms() {
        manipulator.sleep(750);
        manipulator.closeClaw();
        manipulator.setExtenderPosition(Constants.Manipulator.Extender.MIN_POS);
        elevator.setPosition(Constants.Elevator.SAFE_TURRET_POSITION + 100);
        manipulator.resetTurret();
        manipulator.sleep(1250);
        elevator.setPosition(Constants.Elevator.MINIMUM_POSITION);
        manipulator.openClaw();
        manipulator.sleep(250);
    }

    public void highPreset() {
        manipulator.setSuperStructure(
                1400 + 350,
                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                Constants.Manipulator.Extender.MAX_POS
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
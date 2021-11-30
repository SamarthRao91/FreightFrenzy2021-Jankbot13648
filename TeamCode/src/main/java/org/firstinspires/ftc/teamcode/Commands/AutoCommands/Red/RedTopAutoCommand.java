package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_ANG_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.TRACK_WIDTH;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcontroller.external.samples.ConceptScanServo;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectorySequence;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.ReLocalizeDriveBase;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red.RedHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.DropGamePiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.RedBiasedResetMechanisms;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

import java.time.Instant;

public class RedTopAutoCommand extends SequentialCommandGroup {

    public RedTopAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, CapstonePipeline.CapstonePosition capstonePosition) {

        Trajectory traj_1 = drive.trajectoryBuilder(new Pose2d(0, 0, 0))
                .lineToConstantHeading(new Vector2d(-7, 1),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))

                .splineToConstantHeading(new Vector2d(-9, 28.5), Math.toRadians(90),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .build();


        Trajectory traj_2 = drive.trajectoryBuilder(traj_1.end(), true)
                .splineToConstantHeading(new Vector2d(-13, 26.9), Math.toRadians(270),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(-6, .5), Math.toRadians(0),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(41, .25), Math.toRadians(0),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .build();

        Trajectory traj_3 = drive.trajectoryBuilder(traj_2.end(), false)
                .lineToConstantHeading(new Vector2d(13, .5),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(7, 29), Math.toRadians(270),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();
        Trajectory traj_4 = drive.trajectoryBuilder(traj_3.end(), true)
                .splineToConstantHeading(new Vector2d(9, 26.8), Math.toRadians(270),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(14, .5), Math.toRadians(0),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(63, .25), Math.toRadians(0),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .build();
        Trajectory traj_5 = drive.trajectoryBuilder(traj_4.end(), false)
                .lineToConstantHeading(new Vector2d(29, .5),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(24, 29), Math.toRadians(270),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .build();
        Trajectory traj_6 = drive.trajectoryBuilder(traj_5.end(), true)
                .splineToConstantHeading(new Vector2d(23, 26.8), Math.toRadians(270),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(28, .5), Math.toRadians(0),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(85, .25), Math.toRadians(0),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .build();
        Trajectory traj_7 = drive.trajectoryBuilder(traj_6.end(), false)
                .lineToConstantHeading(new Vector2d(44, .5),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(39, 29), Math.toRadians(270),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .build();
        Trajectory traj_8 = drive.trajectoryBuilder(traj_7.end(), true)
                .splineToConstantHeading(new Vector2d(32, 26.8), Math.toRadians(270),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(37, .5), Math.toRadians(0),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                .splineToConstantHeading(new Vector2d(90, .25), Math.toRadians(0),
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
                /*.setReversed(false)
                .lineToConstantHeading(new Vector2d(-6, .5))
                .splineToConstantHeading(new Vector2d(0, 26.9), Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(0, 27), Math.toRadians(90))
                .setConstraints(
                        MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                        MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL)
                )*/
                .build();
        addCommands(
                new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, traj_1)),
                new DropGamePiece(elevator, manipulator),
                new InstantCommand(() -> intake.setIntake(1)),
                new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, traj_2)),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new ReLocalizeDriveBase(drive, true),
                new WaitCommand(250),
                new InstantCommand(() -> intake.setIntake(-0.9)),
                new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, traj_3)),
                new DropGamePiece(elevator, manipulator),
                new InstantCommand(() -> intake.setIntake(1)),
                new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, traj_4)),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new ReLocalizeDriveBase(drive, true),
                new WaitCommand(250),
                new InstantCommand(() -> intake.setIntake(-0.9)),
                new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, traj_5)),
                new DropGamePiece(elevator, manipulator),
            new InstantCommand(() -> intake.setIntake(1)),
                new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, traj_6)),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new ReLocalizeDriveBase(drive, true),
                new WaitCommand(250),
                new InstantCommand(() -> intake.setIntake(-0.9)),
                new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, traj_7)),
                new DropGamePiece(elevator, manipulator),
                new InstantCommand(() -> intake.setIntake(1)),
                new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, traj_8)),
                new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new ReLocalizeDriveBase(drive, true),
                new WaitCommand(250),
                new InstantCommand(() -> intake.setIntake(-0.9))


        );
    }
}

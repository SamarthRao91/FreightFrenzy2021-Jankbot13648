package org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_ANG_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.TRACK_WIDTH;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.acmerobotics.roadrunner.trajectory.constraints.AngularVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MinVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.ProfileAccelerationConstraint;

import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;

import java.util.Arrays;

public class Red_Top_Path {

    public static Trajectory RT_traj1 = BuildTrajectory(new Pose2d(0, 0, 0))
            .lineToConstantHeading(new Vector2d(-7, 1),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))

            .splineToConstantHeading(new Vector2d(-9, 28.5), Math.toRadians(90),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj2 = BuildTrajectory(RT_traj1.end(), true)
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

    public static Trajectory RT_traj3 = BuildTrajectory(RT_traj2.end(), false)
            .lineToConstantHeading(new Vector2d(13, .5),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(7, 29), Math.toRadians(270),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj4 = BuildTrajectory(RT_traj3.end(), true)
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

    public static Trajectory RT_traj5 = BuildTrajectory(RT_traj4.end(), false)
            .lineToConstantHeading(new Vector2d(29, .5),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(24, 29), Math.toRadians(270),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj6 = BuildTrajectory(RT_traj5.end(), true)
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

    public static Trajectory RT_traj7 = BuildTrajectory(RT_traj6.end(), false)
            .lineToConstantHeading(new Vector2d(44, .5),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(39, 29), Math.toRadians(270),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj8 = BuildTrajectory(RT_traj7.end(), true)
            .splineToConstantHeading(new Vector2d(32, 26.8), Math.toRadians(270),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(37, .5), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(90, .25), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }

    public static TrajectoryBuilder BuildTrajectory(Pose2d startPose, boolean reversed) {
        return new TrajectoryBuilder(startPose, reversed, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }
}

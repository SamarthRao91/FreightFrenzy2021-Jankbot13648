package org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Blue;

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

public class Blue_Top_Path {
    public static Trajectory BT_traj1 = BuildTrajectory(new Pose2d(0, 0, 0))
            .lineToConstantHeading(new Vector2d(-3, -1),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))

            .splineToConstantHeading(new Vector2d(-21.5, -23.5), Math.toRadians(270),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj2 = BuildTrajectory(BT_traj1.end(), true)
            .lineToSplineHeading(new Pose2d(-17, -22.6, Math.toRadians(1)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(-4, 6), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj2fix = BuildTrajectory(BT_traj2.end())
            .splineToConstantHeading(new Vector2d(39, 20), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj3 = BuildTrajectory(BT_traj2fix.end(), false)
            .lineToSplineHeading(new Pose2d(5, 5, 0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(-7, -8), Math.toRadians(90),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj4 = BuildTrajectory(BT_traj3.end(), true)
            .splineToConstantHeading(new Vector2d(-7, -7.8), Math.toRadians(90),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(0, 13), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj4fix = BuildTrajectory(BT_traj4.end(), true)
            .splineToConstantHeading(new Vector2d(60, 25), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj5 = BuildTrajectory(BT_traj4fix.end(), false)
            .lineToConstantHeading(new Vector2d(20, 8),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(13, -8), Math.toRadians(90),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj6 = BuildTrajectory(BT_traj5.end(), true)
            .splineToConstantHeading(new Vector2d(13, -7.8), Math.toRadians(90),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(20, 20), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj6fix = BuildTrajectory(BT_traj6.end(), true)
            .splineToConstantHeading(new Vector2d(80, 25), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj7 = BuildTrajectory(BT_traj6fix.end(), false)
            .lineToConstantHeading(new Vector2d(20, 8),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(13, -17), Math.toRadians(90),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory BT_traj8 = BuildTrajectory(BT_traj7.end(), true)
            .splineToConstantHeading(new Vector2d(15, -16.8), Math.toRadians(90),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(20, 5), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .splineToConstantHeading(new Vector2d(80, 20), Math.toRadians(0),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }

    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose, boolean reversed) {
        return new TrajectoryBuilder(startPose, reversed, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }
}

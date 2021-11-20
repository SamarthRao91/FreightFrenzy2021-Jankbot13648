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

import java.util.Arrays;

public class Red_Top_Path {

    //clear bumps
    public static Trajectory RT_traj1 = BuildTrajectory(new Pose2d(0,0, Math.toRadians(0)))
            .splineToConstantHeading(new Vector2d(-7, 0.25),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-14, 22),
                    Math.toRadians(90))
            .build();

    //align to warehouse
    public static Trajectory RT_traj3 = BuildTrajectory(RT_traj1.end())
            .splineToConstantHeading(new Vector2d(-7, -1.5),
                    Math.toRadians(0))
            .splineToConstantHeading(new Vector2d(24, -2.5),
                    Math.toRadians(0))
            .build();

    //back out
    public static Trajectory RT_traj5 = BuildTrajectory(RT_traj3.end())
            .splineToConstantHeading(new Vector2d(18, -3.5),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-7, -4),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-16, 24),
                    Math.toRadians(90))
            .build();

    //align to warehouse
    public static Trajectory RT_traj8 = BuildTrajectory(RT_traj5.end())
            .splineToConstantHeading(new Vector2d(-7, -4.5),
                    Math.toRadians(0))
            .splineToConstantHeading(new Vector2d(30, -5),
                    Math.toRadians(0))
            .build();

    //back out
    public static Trajectory RT_traj10 = BuildTrajectory(RT_traj8.end())
            .splineToConstantHeading(new Vector2d(18, -6),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-7, -6.5),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-15, 22),
                    Math.toRadians(90))
            .build();

    //align to warehouse
    public static Trajectory RT_traj13 = BuildTrajectory(RT_traj10.end())
            .splineToConstantHeading(new Vector2d(-7, -7),
                    Math.toRadians(0))
            .splineToConstantHeading(new Vector2d(32, -7.5),
                    Math.toRadians(0))
            .build();

    //exit freight pile but remain parked
    public static Trajectory RT_traj15 = BuildTrajectory(RT_traj13.end())
            .lineTo(new Vector2d(28, -8))
            .build();

    //align to goal
    public static Trajectory RT_traj16 = BuildTrajectory(RT_traj15.end())
            .lineTo(new Vector2d(-20, 22))
            .build();

    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }
}

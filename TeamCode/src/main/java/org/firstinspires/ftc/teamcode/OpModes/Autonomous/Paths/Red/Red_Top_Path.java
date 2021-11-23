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
            .splineToConstantHeading(new Vector2d(-7, 0.125),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-14, 27),
                    Math.toRadians(90))
            .build();

    //align to warehouse
    public static Trajectory RT_traj2 = BuildTrajectory(RT_traj1.end())
            .splineToConstantHeading(new Vector2d(-2, 4),
                    Math.toRadians(0))
            .splineToConstantHeading(new Vector2d(32, 1),
                    Math.toRadians(180))
            .build();

    //back out
    public static Trajectory RT_traj3 = BuildTrajectory(RT_traj2.end())
            .splineToConstantHeading(new Vector2d(18, .125),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-7,  .5),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-14, 27),
                    Math.toRadians(90))
            .build();

    //align to warehouse
    public static Trajectory RT_traj4 = BuildTrajectory(RT_traj3.end())
            .splineToConstantHeading(new Vector2d(-2, 4),
                    Math.toRadians(0))
            .splineToConstantHeading(new Vector2d(32, 1),
                    Math.toRadians(180))
            .build();

    //back out
    public static Trajectory RT_traj5 = BuildTrajectory(RT_traj4.end())
            .splineToConstantHeading(new Vector2d(18, .125),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-7, .125),
                    Math.toRadians(180))
            .splineToConstantHeading(new Vector2d(-8, 22),
                    Math.toRadians(90))
            .build();

    //align to warehouse
    public static Trajectory RT_traj6 = BuildTrajectory(RT_traj5.end())
            .splineToConstantHeading(new Vector2d(-7, .125),
                    Math.toRadians(270))
            .splineToConstantHeading(new Vector2d(32, .125),
                    Math.toRadians(0))
            .build();

    //exit freight pile but remain parked
    public static Trajectory RT_traj7 = BuildTrajectory(RT_traj6.end())
            .lineTo(new Vector2d(28, -8))
            .build();

    //align to goal
    public static Trajectory RT_traj8 = BuildTrajectory(RT_traj7.end())
            .lineTo(new Vector2d(-20, 22))
            .build();

    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }
}

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
                    Math.toRadians(180),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )
            .splineToConstantHeading(new Vector2d(-13, 27),
                    Math.toRadians(90),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )
            .build();

    //align to warehouse
    public static Trajectory RT_traj2 = BuildTrajectory(RT_traj1.end(), true)
            .splineToConstantHeading(new Vector2d(-14, 26.9),
                    Math.toRadians(270),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )
            .splineToConstantHeading(new Vector2d(-6, 3),
                    Math.toRadians(0),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )
            .splineToConstantHeading(new Vector2d(38, 1),
                    Math.toRadians(0),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )
          /*  .splineToConstantHeading(new Vector2d(-14, 27),
                    Math.toRadians(90))*/
            .build();

    public static Trajectory RT_traj3 = BuildTrajectory(RT_traj2.end())
            .splineToConstantHeading(new Vector2d(32.9, .25),
                    Math.toRadians(180),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )
            .splineToConstantHeading(new Vector2d(4, 1),
                    Math.toRadians(180),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )
            .splineToConstantHeading(new Vector2d(-1, 26.9),
                    Math.toRadians(90),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )
            .splineToConstantHeading(new Vector2d(-1, 27),
                    Math.toRadians(90),
                    new MinVelocityConstraint(Arrays.asList(
                            new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                            new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
                    )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL)
            )

            /*  .splineToConstantHeading(new Vector2d(-14, 27),
                      Math.toRadians(90))*/
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

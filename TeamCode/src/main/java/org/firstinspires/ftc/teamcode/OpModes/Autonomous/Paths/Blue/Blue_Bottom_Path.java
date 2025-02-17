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

import java.util.Arrays;

public class Blue_Bottom_Path {
    public static Trajectory BB_traj1 = BuildTrajectory(new Pose2d(0,0, Math.toRadians(180)))
            .lineTo(new Vector2d(15, -2))
            .build();

    //brings the robot close to the duck wheel (TUNE THIS POSITION CAREFULLY)
    public static Trajectory BB_traj2 = BuildTrajectory(BB_traj1.end())
            .lineToSplineHeading(new Pose2d(-23, -13.5, Math.toRadians(90)))
            .build();

    //prepares robot for intaking
    public static Trajectory BB_traj3 = BuildTrajectory(BB_traj2.end())
            .lineToSplineHeading(new Pose2d(-16, -16, Math.toRadians(90)))
            .build();

    //strafes up to intake
    public static Trajectory BB_traj4 = BuildTrajectory(BB_traj3.end())
            .lineToSplineHeading(new Pose2d(12, -15, Math.toRadians(90)))
            .build();

    //drives forwards for second intake pass
    public static Trajectory BB_traj5 = BuildTrajectory(BB_traj4.end())
            .lineToSplineHeading(new Pose2d(12, -12, Math.toRadians(90)))
            .build();

    //strafes down for second intake pass
    public static Trajectory BB_traj6 = BuildTrajectory(BB_traj5.end())
            .lineToSplineHeading(new Pose2d(-13, -12.5, Math.toRadians(90)))
            .build();
    //grabs duck under wheel
    public static Trajectory BB_traj7 = BuildTrajectory(BB_traj6.end())
            .lineToSplineHeading(new Pose2d(-19, -10.5, Math.toRadians(135)))
            .build();
    public static Trajectory BB_traj71 = BuildTrajectory(BB_traj7.end())
            .lineToSplineHeading(new Pose2d(-11, -9, Math.toRadians(90)))
            .build();
    public static Trajectory BB_traj72 = BuildTrajectory(BB_traj71.end())
            .lineToSplineHeading(new Pose2d(-17, -9, Math.toRadians(90)))
            .build();
    public static Trajectory BB_traj73 = BuildTrajectory(BB_traj71.end())
            .lineToSplineHeading(new Pose2d(12, -10, Math.toRadians(90)))
            .build();
    //align to goal for the second time
    public static Trajectory BB_traj9 = BuildTrajectory(BB_traj73.end())
            .lineToSplineHeading(new Pose2d(16, -5, Math.toRadians(180)))
            .build();

    //park
    public static Trajectory BB_traj10 = BuildTrajectory(BB_traj9.end())
            .lineToSplineHeading(new Pose2d(-5, -13,  Math.toRadians(180)))
            .build();
    public static Trajectory BB_traj11 = BuildTrajectory(BB_traj10.end())
            .lineToSplineHeading(new Pose2d(-25, -36, Math.toRadians(0)))
            .build();

    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }
}

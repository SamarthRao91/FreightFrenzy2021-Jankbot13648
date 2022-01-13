package org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_ANG_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_SLOW_ACCEL;
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

public class Red_Bottom_Path {

    public static Trajectory RB_traj1 = BuildTrajectory(new Pose2d(0, 0, Math.toRadians(180)))
            .lineTo(new Vector2d(12, 1))
            .build();

    //brings the robot close to the duck wheel (TUNE THIS POSITION CAREFULLY)
    public static Trajectory RB_traj2 = BuildTrajectory(RB_traj1.end())
            .lineTo(new Vector2d(-12.5, 6), MecanumDrive.getVelocityConstraint(25, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_SLOW_ACCEL))
            .build();

    //prepares robot for intaking
    public static Trajectory RB_traj3 = BuildTrajectory(RB_traj2.end())
            .lineToSplineHeading(new Pose2d(-12.5, 12, Math.toRadians(-90)))
            .build();





    //strafes up to intake
    public static Trajectory RB_traj4 = BuildTrajectory(RB_traj3.end())
            .lineToSplineHeading(new Pose2d(12, 12, Math.toRadians(-90)))
            .build();

    //drives forwards for second intake pass
    public static Trajectory RB_traj5 = BuildTrajectory(RB_traj4.end())
            .lineToSplineHeading(new Pose2d(12, 9.5, Math.toRadians(-90)))
            .build();

    //strafes down for second intake pass
    public static Trajectory RB_traj6 = BuildTrajectory(RB_traj5.end())
            .lineToSplineHeading(new Pose2d(-20.5, 9.5, Math.toRadians(-90)))
            .build();

    public static Trajectory RB_traj61 = BuildTrajectory(RB_traj6.end())
            .lineToSplineHeading(new Pose2d(-18, 6, Math.toRadians(-90)))
            .build();

    public static Trajectory RB_traj62 = BuildTrajectory(RB_traj61.end())
            .lineToSplineHeading(new Pose2d(12, 6, Math.toRadians(-90)))
            .build();

    //strafes down for second intake pass
    public static Trajectory RB_traj7 = BuildTrajectory(RB_traj6.end())
            .lineToSplineHeading(new Pose2d(-20, 14, Math.toRadians(-90)))
            .build();

    //align to goal for the second time
    public static Trajectory RB_traj8 = BuildTrajectory(RB_traj62.end())
            .lineToSplineHeading(new Pose2d(15, 4, Math.toRadians(180)))
            .build();

    //park
    public static Trajectory RB_traj9 = BuildTrajectory(RB_traj8.end())
            .lineToSplineHeading(new Pose2d(-5, 18, Math.toRadians(0)))
            .build();
    public static Trajectory RB_traj10 = BuildTrajectory(RB_traj9.end())
            .lineTo(new Vector2d(-20, 32))
            .build();


    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }

}

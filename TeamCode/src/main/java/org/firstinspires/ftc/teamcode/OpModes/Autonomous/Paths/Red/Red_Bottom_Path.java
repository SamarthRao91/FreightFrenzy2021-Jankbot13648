package org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ANG_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_VEL;
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

    public static Trajectory RB_traj1 = BuildTrajectory(new Pose2d(0,0, Math.toRadians(180)))
            .lineTo(new Vector2d(20, 26),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //brings the robot close to the duck wheel (TUNE THIS POSITION CAREFULLY)
    public static Trajectory RB_traj2 = BuildTrajectory(RB_traj1.end())
            .lineTo(new Vector2d(-8.5, 8),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //prepares robot for intaking
    public static Trajectory RB_traj3 = BuildTrajectory(RB_traj2.end())
            .lineToSplineHeading(new Pose2d(-8, 16, Math.toRadians(-90)),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //strafes up to intake
    public static Trajectory RB_traj4 = BuildTrajectory(RB_traj3.end())
            .lineToSplineHeading(new Pose2d(12, 16, Math.toRadians(-90)),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //drives forwards for second intake pass
    public static Trajectory RB_traj5 = BuildTrajectory(RB_traj4.end())
            .lineToSplineHeading(new Pose2d(12, 11.5, Math.toRadians(-90)),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //strafes down for second intake pass
    public static Trajectory RB_traj6 = BuildTrajectory(RB_traj5.end())
            .lineToSplineHeading(new Pose2d(-20, 11.5, Math.toRadians(-90)),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //strafes down for second intake pass
    public static Trajectory RB_traj7 = BuildTrajectory(RB_traj6.end())
            .lineToSplineHeading(new Pose2d(-20, 14, Math.toRadians(-90)),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //align to goal for the second time
    public static Trajectory RB_traj8 = BuildTrajectory(RB_traj7.end())
            .lineToSplineHeading(new Pose2d(19, 24, Math.toRadians(180)),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    //park
    public static Trajectory RB_traj9 = BuildTrajectory(RB_traj8.end())
            .lineTo(new Vector2d(-22, 38),
                    MecanumDrive.getVelocityConstraint(MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(MAX_ACCEL))
            .build();

    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(MAX_ANG_VEL),
                new MecanumVelocityConstraint(MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(MAX_ACCEL));
    }

}
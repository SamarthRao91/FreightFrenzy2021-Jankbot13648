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

public class Blue_Bottom_Path {
    public static Trajectory BB_traj1 = BuildTrajectory(new Pose2d(0,0, Math.toRadians(180)))
            .lineTo(new Vector2d(23, -21),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    //brings the robot close to the duck wheel (TUNE THIS POSITION CAREFULLY)
    public static Trajectory BB_traj2 = BuildTrajectory(BB_traj1.end())
            .lineToSplineHeading(new Pose2d(-20.5, -14.5, Math.toRadians(90)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    //prepares robot for intaking
    public static Trajectory BB_traj3 = BuildTrajectory(BB_traj2.end())
            .lineToSplineHeading(new Pose2d(-10.5, -18, Math.toRadians(90)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    //strafes up to intake
    public static Trajectory BB_traj4 = BuildTrajectory(BB_traj3.end())
            .lineToSplineHeading(new Pose2d(12, -18, Math.toRadians(90)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    //drives forwards for second intake pass
    public static Trajectory BB_traj5 = BuildTrajectory(BB_traj4.end())
            .lineToSplineHeading(new Pose2d(12, -15.5, Math.toRadians(90)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    //strafes down for second intake pass
    public static Trajectory BB_traj6 = BuildTrajectory(BB_traj5.end())
            .lineToSplineHeading(new Pose2d(-8, -13.5, Math.toRadians(90)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();
    //grabs duck under wheel
    public static Trajectory BB_traj7 = BuildTrajectory(BB_traj6.end())
            .lineToSplineHeading(new Pose2d(-16, -12.5, Math.toRadians(135)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    //backs up
   /* public static Trajectory BB_traj8 = BuildTrajectory(BB_traj7.end())
            .lineToSplineHeading(new Pose2d(-20, -16, Math.toRadians(90)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();
*/
    //align to goal for the second time
    public static Trajectory BB_traj9 = BuildTrajectory(BB_traj6.end())
            .lineToSplineHeading(new Pose2d(23, -26, Math.toRadians(180)),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    //park
    public static Trajectory BB_traj10 = BuildTrajectory(BB_traj9.end())
            .lineTo(new Vector2d(-22, -38),
                    MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, Math.toRadians(60), TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    private static TrajectoryBuilder BuildTrajectory(Pose2d startPose) {
        return new TrajectoryBuilder(startPose, new MinVelocityConstraint(Arrays.asList(
                new AngularVelocityConstraint(AUTO_MAX_ANG_VEL),
                new MecanumVelocityConstraint(AUTO_MAX_VEL, TRACK_WIDTH)
        )), new ProfileAccelerationConstraint(AUTO_MAX_ACCEL));
    }
}

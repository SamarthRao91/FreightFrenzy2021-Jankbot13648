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

    public static Trajectory RT_traj1 = BuildTrajectory(new Pose2d(0, 0, Math.toRadians(0))) //drive into warehouse
            .lineTo(new Vector2d(26, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj2 = BuildTrajectory(RT_traj1.end()) //exit warehouse
            .lineTo(new Vector2d(0, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();
    public static Trajectory RT_traj3 = BuildTrajectory(RT_traj2.end()) //drive into warehouse
            .lineTo(new Vector2d(28, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj4 = BuildTrajectory(RT_traj3.end()) //exit warehouse
            .lineTo(new Vector2d(0, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj5 = BuildTrajectory(RT_traj4.end()) //drive into warehouse
            .lineTo(new Vector2d(30, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj6 = BuildTrajectory(RT_traj5.end()) //exit warehouse
            .lineTo(new Vector2d(0, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();
    public static Trajectory RT_traj7 = BuildTrajectory(RT_traj6.end()) //drive into warehouse
            .lineTo(new Vector2d(32, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj8 = BuildTrajectory(RT_traj7.end()) //exit warehouse
            .lineTo(new Vector2d(0, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj9 = BuildTrajectory(RT_traj8.end()) //drive into warehouse
            .lineTo(new Vector2d(34, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();
    public static Trajectory RT_traj10 = BuildTrajectory(RT_traj9.end()) //exit warehouse
            .lineTo(new Vector2d(0, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj11 = BuildTrajectory(RT_traj10.end()) //drive into warehouse
            .lineTo(new Vector2d(36, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();
    public static Trajectory RT_traj12 = BuildTrajectory(RT_traj11.end()) //exit warehouse
            .lineTo(new Vector2d(0, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_MAX_ACCEL))
            .build();

    public static Trajectory RT_traj13 = BuildTrajectory(RT_traj12.end()) //drive into warehouse
            .lineTo(new Vector2d(32, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
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

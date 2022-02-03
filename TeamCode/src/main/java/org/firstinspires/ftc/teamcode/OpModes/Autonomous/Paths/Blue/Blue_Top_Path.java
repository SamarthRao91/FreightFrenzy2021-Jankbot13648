package org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Blue;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_ANG_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_MAX_VEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_SLOW_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.AUTO_VERY_SLOW_ACCEL;
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

    static double step = 3.75; //slight offsets per cycle to counteract drift
    static double intakestep = 2.25 + step; //drives bot furhter in each time
    static double wallstep = .375;

    public static Trajectory BT_traj0 = BuildTrajectory(new Pose2d(9, .25, Math.toRadians(0))) //drive into warehouse
            .lineTo(new Vector2d(-3, 0), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();
    public static Trajectory BT_traj1 = BuildTrajectory(BT_traj0.end()) //drive into warehouse
            .lineTo(new Vector2d(41, 1*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();

    public static Trajectory BT_traj2 = BuildTrajectory(BT_traj1.end()) //exit warehouse
            .lineTo(new Vector2d(-4, 2*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();
    public static Trajectory BT_traj3 = BuildTrajectory(BT_traj2.end()) //drive into warehouse
            .lineTo(new Vector2d(41 + intakestep, 3*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();

    public static Trajectory BT_traj4 = BuildTrajectory(BT_traj3.end()) //exit warehouse
            .lineTo(new Vector2d(-4 + step, 4*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();

    public static Trajectory BT_traj5 = BuildTrajectory(BT_traj4.end()) //drive into warehouse
            .lineTo(new Vector2d(41 + 2*intakestep, 5*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();

    public static Trajectory BT_traj6 = BuildTrajectory(BT_traj5.end()) //exit warehouse
            .lineTo(new Vector2d(-4 +2*step, 6*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();
    public static Trajectory BT_traj7 = BuildTrajectory(BT_traj6.end()) //drive into warehouse
            .lineTo(new Vector2d(41 + 3*intakestep, 7*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();

    public static Trajectory BT_traj8 = BuildTrajectory(BT_traj7.end()) //exit warehouse
            .lineTo(new Vector2d(-4 +3*step, 8*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();

    public static Trajectory BT_traj9 = BuildTrajectory(BT_traj8.end()) //drive into warehouse
            .lineTo(new Vector2d(41 + 4*intakestep, 9*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();
    public static Trajectory BT_traj10 = BuildTrajectory(BT_traj9.end()) //exit warehouse
            .lineTo(new Vector2d(-4 +4*step, 10*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();

    public static Trajectory BT_traj11 = BuildTrajectory(BT_traj10.end()) //drive into warehouse
            .lineTo(new Vector2d(41 + 5*intakestep, 11*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();
    public static Trajectory BT_traj12 = BuildTrajectory(BT_traj11.end()) //exit warehouse
            .lineTo(new Vector2d(-4 +5*step, 12*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))
            .build();

    public static Trajectory BT_traj13 = BuildTrajectory(BT_traj12.end()) //drive into warehouse
            .lineTo(new Vector2d(41 + 5*intakestep, 13*wallstep), MecanumDrive.getVelocityConstraint(AUTO_MAX_VEL, AUTO_MAX_ANG_VEL, TRACK_WIDTH),
                    MecanumDrive.getAccelerationConstraint(AUTO_VERY_SLOW_ACCEL))

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

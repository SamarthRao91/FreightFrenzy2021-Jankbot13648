package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ANG_ACCEL;
import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.MAX_ANG_VEL;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.localization.Localizer;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.technototes.library.subsystem.Subsystem;
import com.technototes.path.subsystem.MecanumDrivebaseSubsystem;

import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

import java.util.List;
//TODO this is wrong
public class Drive extends MecanumDrivebaseSubsystem {

    private final MecanumDrive drive;
    private final boolean fieldCentric;

    public Drive(MecanumDrive drive, boolean isFieldCentric) {
        this.drive = drive;
        fieldCentric = isFieldCentric;
    }

    public void setMode(DcMotor.RunMode mode) {
        drive.setMode(mode);
    }

    public void setPIDFCoefficients(DcMotor.RunMode mode, PIDFCoefficients coefficients) {
        drive.setPIDFCoefficients(mode, coefficients);
    }

    public void setPoseEstimate(Pose2d pose) {
        drive.setPoseEstimate(pose);
    }

    public void update() {
        drive.update();
    }

    public void updatePoseEstimate() {
        drive.updatePoseEstimate();
    }

    public void drive(double leftY, double leftX, double rightX) {

        Vector2d input = new Vector2d(-leftY, -leftX).rotated(
                fieldCentric ? -getHeading() : 0
        );

        drive.setWeightedDrivePower(
                new Pose2d(
                        input.getX(),
                        input.getY(),
                        -rightX
                )
        );
    }

    public double getHeading()
    {
        return drive.getRawExternalHeading();
    }

    public void setDrivePower(Pose2d drivePower) {
        drive.setDrivePower(drivePower);
    }

    public Pose2d getPoseEstimate() {
        return drive.getPoseEstimate();
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose) {
        return drive.trajectoryBuilder(startPose);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose, boolean reversed) {
        return drive.trajectoryBuilder(startPose, reversed);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose, double startHeading) {
        return drive.trajectoryBuilder(startPose, startHeading);
    }

    public TrajectorySequenceBuilder trajectorySequenceBuilder(Pose2d startPose) {
        return drive.trajectorySequenceBuilder(startPose);
    }

    public void followTrajectory(Trajectory trajectory) {
        drive.followTrajectoryAsync(trajectory);
    }

    public void followTrajectorySequence(TrajectorySequence trajectorySequence)
    {
        drive.followTrajectorySequence(trajectorySequence);
    }

    public boolean isBusy() {
        return drive.isBusy();
    }

    public void turn(double radians) {
        drive.turnAsync(radians);
    }

    public List<Double> getWheelVelocities() {
        return drive.getWheelVelocities();
    }

    public void stop() {
        drive(0, 0, 0);
    }

    public Pose2d getPoseVelocity() {
        return drive.getPoseVelocity();
    }

    public Localizer getLocalizer() {
        return drive.getLocalizer();
    }

    public void resetHeading()
    {
        drive.resetHeading();
    }

    public double getLeftDistance()
    {
        return drive.getLeftDistance();
    }

    public double getRightDistance()
    {
        return drive.getRightDistance();
    }
}

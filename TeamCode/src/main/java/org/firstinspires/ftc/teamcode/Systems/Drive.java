package org.firstinspires.ftc.teamcode.Systems;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

public class Drive extends SubsystemBase {

    private final MecanumDrive mecanumDrive;
    private final boolean fieldCentric;

    public Drive(MecanumDrive mecanumDrive, boolean isFieldCentric) {
        this.mecanumDrive = mecanumDrive;
        fieldCentric = isFieldCentric;
    }

    public void setMode(DcMotor.RunMode mode) {
        mecanumDrive.setMode(mode);
    }

    public void setPoseEstimate(Pose2d pose) {
        mecanumDrive.setPoseEstimate(pose);
    }

    public void update() {
        mecanumDrive.update();
    }

    public void drive(double leftY, double leftX, double rightX) {

        Vector2d input = new Vector2d(-leftY, -leftX).rotated(
                fieldCentric ? -getHeading() : 0
        );

        mecanumDrive.setWeightedDrivePower(
                new Pose2d(
                        input.getX(),
                        input.getY(),
                        -rightX
                )
        );
    }

    public double getHeading()
    {
        return mecanumDrive.getRawExternalHeading();
    }

    public Pose2d getPoseEstimate() {
        return mecanumDrive.getPoseEstimate();
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose) {
        return mecanumDrive.trajectoryBuilder(startPose);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose, boolean reversed) {
        return mecanumDrive.trajectoryBuilder(startPose, reversed);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose, double startHeading) {
        return mecanumDrive.trajectoryBuilder(startPose, startHeading);
    }

    public TrajectorySequenceBuilder trajectorySequenceBuilder(Pose2d startPose) {
        return mecanumDrive.trajectorySequenceBuilder(startPose);
    }

    public void followTrajectory(Trajectory trajectory) {
        mecanumDrive.followTrajectoryAsync(trajectory);
    }

    public void followTrajectorySequence(TrajectorySequence trajectorySequence)
    {
        mecanumDrive.followTrajectorySequence(trajectorySequence);
    }

    public boolean isBusy() {
        return mecanumDrive.isBusy();
    }

    public void turn(double radians) {
        mecanumDrive.turnAsync(radians);
    }

    public void stop() {
        drive(0, 0, 0);
    }

    public void resetHeading()
    {
        mecanumDrive.resetHeading();
    }

    public void setHeadingOffset(double newValue)
    {
        mecanumDrive.setHeadingOffset(newValue);
    }

    public double getLeftDistance()
    {
        return mecanumDrive.getLeftDistance();
    }

    public double getRightDistance()
    {
        return mecanumDrive.getRightDistance();
    }
}

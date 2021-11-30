package org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.Drive;

public class ReLocalizeDriveBase extends CommandBase {

    private final Drive drive;
    private final boolean runOnRed;
    private double distance;

    public ReLocalizeDriveBase(Drive drive, boolean runOnRed) {
        this.drive = drive;
        this.runOnRed = runOnRed;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        if (runOnRed) {
            distance = drive.getRightDistance();
        } else {
            distance = drive.getLeftDistance();
        }
    }

    @Override
    public void end(boolean isInterrupted) {

        Pose2d newPose = new Pose2d(
                drive.getPoseEstimate().getX(),
                distance - (2.6 - (3.0/16.0)) + 0.25,
                drive.getHeading());

        FtcDashboard.getInstance().getTelemetry().addData("New Pose", newPose.toString());
        FtcDashboard.getInstance().getTelemetry().update();

        drive.setPoseEstimate(newPose);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
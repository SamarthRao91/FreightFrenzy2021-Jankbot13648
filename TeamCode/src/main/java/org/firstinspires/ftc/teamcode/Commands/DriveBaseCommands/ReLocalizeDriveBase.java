package org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Util.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class ReLocalizeDriveBase extends CommandBase {

    Drive drive;
    StopWatch stopWatch;

    boolean runOnRed;

    private final List<Double> readings;

    public ReLocalizeDriveBase(Drive drive, long secondsToRun, boolean runOnRed)
    {
        this.drive = drive;
        this.stopWatch = new StopWatch(secondsToRun);
        this.runOnRed = runOnRed;

        this.readings = new ArrayList<Double>();

        addRequirements(drive);
    }

    @Override
    public void execute()
    {
        readings.add(runOnRed ? drive.getLeftDistance() : drive.getRightDistance());
    }

    @Override
    public void end(boolean isInterrupted)
    {
        FtcDashboard.getInstance().getTelemetry().addData("new y", averageArrayList(readings));
        FtcDashboard.getInstance().getTelemetry().addData("read 1", readings.get(0));
        FtcDashboard.getInstance().getTelemetry().addData("size", readings.size());
        /*FtcDashboard.getInstance().getTelemetry().addData("read 2", readings.get(1));
        FtcDashboard.getInstance().getTelemetry().addData("read 3", readings.get(2));
        FtcDashboard.getInstance().getTelemetry().addData("read 4", readings.get(3));
        FtcDashboard.getInstance().getTelemetry().addData("read 5", readings.get(4));*/
        FtcDashboard.getInstance().getTelemetry().update();

        if(!runOnRed)
        {
            drive.setPoseEstimate(new Pose2d(
                    drive.getPoseEstimate().getX(),
                    averageArrayList(readings) - 2.6 - (3.0/16.0),
                    0));
        }
        else {
            drive.setPoseEstimate(new Pose2d(
                    drive.getPoseEstimate().getX(),
                    -averageArrayList(readings) - 2.6 - (3.0/16.0),
                    0)
            );
        }
    }

    @Override
    public boolean isFinished()
    {
        return stopWatch.isExpired();
    }

    private double averageArrayList(List<Double> al)
    {
        double result = 0;

        for(double reading: al)
        {
            result += reading;
        }

        return result / al.size();
    }
}

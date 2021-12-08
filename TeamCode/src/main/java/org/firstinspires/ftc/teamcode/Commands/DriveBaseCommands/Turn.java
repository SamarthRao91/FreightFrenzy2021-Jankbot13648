package org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands;

import com.technototes.library.command.Command;

import org.firstinspires.ftc.teamcode.Systems.Drive;

public class Turn implements Command {

    private final Drive drive;
    private final double angle;

    public Turn(Drive drive, double angle) {
        this.drive = drive;
        this.angle = angle;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.turn(angle);
    }

    @Override
    public void execute() {
        drive.update();
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            drive.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return Thread.currentThread().isInterrupted() || !drive.isBusy();
    }

}

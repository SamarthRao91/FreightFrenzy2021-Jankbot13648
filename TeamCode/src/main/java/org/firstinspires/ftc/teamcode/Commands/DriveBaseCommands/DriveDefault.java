package org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands;

import com.technototes.library.command.Command;

import org.firstinspires.ftc.teamcode.Systems.Drive;

import java.util.function.DoubleSupplier;

public class DriveDefault implements Command {

    private final Drive drive;
    private final DoubleSupplier leftY, leftX, rightX;

    public DriveDefault(Drive drive, DoubleSupplier leftY, DoubleSupplier leftX, DoubleSupplier rightX) {
        this.drive = drive;
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;

        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.drive(leftY.getAsDouble(), leftX.getAsDouble(), rightX.getAsDouble());
    }

}

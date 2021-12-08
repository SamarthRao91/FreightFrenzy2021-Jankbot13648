package org.firstinspires.ftc.teamcode.Commands.CapstoneGrabberCommands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.CapstoneGrabber;

import java.util.function.BooleanSupplier;

public class CapstoneGrabberDefault extends CommandBase {

    final CapstoneGrabber capstoneGrabber;

    public CapstoneGrabberDefault(CapstoneGrabber capstoneGrabber)
    {
        this.capstoneGrabber = capstoneGrabber;

        addRequirements(capstoneGrabber);
    }

    @Override
    public void execute() {
        capstoneGrabber.setCapstonePosition(Constants.CapstoneGrabber.CAPSTONE_GRABBER_POSITIONS[capstoneGrabber.positionIndex]);
    }
}

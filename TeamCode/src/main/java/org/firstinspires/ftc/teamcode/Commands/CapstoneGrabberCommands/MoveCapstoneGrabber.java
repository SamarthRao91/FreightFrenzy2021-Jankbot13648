package org.firstinspires.ftc.teamcode.Commands.CapstoneGrabberCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.CapstoneGrabber;

public class MoveCapstoneGrabber extends CommandBase {

    final CapstoneGrabber capstoneGrabber;

    public MoveCapstoneGrabber(CapstoneGrabber capstoneGrabber)
    {
        this.capstoneGrabber = capstoneGrabber;

        addRequirements(capstoneGrabber);
    }

    @Override
    public void initialize() {
        if(capstoneGrabber.positionIndex >= Constants.CapstoneGrabber.CAPSTONE_GRABBER_POSITIONS.length - 1)
        {
            capstoneGrabber.positionIndex = 0;
        }

        else {
            capstoneGrabber.positionIndex++;
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

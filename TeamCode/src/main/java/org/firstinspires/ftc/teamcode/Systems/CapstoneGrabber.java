package org.firstinspires.ftc.teamcode.Systems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class CapstoneGrabber extends SubsystemBase
{
    private Servo capstoneGrabber;

    public int positionIndex = 0;

    public CapstoneGrabber(HardwareMap hardwareMap)
    {
        capstoneGrabber = hardwareMap.get(Servo.class, Constants.CapstoneGrabber.CAPSTONE_GRABBER_NAME);
    }

    public void setCapstonePosition(double newPos)
    {
        capstoneGrabber.setPosition(newPos);
    }
}

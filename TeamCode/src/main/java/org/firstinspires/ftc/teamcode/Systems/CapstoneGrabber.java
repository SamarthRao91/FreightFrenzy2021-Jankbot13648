package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class CapstoneGrabber
{
    private Servo capstoneGrabber;

    public CapstoneGrabber(HardwareMap hardwareMap)
    {
        capstoneGrabber = hardwareMap.get(Servo.class, Constants.CapstoneGrabber.CAPSTONE_GRABBER_NAME);
    }
    public void setCapstonePosition(double newPos)
    {
        capstoneGrabber.setPosition(newPos);
    }
}

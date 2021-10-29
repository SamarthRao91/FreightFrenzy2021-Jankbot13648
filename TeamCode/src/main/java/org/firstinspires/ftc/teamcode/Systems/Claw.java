package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class Claw {
    public Servo claw;

    public Claw(HardwareMap hardwareMap)
    {
        claw = hardwareMap.get(Servo.class, Constants.CLAW_SERVO_NAME);

    }
    public void setClaw(double position)
    {
        claw.setPosition(position);
    }

}


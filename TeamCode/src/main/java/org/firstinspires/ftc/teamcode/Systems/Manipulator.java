package org.firstinspires.ftc.teamcode.Systems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class Manipulator extends SubsystemBase {

    public DcMotorEx turret;
    public Servo arm1;
    public Servo arm2;
    public Servo claw;
    public Servo pusher;

    public Manipulator(HardwareMap hardwareMap) {
        turret = hardwareMap.get(DcMotorEx.class, Constants.Manipulator.Turret.TURRET_SERVO_NAME);
        arm1 = hardwareMap.get(Servo.class, Constants.Manipulator.Arm.ARM1_NAME);
        arm2 = hardwareMap.get(Servo.class, Constants.Manipulator.Arm.ARM2_NAME);
        claw = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.CLAW_SERVO_NAME);
        pusher = hardwareMap.get(Servo.class, Constants.Manipulator.Claw.PUSHER_SERVO);
    }

    public void setArm(double newPos)
    {
        arm1.setPosition(newPos);
        arm2.setPosition(1-newPos);
    }

    public void moveArm(double amount)
    {
        if(amount != 0)
        {
            if(amount + getArm1Position() > Constants.Manipulator.Arm.ARM1_UPPER_BOUND)
            {
                setArm(Constants.Manipulator.Arm.ARM1_UPPER_BOUND);
            }

            else
                setArm(Math.max(amount + getArm1Position(), Constants.Manipulator.Arm.ARM1_LOWER_BOUND));
        }
    }

    public double getArm1Position()
    {
        return arm1.getPosition();
    }
}

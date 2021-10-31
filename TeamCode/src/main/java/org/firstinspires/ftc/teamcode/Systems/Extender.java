package org.firstinspires.ftc.teamcode.Systems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;

public class Extender {
    public Servo extender;


    public Extender(HardwareMap hardwareMap)
    {
        extender = hardwareMap.get(Servo.class, Constants.EXTENDER_SERVO_NAME);

    }
    public void setExtenderPosition(double position)
    {
        if(Constants.elevator_postion < Constants.elevator_safepos && Constants.turret_position <
                Constants.turret_right_safepos && Constants.turret_position > Constants.turret_left_safepos)
        {
           return;
        }
        if(position > Constants.ex_maxpos)
        {
            extender.setPosition(Constants.ex_maxpos);
            Constants.ex_position = Constants.ex_maxpos;
        }
        else if(position< Constants.ex_minpos)
        {
            extender.setPosition(Constants.ex_minpos);
            Constants.ex_position = Constants.ex_minpos;
        }
        extender.setPosition(position);
        Constants.ex_position = position;
    }
    public void extenderMove(double ammount)
    {
        double newpos = Constants.ex_position + ammount;
        extender.setPosition(newpos);
        Constants.ex_position = newpos;
    }
    public double getPosition()
    {
        return extender.getPosition();
    }

}


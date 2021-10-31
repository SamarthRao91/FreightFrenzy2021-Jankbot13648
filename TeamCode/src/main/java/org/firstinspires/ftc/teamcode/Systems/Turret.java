package org.firstinspires.ftc.teamcode.Systems;



import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class Turret {
    public Servo turret;

    public Turret (HardwareMap hardwareMap)
    {
        turret = hardwareMap.get(Servo.class, Constants.TURRET_SERVO_NAME);

    }
    public void turretPresets(double position)
    {
        if(Constants.elevator_postion < Constants.elevator_minimumsafepos && (position == Constants.turret_zeropos)
         || (Constants.ex_position > 0 || Constants.elevator_safepos < Constants.elevator_minimumsafepos) &&
                Constants.elevator_postion < Constants.elevator_safepos && ((position > Constants.turret_right_safepos &&
                Constants.turret_position < Constants.turret_right_safepos) || (position < Constants.turret_left_safepos &&
                Constants.turret_position > Constants.turret_right_safepos )))
        {
            return;
        }
        if(position > Constants.turret_right_safepos)
        {
            turret.setPosition(Constants.turret_right_safepos);
            Constants.turret_position = Constants.turret_right_safepos;
        }
        else if(position< Constants.turret_left_safepos)
        {
            turret.setPosition(Constants.turret_left_safepos);
            Constants.turret_position = Constants.turret_left_safepos;
        }
        turret.setPosition(position);
        Constants.turret_position = turret.getPosition();

    }

    public void moveTurret(double ammount)
    {
        double newpos = Constants.turret_position + ammount;
        turret.setPosition(newpos);
        Constants.turret_position = turret.getPosition();
    }
    public double getPosition()
    {
       return turret.getPosition();
    }
}


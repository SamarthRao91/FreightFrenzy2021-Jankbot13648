package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Constants;

public class Elevator {

        DcMotorEx elevatorMotor;



        public Elevator(HardwareMap hardwareMap)
        {
            elevatorMotor = hardwareMap.get(DcMotorEx.class, Constants.ELEVATOR_MOTOR_NAME);
            elevatorMotor.setDirection(DcMotorEx.Direction.REVERSE);
            elevatorMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            elevatorMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
            elevatorMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        }

        public static void elevatorUp(double speed)
        {

        }

}


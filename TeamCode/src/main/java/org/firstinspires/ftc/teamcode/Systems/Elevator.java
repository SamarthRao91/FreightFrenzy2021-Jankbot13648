package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

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

        public void toPosition(int position)
        {
            elevatorMotor.setTargetPosition(position);
            elevatorMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            while (elevatorMotor.isBusy());
            elevatorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        public void setSpeed(double speed)
        {
            elevatorMotor.setPower(speed);
        }
}


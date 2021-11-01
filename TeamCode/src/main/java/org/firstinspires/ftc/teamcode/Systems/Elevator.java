package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.Elevator.*;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Elevator {

        private DcMotorEx elevatorMotor;

        public Elevator(HardwareMap hardwareMap)
        {
            elevatorMotor = hardwareMap.get(DcMotorEx.class, ELEVATOR_MOTOR_NAME);
            elevatorMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            elevatorMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
            elevatorMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        }

        public void setPosition(int position)
        {
            elevatorMotor.setTargetPosition(position);
            elevatorMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            elevatorMotor.setPower(0.5);

            while(elevatorMotor.isBusy());

            elevatorMotor.setPower(0);
            elevatorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        public void setSpeed(double speed)
        {
            elevatorMotor.setPower(speed);
        }

        public int getPosition()
        {
            return elevatorMotor.getCurrentPosition();
        }
}


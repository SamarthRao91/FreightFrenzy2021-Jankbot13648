package org.firstinspires.ftc.teamcode.Systems;


import static org.firstinspires.ftc.teamcode.Constants.Elevator.ELEVATOR_MOTOR_NAME;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants;

public class Elevator {
    private DcMotorEx elevatorMotor;
    DigitalChannel ls;

    public Elevator(HardwareMap hardwareMap) {
        elevatorMotor = hardwareMap.get(DcMotorEx.class, ELEVATOR_MOTOR_NAME);
        ls = hardwareMap.get(DigitalChannel.class, Constants.Elevator.LIMIT_SWITCH_NAME);
        elevatorMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        elevatorMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        elevatorMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void setPosition(int position) {
        elevatorMotor.setTargetPosition(position);
        elevatorMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevatorMotor.setPower(1);

        while (elevatorMotor.isBusy() && !Thread.currentThread().isInterrupted());

        elevatorMotor.setPower(0);
        elevatorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void resetElevator()
    {
        elevatorMotor.setPower(-1);
        while(!Thread.currentThread().isInterrupted() && isLimitPressed());
        elevatorMotor.setPower(0);
    }

    public boolean isLimitPressed() {
        return !ls.getState();
    }

    public void setSpeed(double speed) {
        elevatorMotor.setPower(speed);
    }

    public int getPosition() {
        return elevatorMotor.getCurrentPosition();
    }

    public DcMotorEx getElevatorMotor() {
        return elevatorMotor;
    }
}


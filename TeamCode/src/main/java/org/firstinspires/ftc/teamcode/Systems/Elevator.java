package org.firstinspires.ftc.teamcode.Systems;

import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Constants;

public class Elevator {

        DcMotorEx elevatorMotor;

        PIDFController positionController;

        public Elevator(HardwareMap hardwareMap)
        {
            positionController = new PIDFController(
                    new PIDCoefficients(
                            Constants.elevator_pcoeff,
                            Constants.elevator_icoeff,
                            Constants.elevator_dcoeff
                    )
            );

            elevatorMotor = hardwareMap.get(DcMotorEx.class, Constants.ELEVATOR_MOTOR_NAME);
            elevatorMotor.setDirection(DcMotorEx.Direction.REVERSE);
            elevatorMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            elevatorMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
            elevatorMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        }

        public void toPosition(int position)
        {
            positionController.setTargetPosition(position);

            while(positionController.getLastError() > Constants.elevator_tolerance)
            {
                elevatorMotor.setPower(positionController.update(elevatorMotor.getCurrentPosition()));
            }

            elevatorMotor.setPower(0);
            Constants.elevator_postion = elevatorMotor.getCurrentPosition();
        }

        public void setSpeed(double speed)
        {
            elevatorMotor.setPower(speed);
            Constants.elevator_postion = elevatorMotor.getCurrentPosition();
        }
        public double getPosition()
        {
            return elevatorMotor.getCurrentPosition();
        }
}


package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.DuckSpinner.*;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DuckSpinner {

    private DcMotorEx spinner;

    public DuckSpinner(HardwareMap hardwareMap) {
        spinner = hardwareMap.get(DcMotorEx.class, DUCK_SPINNER_MOTOR_NAME);
        spinner.setDirection(DcMotorSimple.Direction.FORWARD);
        spinner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void spinSpinner(boolean[] isOpModeActive)
    {
        spinner.setTargetPosition(spinner.getCurrentPosition() + (int) (Math.ceil(6 * 103.6)));
        spinner.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        spinner.setPower(0.25);
        while (!spinner.isBusy() && isOpModeActive[0]);
        spinner.setPower(0);
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        spinner.setTargetPosition(spinner.getCurrentPosition() + (int) (Math.ceil(3 * 103.6)));
        spinner.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        spinner.setPower(1);
        while (!spinner.isBusy() && isOpModeActive[0]);
        spinner.setPower(0);
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}

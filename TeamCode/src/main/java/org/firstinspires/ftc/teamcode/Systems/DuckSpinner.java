package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.DuckSpinner.*;

import com.acmerobotics.dashboard.FtcDashboard;
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

    public void spinSpinner()
    {
        FtcDashboard.getInstance().getTelemetry().addData("Spinner Position", spinner.getCurrentPosition());
        FtcDashboard.getInstance().getTelemetry().update();
        while(spinner.getCurrentPosition() < 1000) {
            if (spinner.getCurrentPosition() >= 675) {
                spinner.setPower(1);
            } else {
                spinner.setPower(0.6);

            }
        }

        spinner.setPower(0);
        spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    public void spinReverseSpinner()
    {
        FtcDashboard.getInstance().getTelemetry().addData("Spinner Position", spinner.getCurrentPosition());
        FtcDashboard.getInstance().getTelemetry().update();
        while(spinner.getCurrentPosition() > -1000) {
            if (spinner.getCurrentPosition() <= -675) {
                spinner.setPower(-1);
            } else {
                spinner.setPower(-0.6);

            }
        }

            spinner.setPower(0);
            spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



    }
    public void stopSpinner()
    {
        spinner.setPower(0);
    }
}



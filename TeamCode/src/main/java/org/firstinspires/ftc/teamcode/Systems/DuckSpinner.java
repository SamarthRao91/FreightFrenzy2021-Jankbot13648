package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.DuckSpinner.DUCK_SPINNER_MOTOR_NAME;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.checkerframework.checker.signedness.qual.Constant;
import org.firstinspires.ftc.teamcode.Constants;

public class DuckSpinner extends SubsystemBase {

    private DcMotorEx spinner;
    private Servo redDuckWall;

    public DuckSpinner(HardwareMap hardwareMap) {
        spinner = hardwareMap.get(DcMotorEx.class, DUCK_SPINNER_MOTOR_NAME);
        spinner.setDirection(DcMotorSimple.Direction.FORWARD);
        spinner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        redDuckWall = hardwareMap.get(Servo.class, Constants.DuckSpinner.RED_WALL_SERVO);
    }

    public void setRedDuckWall(double position)
    {
        redDuckWall.setPosition(position);
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

    public void spinSlow()
    {
        FtcDashboard.getInstance().getTelemetry().addData("Spinner Position", spinner.getCurrentPosition());
        FtcDashboard.getInstance().getTelemetry().update();
        while(spinner.getCurrentPosition() < 1000) {
            if (spinner.getCurrentPosition() >= 675) {
                spinner.setPower(0.7);
            } else {
                spinner.setPower(0.35);

            }
        }

        spinner.setPower(0);
        spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    public void spinReverseSlow()
    {
        FtcDashboard.getInstance().getTelemetry().addData("Spinner Position", spinner.getCurrentPosition());
        FtcDashboard.getInstance().getTelemetry().update();
        while(spinner.getCurrentPosition() > -1000) {
            if (spinner.getCurrentPosition() <= -675) {
                spinner.setPower(-0.35);
            } else {
                spinner.setPower(-0.4);

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
}



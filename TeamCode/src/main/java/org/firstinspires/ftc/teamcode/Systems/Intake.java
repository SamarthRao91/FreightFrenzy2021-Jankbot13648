package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.Intake.*;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class Intake {

    private DcMotorEx intake;
    private Servo intakeDeployer;

    public Intake(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotorEx.class, INTAKE_MOTOR_NAME);
        intake.setDirection(DcMotorEx.Direction.FORWARD);
        intake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        intake.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

       // intakeDeployer = hardwareMap.get(Servo.class, INTAKE_DEPLOYER_SERVO_NAME);
    }

    public void setIntake(double intakeSpeed, double reverseIntakeSpeed) {
        if(reverseIntakeSpeed > 0.3)
        {
            intake.setPower(reverseIntakeSpeed);
        }

        else
        {
            intake.setPower(intakeSpeed);
        }
    }

    public void deployIntake()
    {
        intakeDeployer.setPosition(0.5);
    }
}


package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.Intake.INTAKE_MOTOR_NAME;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends SubsystemBase {

    private Motor intake;

    public Intake(HardwareMap hardwareMap) {
        intake = hardwareMap.get(Motor.class, INTAKE_MOTOR_NAME);
        intake.setInverted(false);
        intake.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intake.setRunMode(Motor.RunMode.RawPower);
    }

    public void setIntake(double intakeSpeed, double reverseSpeed) {
        if(reverseSpeed > 0)
        {
            intake.set(-reverseSpeed);
        }

        else {
            intake.set(intakeSpeed);
        }
    }

    public void setIntake(double speed)
    {
        intake.set(speed);
    }
}


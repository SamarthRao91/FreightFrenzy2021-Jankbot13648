package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.teamcode.Constants.Intake.INTAKE_MOTOR_NAME;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.technototes.library.subsystem.Subsystem;

public class Intake implements Subsystem {

    private Motor intake;

    public Intake(HardwareMap hardwareMap) {
        intake = new Motor(hardwareMap,INTAKE_MOTOR_NAME);
        intake.setInverted(false);
        intake.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intake.setRunMode(Motor.RunMode.RawPower);
    }

    public void setIntake(double intakeSpeed, double reverseSpeed) {
        if (reverseSpeed > 0) {
            intake.set(-reverseSpeed);
        } else {
            intake.set(intakeSpeed);
        }
    }

    public void setIntake(double speed) {
        intake.set(speed);
    }
}


package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class motorWithVeloLimit extends Motor {
    public motorWithVeloLimit(@NonNull HardwareMap hMap, String id) {
        super(hMap, id);
    }

    public void set(double output) {
        if (runmode == RunMode.VelocityControl) {
            double speed = bufferFraction * output * ACHIEVABLE_MAX_TICKS_PER_SECOND;
            double velocity = veloController.calculate(getVelocity(), speed) + feedforward.calculate(speed, encoder.getAcceleration());
            motor.setPower(velocity / ACHIEVABLE_MAX_TICKS_PER_SECOND);
        } else if (runmode == RunMode.PositionControl) {
            double error = positionController.calculate(getDistance());
            if(output >= 0) {
                motor.setPower(Math.min(output * error, output));
            }
            else if (output <=0){
                motor.setPower(Math.max(output * error, output));
            }
            else {
                motor.setPower(output);
            }


        } else {
            motor.setPower(output);
        }
    }
}

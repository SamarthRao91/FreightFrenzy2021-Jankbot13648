package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Systems.*;

@TeleOp(name = "TeleOp-Encoder Check")
public class EncoderCheck extends LinearOpMode {
    //different subsystems
   Elevator elevator;
    @Override
    public void runOpMode() {

        elevator = new Elevator(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive())
        {
            telemetry.addData("Elevator Position" , elevator.getPosition());
            telemetry.update();

            if(gamepad1.x)
            {
                elevator.setPosition(1200);
            }

            if(gamepad1.y) {

                elevator.setSpeed(0.5);
            }
            else{
                elevator.setSpeed(0);
            }
        }
    }
}

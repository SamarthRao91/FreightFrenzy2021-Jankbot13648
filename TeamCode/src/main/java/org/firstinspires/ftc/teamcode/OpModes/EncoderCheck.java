package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.*;

@TeleOp(name = "TeleOp-Encoder Check 3434343434343434343434343434")
public class EncoderCheck extends LinearOpMode {
    //different subsystems
   Elevator elevator;
    Manipulator manipulator;
    @Override
    public void runOpMode() {

        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap, elevator);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive())
        {
            manipulator.setTurretPosition(0.5);

        }
    }
}

package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

@TeleOp(name = "TeleOp-Encoder Check")
public class EncoderCheck extends LinearOpMode {
    //different subsystems
    Elevator elevator;
    Manipulator manipulator;

    @Override
    public void runOpMode() {

        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap, new Elevator[]{elevator});

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive()) {
            manipulator.moveTurretPosition(gamepad1.left_stick_x / 250);
            manipulator.moveExtenderPosition(gamepad1.left_stick_y / 200);
        }
    }
}

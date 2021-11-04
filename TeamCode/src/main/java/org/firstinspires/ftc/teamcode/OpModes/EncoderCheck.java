package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.dashboard.FtcDashboard;
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
        manipulator = new Manipulator(hardwareMap, elevator);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive())
        {
            FtcDashboard.getInstance().getTelemetry().addData("Manipulator Position", manipulator.getTurretPosition());
            FtcDashboard.getInstance().getTelemetry().update();

            manipulator.moveTurretPosition(-gamepad2.left_stick_x/500);
            manipulator.moveExtenderPosition(-gamepad2.left_stick_y/500);
        }
    }
}

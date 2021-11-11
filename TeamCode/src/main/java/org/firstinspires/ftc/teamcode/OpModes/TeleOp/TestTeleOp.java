package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Systems.Elevator;

@TeleOp(name = "Test Tele-Op")
public class TestTeleOp extends LinearOpMode {

    Elevator elevator;

    @Override
    public void runOpMode() {

        elevator = new Elevator(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested())
        {
            FtcDashboard.getInstance().getTelemetry().addData("Elevator Position", elevator.getPosition());
            FtcDashboard.getInstance().getTelemetry().update();

            elevator.setSpeed(-gamepad1.left_stick_y);
        }
    }
}

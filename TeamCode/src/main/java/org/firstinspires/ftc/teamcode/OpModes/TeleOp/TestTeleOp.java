package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Systems.Manipulator;

@TeleOp(name = "Test Tele-Op")
public class TestTeleOp extends LinearOpMode {

    Manipulator manipulator;

    @Override
    public void runOpMode() {

        manipulator = new Manipulator(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested())
        {
            FtcDashboard.getInstance().getTelemetry().addData("DS", manipulator.getDsDistance());
            FtcDashboard.getInstance().getTelemetry().update();
        }
    }
}

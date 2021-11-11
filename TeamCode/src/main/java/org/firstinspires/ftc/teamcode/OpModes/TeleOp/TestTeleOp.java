package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

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

        }
    }
}

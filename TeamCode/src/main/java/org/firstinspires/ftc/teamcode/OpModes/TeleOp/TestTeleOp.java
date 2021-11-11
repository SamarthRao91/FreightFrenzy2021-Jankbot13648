package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Systems.Vision.CapstoneDetectionCamera;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;

@TeleOp(name = "Test Tele-Op")
public class TestTeleOp extends LinearOpMode {

    CapstoneDetectionCamera capstoneDetectionCamera;
    CapstonePipeline.CapstonePosition capstonePosition;

    @Override
    public void runOpMode() {

        capstoneDetectionCamera = new CapstoneDetectionCamera(hardwareMap, true);

        while (!isStarted())
        {
            capstonePosition = capstoneDetectionCamera.getPosition();

            FtcDashboard.getInstance().getTelemetry().addData("Capstone Position", capstonePosition);
            FtcDashboard.getInstance().getTelemetry().addData("Left Analysis", capstoneDetectionCamera.getAnalysis()[0]);
            FtcDashboard.getInstance().getTelemetry().addData("Middle Analysis", capstoneDetectionCamera.getAnalysis()[1]);
            FtcDashboard.getInstance().getTelemetry().addData("Right Analysis", capstoneDetectionCamera.getAnalysis()[2]);
            FtcDashboard.getInstance().getTelemetry().update();
        }
    }
}

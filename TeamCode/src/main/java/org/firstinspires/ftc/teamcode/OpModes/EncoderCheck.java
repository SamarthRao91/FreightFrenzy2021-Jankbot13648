package org.firstinspires.ftc.teamcode.OpModes;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;

import static org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.DriveConstants.*;

import java.util.List;

@TeleOp(name = "Encoder Check")
public class EncoderCheck extends LinearOpMode {

    Telemetry dashboardTelemetry;

    MecanumDrive driveBase;


    @Override
    public void runOpMode() {

        dashboardTelemetry = FtcDashboard.getInstance().getTelemetry();

        driveBase = new MecanumDrive(hardwareMap);


        telemetry.addLine("System Initialization Complete");
        telemetry.update();

        waitForStart();

        telemetry.clearAll();
        telemetry.update();

        List<Double> positions = driveBase.getWheelPositions();
        telemetry.addData("Right front encoder", positions.get(0));
        telemetry.addData("Right back encoder", positions.get(1));
        telemetry.addData("Left front encoder", positions.get(2));
        telemetry.addData("Left back encoder", positions.get(3));
    }
};
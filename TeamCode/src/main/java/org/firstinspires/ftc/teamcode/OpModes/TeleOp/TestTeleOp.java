package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red.RedTopAutoCommand;
import org.firstinspires.ftc.teamcode.Commands.CapstoneGrabberCommands.CapstoneGrabberDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.turrettest;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.CapstoneGrabber;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.CapstoneDetectionCamera;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

@TeleOp(name = "Test Teleop")
public class TestTeleOp extends LinearOpMode {

    Drive drive;
    Manipulator manipulator;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(new MecanumDrive(hardwareMap), true);
        manipulator = new Manipulator(hardwareMap);


        waitForStart();
        while(!isStopRequested()) {

            manipulator.readColorSensor();
            telemetry.addData("Color sensor", manipulator.readColorSensor());
            telemetry.update();

            /*FtcDashboard.getInstance().getTelemetry().addData("Left Distance Sensors", drive.getLeftDistance());
            FtcDashboard.getInstance().getTelemetry().update();*/
        }
    }
}

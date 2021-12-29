package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.DriveDefault;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.ReLocalizeDriveBase;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.CapstoneGrabber;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

//@Disabled
@TeleOp(name = "Test Teleop")
public class TestTeleOp extends LinearOpMode {

    Elevator elevator;

    @Override
    public void runOpMode() {

        elevator = new Elevator(hardwareMap);
        elevator.setRunMode(Motor.RunMode.PositionControl);

        waitForStart();

        while (opModeIsActive() && !isStopRequested())
        {
            telemetry.addData("Elevator Position", elevator.getPosition());
            telemetry.update();
        }

        requestOpModeStop();
    }
}
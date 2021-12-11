package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Subsystem;
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
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

//@Disabled
@Autonomous(name = "Drive Forward")
public class TestTeleOp extends LinearOpMode {

    Drive drive = new Drive(new MecanumDrive(hardwareMap), true);
    CapstoneGrabber capstoneGrabber = new CapstoneGrabber(hardwareMap);

    @Override
    public void runOpMode() {

        Trajectory forward = drive.trajectoryBuilder(new Pose2d(0,0,0)).forward(20).build();

        waitForStart();

        while (opModeIsActive() && !isStopRequested())
        {
            capstoneGrabber.setCapstonePosition(Constants.CapstoneGrabber.CAPSTONE_GRABBER_POSITIONS[0]);
            drive.followTrajectory(forward);

            break;
        }

        requestOpModeStop();
    }
}

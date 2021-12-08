package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.ReLocalizeDriveBase;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.CapstoneGrabber;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

//@Disabled
@TeleOp(name = "Test Tele-Op")
public class TestTeleOp extends LinearOpMode {

    Manipulator manipulator;

    @Override
    public void runOpMode() {

        manipulator = new Manipulator(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested())
        {
            TelemetryPacket packet = new TelemetryPacket();
            packet.put("DS Tripped", manipulator.dsTripped());
            packet.put("DS Distance", manipulator.getDsDistance());

            packet.put("CS Alpha", manipulator.getCSAlpha());
            packet.put("CS Red", manipulator.getCSRed());
            packet.put("CS Green", manipulator.getCSGreen());
            packet.put("CS Blue", manipulator.getCSBlue());

            FtcDashboard.getInstance().sendTelemetryPacket(packet);
        }
    }
}

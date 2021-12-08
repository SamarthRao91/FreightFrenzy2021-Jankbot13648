package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.ReLocalizeDriveBase;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.CapstoneGrabber;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

//@Disabled
@TeleOp(name = "Test Tele-Op")
public class TestTeleOp extends LinearOpMode {

    Drive drive;
    CapstoneGrabber capstoneGrabber;
    Manipulator manipulator;
    @Override
    public void runOpMode() {
        telemetry.addData("turret", manipulator.getTurretPosition());
        telemetry.update();
    }

    public CommandScheduler getCommandScheduler()
    {
        return CommandScheduler.getInstance();
    }


}

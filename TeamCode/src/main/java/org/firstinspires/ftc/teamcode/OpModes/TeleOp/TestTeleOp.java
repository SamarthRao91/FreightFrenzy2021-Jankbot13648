package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.ReLocalizeDriveBase;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;

//@Disabled
@TeleOp(name = "Test Tele-Op")
public class TestTeleOp extends LinearOpMode {

    Drive drive;

    @Override
    public void runOpMode() {

        drive = new Drive(new MecanumDrive(hardwareMap), true);

        register(drive);

        waitForStart();

        while (opModeIsActive() && !isStopRequested())
        {
            schedule(new ReLocalizeDriveBase(drive, true));
        }
    }

    public CommandScheduler getCommandScheduler()
    {
        return CommandScheduler.getInstance();
    }

    public void register(Subsystem... subsystems)
    {
        getCommandScheduler().registerSubsystem(subsystems);
    }

    public void schedule(Command... commands)
    {
        getCommandScheduler().schedule(commands);
    }
}

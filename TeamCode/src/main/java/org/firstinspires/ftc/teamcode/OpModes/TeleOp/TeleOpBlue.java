package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Commands.DriveBase.DriveDefault;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorDefault;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommands.IntakeDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManipulatorDefault;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class TeleOpBlue extends CommandOpMode {
    @Override
    public void initialize() {
        Drive drive = new Drive(new MecanumDrive(hardwareMap), true);
        Elevator elevator = new Elevator(hardwareMap);
        Manipulator manipulator = new Manipulator(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        DuckSpinner duckSpinner = new DuckSpinner(hardwareMap);

        register(drive, elevator, manipulator, intake, duckSpinner);

        drive.setDefaultCommand(new DriveDefault(drive, () -> gamepad1.left_stick_x, () -> gamepad1.left_stick_y, () -> gamepad1.right_stick_x));
        intake.setDefaultCommand(new IntakeDefault(intake, () -> (double) gamepad1.right_trigger, () -> (double) gamepad1.left_trigger));
        elevator.setDefaultCommand(new ElevatorDefault(elevator, () -> gamepad2.left_stick_y));
        manipulator.setDefaultCommand(new ManipulatorDefault(manipulator, elevator, manipulator::dsTripped, () -> gamepad2.left_stick_x, () -> gamepad2.left_stick_y));
    }
}

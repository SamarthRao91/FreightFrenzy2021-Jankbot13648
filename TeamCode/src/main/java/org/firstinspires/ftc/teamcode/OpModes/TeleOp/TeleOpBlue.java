package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.DriveBase.DriveDefault;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorDefault;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommands.IntakeDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManipulatorDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManipulatorToPosition;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetSuperStructure;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

@TeleOp(name = "Tele-Op Blue")
public class TeleOpBlue extends CommandOpMode {
    Drive drive;
    Elevator elevator;
    Manipulator manipulator;
    Intake intake;
    DuckSpinner duckSpinner;

    GamepadEx driveGamepad;
    GamepadEx mechGamepad;

    @Override
    public void initialize() {
        drive = new Drive(new MecanumDrive(hardwareMap), true);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap);
        intake = new Intake(hardwareMap);
        duckSpinner = new DuckSpinner(hardwareMap);

        driveGamepad = new GamepadEx(gamepad1);
        mechGamepad = new GamepadEx(gamepad2);

        register(drive, elevator, manipulator, intake, duckSpinner);

        drive.setDefaultCommand(new DriveDefault(drive, () -> gamepad1.left_stick_x, () -> -gamepad1.left_stick_y, () -> gamepad1.right_stick_x));
        intake.setDefaultCommand(new IntakeDefault(intake, () -> (double) gamepad1.right_trigger, () -> (double) gamepad1.left_trigger));
        elevator.setDefaultCommand(new ElevatorDefault(elevator, () -> gamepad2.right_stick_y));
        manipulator.setDefaultCommand(new ManipulatorDefault(manipulator, manipulator::dsTripped, () -> -gamepad2.left_stick_x, () -> -gamepad2.left_stick_y));

        mechGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(new SequentialCommandGroup(
                new WaitCommand(750),
                new ElevatorToPosition(elevator, Constants.Elevator.SAFE_EXTENDER_POSITION + 200, 0.2),
                new ManipulatorToPosition(manipulator, Constants.Manipulator.Turret.ZERO_POSITION, Constants.Manipulator.Extender.MIN_POS, Constants.Manipulator.Claw.CLOSE_POSITION),
                new WaitCommand(750),
                new ElevatorToPosition(elevator, 0, 0.2),
                new ManipulatorToPosition(manipulator, Constants.Manipulator.Turret.ZERO_POSITION, Constants.Manipulator.Extender.MIN_POS, Constants.Manipulator.Claw.OPEN_POSITION)
        ));
    }
}

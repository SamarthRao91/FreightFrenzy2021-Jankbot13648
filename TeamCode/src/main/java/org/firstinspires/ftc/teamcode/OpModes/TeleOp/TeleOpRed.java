package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.DriveDefault;
import org.firstinspires.ftc.teamcode.Commands.DuckSpinnerCommands.SpinDuckSpinner;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorDefault;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red.RedHighPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red.RedHighReversePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red.RedLowPreset;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommands.IntakeDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManipulatorDefault;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ScoreGamePiece;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

@TeleOp(name = "Tele-Op Red")
public class TeleOpRed extends CommandOpMode {
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

        drive.setDefaultCommand(
                new DriveDefault(
                        drive,
                        () -> driveGamepad.gamepad.left_bumper ? driveGamepad.gamepad.left_stick_y/4 : driveGamepad.gamepad.left_stick_y,
                        () -> driveGamepad.gamepad.left_bumper ? -(driveGamepad.gamepad.left_stick_x/4) : -driveGamepad.gamepad.left_stick_x,
                        () -> driveGamepad.gamepad.left_bumper ? -(driveGamepad.gamepad.right_stick_x/4) : -driveGamepad.gamepad.right_stick_x
                )
        );

        intake.setDefaultCommand(new IntakeDefault(intake, () -> driveGamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER), () -> driveGamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)));
        elevator.setDefaultCommand(new ElevatorDefault(elevator, () -> -mechGamepad.gamepad.right_stick_y));
        manipulator.setDefaultCommand(new ManipulatorDefault(manipulator, manipulator::dsTripped, () -> -mechGamepad.gamepad.left_stick_x, () -> -mechGamepad.gamepad.left_stick_y));

        // Binding ---------------------------------------------------------------------------------

        driveGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(new ResetMechanisms(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(new ResetMechanisms(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(new RedLowPreset(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(new RedLowPreset(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(new RedHighPreset(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(new RedHighPreset(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(new ScoreGamePiece(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(new ScoreGamePiece(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.START).whenPressed(new RedHighReversePreset(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.START).whenPressed(new RedHighReversePreset(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new InstantCommand(() -> drive.resetHeading()));

        mechGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.OPEN_POSITION)));
        mechGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)));
        mechGamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CAPSTONE_OPEN_FULLY)));

        mechGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(new ManualPickup(elevator, manipulator));

        mechGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(new SpinDuckSpinner(duckSpinner, true, 0.6, 1));
    }

}

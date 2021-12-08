package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.CapstoneGrabberCommands.CapstoneGrabberDefault;
import org.firstinspires.ftc.teamcode.Commands.CapstoneGrabberCommands.MoveCapstoneGrabber;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.DriveDefault;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.ElevatorDefault;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Blue.BlueHighPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Blue.BlueHighReversePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Blue.BlueLowPreset;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommands.IntakeDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManipulatorDefault;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms.ResetMechanisms;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ScoreGamePiece;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.CapstoneGrabber;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

@TeleOp(name = "BLUE | Tele-Op", group = "Blue")
public class TeleOpBlue extends CommandOpMode {
    Drive drive;
    Elevator elevator;
    Manipulator manipulator;
    Intake intake;
    DuckSpinner duckSpinner;
    CapstoneGrabber capstoneGrabber;

    GamepadEx driveGamepad;
    GamepadEx mechGamepad;

    @Override
    public void initialize() {
        drive = new Drive(new MecanumDrive(hardwareMap), true);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap);
        intake = new Intake(hardwareMap);
        duckSpinner = new DuckSpinner(hardwareMap);
        capstoneGrabber = new CapstoneGrabber(hardwareMap);

        driveGamepad = new GamepadEx(gamepad1);
        mechGamepad = new GamepadEx(gamepad2);

        register(drive, elevator, manipulator, intake, duckSpinner, capstoneGrabber);

        drive.setHeadingOffset(HeadingStorage.STORED_HEADING);

        drive.setDefaultCommand(
                new DriveDefault(
                        drive,
                        () -> driveGamepad.gamepad.left_bumper ? driveGamepad.gamepad.left_stick_y/4 : driveGamepad.gamepad.left_stick_y,
                        () -> driveGamepad.gamepad.left_bumper ? driveGamepad.gamepad.left_stick_x/4 : driveGamepad.gamepad.left_stick_x,
                        () -> driveGamepad.gamepad.left_bumper ? driveGamepad.gamepad.right_stick_x/4 : driveGamepad.gamepad.right_stick_x
                )
        );

        intake.setDefaultCommand(new IntakeDefault(intake, () -> driveGamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER), () -> driveGamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)));
        elevator.setDefaultCommand(new ElevatorDefault(elevator, () -> -mechGamepad.gamepad.right_stick_y));
        manipulator.setDefaultCommand(new ManipulatorDefault(manipulator, manipulator::dsTripped, () -> -mechGamepad.gamepad.left_stick_x, () -> -mechGamepad.gamepad.left_stick_y));
        capstoneGrabber.setDefaultCommand(new CapstoneGrabberDefault(capstoneGrabber));

        // Binding ---------------------------------------------------------------------------------

        driveGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(new ResetMechanisms(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(new ResetMechanisms(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(new BlueLowPreset(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(new BlueLowPreset(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(new BlueHighPreset(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(new BlueHighPreset(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(new ScoreGamePiece(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(new ScoreGamePiece(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.START).whenPressed(new BlueHighReversePreset(elevator, manipulator));
        mechGamepad.getGamepadButton(GamepadKeys.Button.START).whenPressed(new BlueHighReversePreset(elevator, manipulator));

        driveGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new InstantCommand(() -> drive.resetHeading()));

        mechGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.OPEN_POSITION)));
        mechGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)));
        mechGamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CAPSTONE_OPEN_FULLY)));

        driveGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(new ManualPickup(elevator, manipulator, intake));
        mechGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(new ManualPickup(elevator, manipulator, intake));

        mechGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(new InstantCommand(() -> duckSpinner.spinSpinner()));
        mechGamepad.getGamepadButton(GamepadKeys.Button.BACK).whenPressed(new MoveCapstoneGrabber(capstoneGrabber));
    }
}

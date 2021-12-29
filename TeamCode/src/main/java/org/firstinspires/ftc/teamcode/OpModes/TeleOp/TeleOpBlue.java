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
import org.firstinspires.ftc.teamcode.Commands.IntakeCommands.IntakeDefault;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManipulatorDefault;
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
        duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_UP);

        drive.setDefaultCommand(
                new DriveDefault(
                        drive,
                        () -> driveGamepad.gamepad.left_bumper ? driveGamepad.gamepad.left_stick_y/3 : driveGamepad.gamepad.left_stick_y,
                        () -> driveGamepad.gamepad.left_bumper ? driveGamepad.gamepad.left_stick_x/3 : driveGamepad.gamepad.left_stick_x,
                        () -> driveGamepad.gamepad.left_bumper ? driveGamepad.gamepad.right_stick_x/3 : driveGamepad.gamepad.right_stick_x
                )
        );

        intake.setDefaultCommand(new IntakeDefault(intake, () -> driveGamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER), () -> driveGamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)));
        elevator.setDefaultCommand(new ElevatorDefault(elevator, () -> -mechGamepad.gamepad.right_stick_y));
        manipulator.setDefaultCommand(new ManipulatorDefault(manipulator, () -> -mechGamepad.gamepad.left_stick_y));
        capstoneGrabber.setDefaultCommand(new CapstoneGrabberDefault(capstoneGrabber));

        // Binding ---------------------------------------------------------------------------------

        driveGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new InstantCommand(() -> drive.resetHeading()));

        mechGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(new InstantCommand(() -> duckSpinner.spinSpinner()));
        mechGamepad.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(new InstantCommand(() -> duckSpinner.spinSlow()));

        mechGamepad.getGamepadButton(GamepadKeys.Button.BACK).whenPressed(new MoveCapstoneGrabber(capstoneGrabber));
    }
}

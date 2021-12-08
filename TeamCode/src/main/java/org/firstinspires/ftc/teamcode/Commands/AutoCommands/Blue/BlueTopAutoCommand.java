package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Blue;


import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;
import com.technototes.path.command.TrajectoryCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.ReLocalizeDriveBase;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Blue.BlueAutoReverseLowPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Blue.BlueAutoReverseMiddlePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Blue.BlueHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.DropGamePiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms.BlueBiasedResetMechanisms;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Blue.Blue_Top_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;

public class BlueTopAutoCommand extends SequentialCommandGroup {

    public BlueTopAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, CapstonePipeline.CapstonePosition capstonePosition) {
        switch (capstonePosition) {
            case LEFT:
                addCommands(
                        new BlueAutoReverseLowPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj1)),
                        new WaitCommand(0.250),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj2)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj4)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj6)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj8))
                );
                break;
            case CENTER:
                addCommands(
                        new BlueAutoReverseMiddlePreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj1)),
                        new WaitCommand(0.250),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj2)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj4)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj6)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj8))
                );
                break;
            case RIGHT:
                addCommands(
                        new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj1)),
                        new WaitCommand(0.250),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj2)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj4)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj6)),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(0.250),
                        () -> intake.setIntake(-0.9),
                new BlueHighPreset(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        () -> intake.setIntake(1),
                new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new TrajectoryCommand(drive, Blue_Top_Path.BT_traj8))
                );
                break;
        }
    }
}

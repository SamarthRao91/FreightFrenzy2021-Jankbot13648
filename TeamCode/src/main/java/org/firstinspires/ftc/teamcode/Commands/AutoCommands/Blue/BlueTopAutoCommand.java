package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Blue;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
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
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

public class BlueTopAutoCommand extends SequentialCommandGroup {

    public BlueTopAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, CapstonePipeline.CapstonePosition capstonePosition) {

        HeadingStorage.STORED_HEADING = Math.toRadians(90);

        switch (capstonePosition) {
            case LEFT:
                addCommands(
                        new BlueAutoReverseLowPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj1)),
                        new WaitCommand(250),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj2)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj2fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj4)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj4fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj6)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj6fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9))
                     /*   new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj8))*/
                );
                break;
            case CENTER:
                addCommands(
                        new BlueAutoReverseMiddlePreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj1)),
                        new WaitCommand(250),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj2)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj2fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj4)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj4fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj6)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj6fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9))
                     /*   new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj8))*/
                );
                break;
            case RIGHT:
                addCommands(
                        new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj1)),
                        new WaitCommand(250),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj2)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj2fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj4)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj4fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj6)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj6fix),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, false),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9))
                     /*   new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new BlueBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj8))*/
                );
                break;
        }
    }
}

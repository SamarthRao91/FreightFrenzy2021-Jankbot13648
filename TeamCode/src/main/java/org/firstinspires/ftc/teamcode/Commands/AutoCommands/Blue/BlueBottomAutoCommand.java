package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Blue.BlueAutoLowPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Blue.BlueAutoMiddlePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Blue.BlueHighReversePreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.DropGamePiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms.ResetMechanisms;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Blue.Blue_Bottom_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

public class BlueBottomAutoCommand extends SequentialCommandGroup {
    public BlueBottomAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, DuckSpinner duckSpinner, CapstonePipeline.CapstonePosition capstonePosition) {

        HeadingStorage.STORED_HEADING = Math.toRadians(90);

        switch (capstonePosition) {
            case LEFT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0, 0, Math.toRadians(180)))),
                        new BlueAutoLowPreset(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj1),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(duckSpinner::spinSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj3),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj4),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj5),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj6),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj7),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj71),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj72),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj73),
                        // new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj8),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(100),
                        new ManualPickup(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj9).alongWith(new BlueHighReversePreset(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj10).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj11)
                );
                break;
            case CENTER:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0, 0, Math.toRadians(180)))),
                        new BlueAutoMiddlePreset(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj1),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(duckSpinner::spinSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj3),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj4),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj5),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj6),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj7),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj71),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj72),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj73),
                        // new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj8),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(100),
                        new ManualPickup(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj9).alongWith(new BlueHighReversePreset(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj10).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj11)
                );
                break;
            case RIGHT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0, 0, Math.toRadians(180)))),
                        new BlueHighReversePreset(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj1),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(duckSpinner::spinSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj3),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj4),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj5),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj6),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj7),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj71),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj72),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj73),
                        // new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj8),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(100),
                        new ManualPickup(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj9).alongWith(new BlueHighReversePreset(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj10).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj11)
                );
                break;
        }
    }
}

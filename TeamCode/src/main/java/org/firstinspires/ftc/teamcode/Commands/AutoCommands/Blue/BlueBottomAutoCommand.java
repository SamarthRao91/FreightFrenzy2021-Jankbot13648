package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;
import com.technototes.path.command.TrajectoryCommand;

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

public class BlueBottomAutoCommand extends SequentialCommandGroup {
    public BlueBottomAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, DuckSpinner duckSpinner, CapstonePipeline.CapstonePosition capstonePosition) {
        switch (capstonePosition) {
            case LEFT:
                addCommands(
                        () -> drive.setPoseEstimate(new Pose2d(0, 0, Math.toRadians(180))),
                        new BlueAutoLowPreset(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj1),
                        new DropGamePiece(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        duckSpinner::spinSlow,
                        () -> intake.setIntake(0.75),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj3),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj4),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj5),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj6),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj7),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj71),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj72),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj73),
                        // new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj8),
                        new WaitCommand(0.250),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                        new WaitCommand(0.100),
                        new ManualPickup(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj9).alongWith(new BlueHighReversePreset(elevator, manipulator)),
                        () -> intake.setIntake(0),
                        new DropGamePiece(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj10).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj11)
                );
                break;
            case CENTER:
                addCommands(
                        () -> drive.setPoseEstimate(new Pose2d(0, 0, Math.toRadians(180))),
                        new BlueAutoMiddlePreset(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj1),
                        new DropGamePiece(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        duckSpinner::spinSlow,
                        () -> intake.setIntake(0.75),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj3),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj4),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj5),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj6),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj7),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj71),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj72),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj73),
                        // new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj8),
                        new WaitCommand(0.250),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                        new WaitCommand(0.100),
                        new ManualPickup(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj9).alongWith(new BlueHighReversePreset(elevator, manipulator)),
                        () -> intake.setIntake(0),
                        new DropGamePiece(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj10).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj11)
                );
                break;
            case RIGHT:
                addCommands(
                        () -> drive.setPoseEstimate(new Pose2d(0, 0, Math.toRadians(180))),
                        new BlueHighReversePreset(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj1),
                        new DropGamePiece(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        duckSpinner::spinSlow,
                        () -> intake.setIntake(0.75),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj3),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj4),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj5),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj6),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj7),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj71),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj72),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj73),
                        // new FollowTrajectory(drive, Blue_Bottom_Path.BB_traj8),
                        new WaitCommand(0.250),
                        () -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION),
                        new WaitCommand(0.100),
                        new ManualPickup(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj9).alongWith(new BlueHighReversePreset(elevator, manipulator)),
                        () -> intake.setIntake(0),
                        new DropGamePiece(elevator, manipulator),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj10).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new TrajectoryCommand(drive, Blue_Bottom_Path.BB_traj11)
                );
                break;
        }
    }
}

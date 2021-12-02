package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoLowPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoMiddlePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red.RedHighReversePreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.DropGamePiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms.ResetMechanisms;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ScoreGamePiece;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red.Red_Bottom_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;

public class RedBottomAutoCommand extends SequentialCommandGroup {
    public RedBottomAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, DuckSpinner duckSpinner, CapstonePipeline.CapstonePosition capstonePosition)
    {
        switch (capstonePosition)
        {
            case LEFT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedAutoLowPreset(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj1),
                        new ScoreGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj2),
                        new InstantCommand(duckSpinner::spinReverseSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj3),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj4),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj5),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj6),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj61),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj62),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(100),
                        new ManualPickup(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj8).alongWith( new RedHighReversePreset(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new WaitCommand(125),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj9).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj10)

                );
                break;
            case CENTER:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedAutoMiddlePreset(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj1),
                        new ScoreGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj2),
                        new InstantCommand(duckSpinner::spinReverseSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj3),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj4),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj5),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj6),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj61),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj62),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(100),
                        new ManualPickup(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj8).alongWith( new RedHighReversePreset(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new WaitCommand(125),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj9).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj10)
                );
                break;
            case RIGHT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedHighReversePreset(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj1),
                        new ScoreGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj2),
                        new InstantCommand(duckSpinner::spinReverseSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj3),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj4),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj5),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj6),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj61),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj62),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(100),
                        new ManualPickup(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj8).alongWith( new RedHighReversePreset(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new WaitCommand(125),
                        new DropGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj9).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj10)
                );
                break;
        }
    }
}

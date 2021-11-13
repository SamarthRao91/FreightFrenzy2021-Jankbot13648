package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Blue.BlueAutoReverseLowPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Blue.BlueAutoReverseMiddlePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Blue.BlueHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.DropGamePiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Blue.Blue_Top_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

public class BlueTopAutoCommand extends SequentialCommandGroup {
    
    public BlueTopAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, CapstonePipeline.CapstonePosition capstonePosition)
    {
        switch (capstonePosition)
        {
            case LEFT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(0)))),
                        new BlueHighPreset(elevator, manipulator),
                        new BlueAutoReverseLowPreset(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj1),
                        new FollowTrajectory(drive,Blue_Top_Path.BT_traj2),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #1
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj3).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj4),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj5),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj6).alongWith(new BlueHighPreset(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj7),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #2
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj8).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj9),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj10),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj11).alongWith(new BlueHighPreset(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj12),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #3
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj13).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj14),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj15),/*
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj14),
                        new BlueHighPreset(elevator, manipulator),
                        new DropGamePiece(elevator, manipulator),*/
                        new InstantCommand(() -> HeadingStorage.setHeading(-90))
                );
                break;
            case CENTER:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(0)))),
                        new BlueHighPreset(elevator, manipulator),
                        new BlueAutoReverseMiddlePreset(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj1),
                        new FollowTrajectory(drive,Blue_Top_Path.BT_traj2),
                        new DropGamePiece(elevator, manipulator),

                        /// Cycle #1
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj3).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj4),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj5),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj6).alongWith(new BlueHighPreset(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj7),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #2
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj8).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj9),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj10),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj11).alongWith(new BlueHighPreset(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj12),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #3
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj13).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj14),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj15),/*
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj14),
                        new BlueHighPreset(elevator, manipulator),
                        new DropGamePiece(elevator, manipulator),*/
                        new InstantCommand(() -> HeadingStorage.setHeading(-90))
                );
                break;
            case RIGHT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(0)))),
                        new BlueHighPreset(elevator, manipulator),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj1),
                        new FollowTrajectory(drive,Blue_Top_Path.BT_traj2),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #1
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj3).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj4),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj5),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj6).alongWith(new BlueHighPreset(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj7),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #2
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj8).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj9),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj10),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj11).alongWith(new BlueHighPreset(elevator, manipulator)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj12),
                        new DropGamePiece(elevator, manipulator),

                        // Cycle #3
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj13).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj14),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.66)),
                        new WaitCommand(250),
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj15),/*
                        new FollowTrajectory(drive, Blue_Top_Path.BT_traj14),
                        new BlueHighPreset(elevator, manipulator),
                        new DropGamePiece(elevator, manipulator),*/
                        new InstantCommand(() -> HeadingStorage.setHeading(-90))
                );
                break;
        }
    }
}

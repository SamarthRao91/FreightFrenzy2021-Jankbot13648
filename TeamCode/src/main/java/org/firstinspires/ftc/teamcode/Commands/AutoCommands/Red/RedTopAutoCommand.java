package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.ReLocalizeDriveBase;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoMiddlePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoReverseLowPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoReverseMiddlePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red.RedHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.DropGamePiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ResetMechanisms.RedBiasedResetMechanisms;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red.Red_Top_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;

public class RedTopAutoCommand extends SequentialCommandGroup {

    public RedTopAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, CapstonePipeline.CapstonePosition capstonePosition) {
        switch (capstonePosition) {
            case LEFT:
                addCommands(
                        new RedAutoReverseLowPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj1)),
                        new WaitCommand(250),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj2)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj4)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj6)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj8)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9))
                );
                break;
            case CENTER:
                addCommands(
                        new RedAutoReverseMiddlePreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj1)),
                        new WaitCommand(250),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj2)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj4)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj6)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj8)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9))
                );
                break;
            case RIGHT:
                addCommands(
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj1)),
                        new WaitCommand(250),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj2)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj3)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj4)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj5)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj6)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9)),
                        new RedHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj7)),
                        new DropGamePiece(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new RedBiasedResetMechanisms(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj8)),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new ReLocalizeDriveBase(drive, true),
                        new WaitCommand(250),
                        new InstantCommand(() -> intake.setIntake(-0.9))
                );
                break;
        }
    }
}

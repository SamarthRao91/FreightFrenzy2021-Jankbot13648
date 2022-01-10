package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands.PushGamepiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.RedBottomHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.RedHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.RedReverseAutoLowPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.RedReverseAutoMidPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.ResetMechanisms;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red.Red_Bottom_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

public class RedBottomAutoCommand extends SequentialCommandGroup {
    public RedBottomAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, DuckSpinner duckSpinner, CapstonePipeline.CapstonePosition capstonePosition)
    {

        HeadingStorage.STORED_HEADING = Math.toRadians(270);

        switch (capstonePosition)
        {
            case LEFT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedReverseAutoLowPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Bottom_Path.RB_traj1)),
                        new PushGamepiece(manipulator),
                        new WaitCommand(100),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(()-> duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_DOWN)),
                        new InstantCommand(duckSpinner::spinReverseSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new InstantCommand(() -> duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_UP)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj3),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj4),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj5),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj6),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj61),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj62),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.closeClaw()),
                        new WaitCommand(100),
                        new ManualPickup(manipulator, intake),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj8),
                        new RedBottomHighPreset(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new WaitCommand(125),
                        new PushGamepiece(manipulator),
                        new WaitCommand(100),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj9).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj10)

                );
                break;
            case CENTER:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedReverseAutoMidPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Bottom_Path.RB_traj1)),
                        new PushGamepiece(manipulator),
                        new WaitCommand(100),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(()-> duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_DOWN)),
                        new InstantCommand(duckSpinner::spinReverseSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new InstantCommand(() -> duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_UP)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj3),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj4),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj5),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj6),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj61),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj62),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.closeClaw()),
                        new WaitCommand(100),
                        new ManualPickup(manipulator, intake),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj8),
                        new RedBottomHighPreset(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new WaitCommand(125),
                        new PushGamepiece(manipulator),
                        new WaitCommand(100),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj9).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj10),
                        new WaitCommand(11)
                );
                break;
            case RIGHT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedBottomHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Red_Bottom_Path.RB_traj1)),
                        new PushGamepiece(manipulator),
                        new WaitCommand(100),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj2).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new InstantCommand(()-> duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_DOWN)),
                        new InstantCommand(duckSpinner::spinReverseSlow),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new InstantCommand(() -> duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_UP)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj3),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj4),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj5),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj6),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj61),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj62),
                        new WaitCommand(250),
                        new InstantCommand(() -> manipulator.closeClaw()),
                        new WaitCommand(100),
                        new ManualPickup(manipulator, intake),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj8),
                        new RedBottomHighPreset(elevator, manipulator),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new WaitCommand(125),
                        new PushGamepiece(manipulator),
                        new WaitCommand(100),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj9).alongWith(new ResetMechanisms(elevator, manipulator)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj10),
                        new WaitCommand(12)
                );
                break;
        }
    }
}

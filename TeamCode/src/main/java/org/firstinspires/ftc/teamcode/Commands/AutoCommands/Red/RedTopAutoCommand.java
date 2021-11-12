package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoLowPreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.AutoPresets.Red.RedAutoMiddlePreset;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommands.Presets.Red.RedHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ScoreGamePiece;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red.Red_Top_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;

public class RedTopAutoCommand extends SequentialCommandGroup {
    public RedTopAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, CapstonePipeline.CapstonePosition capstonePosition)
    {
        switch (capstonePosition)
        {
            case LEFT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedHighPreset(elevator, manipulator),
                        new RedAutoLowPreset(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj1),
                        new FollowTrajectory(drive,Red_Top_Path.RT_traj2),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #1
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj3),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj4),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj5),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj6),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #2
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj7),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj8),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj9),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj10),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #3
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj11),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj12),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj13)/*,
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj14),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator)*/
                );
                break;
            case CENTER:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedHighPreset(elevator, manipulator),
                        new RedAutoMiddlePreset(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj1),
                        new FollowTrajectory(drive,Red_Top_Path.RT_traj2),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #1
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj3),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj4),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj5),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj6),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #2
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj7),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj8),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj9),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj10),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #3
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj11),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj12),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj13)/*,
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj14),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator)*/
                );
                break;
            case RIGHT:
                addCommands(
                        new InstantCommand(() -> drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(180)))),
                        new RedHighPreset(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj1),
                        new FollowTrajectory(drive,Red_Top_Path.RT_traj2),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #1
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj3),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj4),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj5),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj6),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #2
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj7),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj8),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj9),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj10),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator),

                        // Cycle #3
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj11),
                        new InstantCommand(() -> intake.setIntake(1)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj12),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new InstantCommand(() -> intake.setIntake(-0.25)),
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj13)/*,
                        new FollowTrajectory(drive, Red_Top_Path.RT_traj14),
                        new RedHighPreset(elevator, manipulator),
                        new ScoreGamePiece(elevator, manipulator)*/
                );
                break;
        }
    }
}

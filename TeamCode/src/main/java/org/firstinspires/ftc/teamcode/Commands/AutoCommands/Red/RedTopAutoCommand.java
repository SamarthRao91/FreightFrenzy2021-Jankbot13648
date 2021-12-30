package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.RedHighPreset;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red.Red_Top_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

public class RedTopAutoCommand extends SequentialCommandGroup {

    public RedTopAutoCommand(Drive drive, Elevator elevator, Manipulator manipulator, Intake intake, CapstonePipeline.CapstonePosition capstonePosition) {

        HeadingStorage.STORED_HEADING = Math.toRadians(270);

        switch (capstonePosition) {
            case LEFT:
                addCommands(
                        new RedHighPreset(elevator, manipulator),
                        new PushAndResetAndIntake(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj1)),
                        new PickupAndHighPresetRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj2)),
                        new PushAndResetAndIntake(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj3)),
                        new PickupAndHighPresetRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj4)),
                        new PushAndResetAndIntake(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj5)),
                        new PickupAndHighPresetRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj6)),
                        new PushAndResetAndIntake(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj7)),
                        new PickupAndHighPresetRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj8)),
                        new PushAndResetAndIntake(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj9)),
                        new PickupAndHighPresetRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj10)),
                        new PushAndResetAndIntake(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj11)),
                        new PickupAndHighPresetRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj12)),
                        new PushAndResetAndIntake(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Red_Top_Path.RT_traj13))

                );
                break;
            case CENTER:
                addCommands(
                        new WaitCommand(11)


                );
                break;
            case RIGHT:
                addCommands(
                        new WaitCommand(12)
                );
                break;
        }
    }
}

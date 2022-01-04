package org.firstinspires.ftc.teamcode.Commands.AutoCommands.Blue;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.AutoCommands.PushAndResetAndIntakeBlue;
import org.firstinspires.ftc.teamcode.Commands.AutoCommands.PushAndResetAndIntakeRed;
import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.BlueHighPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.RedReverseAutoLowPreset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.RedReverseAutoMidPreset;
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
                        new RedReverseAutoLowPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj0)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj1)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj2)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj3)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj4)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj5)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj6)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj7)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj8)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj9)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj10)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj11))
                      /*  new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj12)),
                        new PushAndResetAndIntakeRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj13))*/
                );
                break;
            case CENTER:
                addCommands(
                        new RedReverseAutoMidPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj0)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj1)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj2)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj3)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj4)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj5)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj6)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj7)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj8)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj9)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj10)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj11))
                      /*  new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj12)),
                        new PushAndResetAndIntakeRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj13))*/
                );
                break;
            case RIGHT:
                addCommands(
                        new BlueHighPreset(elevator, manipulator).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj0)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj1)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj2)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj3)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj4)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj5)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj6)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj7)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj8)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj9)),
                        new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj10)),
                        new PushAndResetAndIntakeBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj11))
                      /*  new PickupAndHighPresetBlue(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj12)),
                        new PushAndResetAndIntakeRed(elevator, manipulator, intake).alongWith(new FollowTrajectory(drive, Blue_Top_Path.BT_traj13))*/
                );
                break;
        }
    }
}

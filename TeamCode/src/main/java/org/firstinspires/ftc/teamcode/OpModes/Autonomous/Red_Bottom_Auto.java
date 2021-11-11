package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.DriveBaseCommands.FollowTrajectory;
import org.firstinspires.ftc.teamcode.Commands.DuckSpinnerCommands.SpinDuckSpinner;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ManualPickup;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.ScoreGamePiece;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsytemCommands.SuperStructureToPosition;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.OpModes.Autonomous.Paths.Red.Red_Bottom_Path;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.CapstoneDetectionCamera;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;

@Autonomous(name = "Red Bottom Auto")
public class Red_Bottom_Auto extends LinearOpMode {

    Drive drive;
    Elevator elevator;
    Manipulator manipulator;
    Intake intake;
    DuckSpinner duckSpinner;
    CapstoneDetectionCamera capstoneDetectionCamera;

    CapstonePipeline.CapstonePosition capstonePosition;

    @Override
    public void runOpMode() throws InterruptedException {

        drive = new Drive(new MecanumDrive(hardwareMap), true);
        elevator = new Elevator(hardwareMap);
        manipulator = new Manipulator(hardwareMap);
        intake = new Intake(hardwareMap);
        duckSpinner = new DuckSpinner(hardwareMap);
        capstoneDetectionCamera = new CapstoneDetectionCamera(hardwareMap);

        register(drive, elevator, manipulator, intake, duckSpinner, capstoneDetectionCamera);

        while (!isStarted())
        {
            capstonePosition = capstoneDetectionCamera.getPosition();

            telemetry.addData("Capstone Position", capstonePosition);
            telemetry.addData("Left Analysis", capstoneDetectionCamera.getAnalysis()[0]);
            telemetry.addData("Middle Analysis", capstoneDetectionCamera.getAnalysis()[1]);
            telemetry.addData("Right Analysis", capstoneDetectionCamera.getAnalysis()[2]);
            telemetry.update();
        }

        scheduleCommands(new SequentialCommandGroup(
                new SuperStructureToPosition(
                        elevator,
                        manipulator,
                        1400 + 300,
                        1,
                        Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                        Constants.Manipulator.Extender.MAX_POS,
                        Constants.Manipulator.Claw.CLOSE_POSITION
                )
        ));

        switch (capstonePosition)
        {
            case LEFT:
                scheduleCommands(new SequentialCommandGroup(
                        new SuperStructureToPosition(
                                elevator,
                                manipulator,
                                445,
                                1,
                                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                                Constants.Manipulator.Extender.MAX_POS,
                                Constants.Manipulator.Claw.CLOSE_POSITION
                        )
                ));
                break;
            case CENTER:
                scheduleCommands(new SequentialCommandGroup(
                        new SuperStructureToPosition(
                                elevator,
                                manipulator,
                                900,
                                1,
                                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                                Constants.Manipulator.Extender.MAX_POS,
                                Constants.Manipulator.Claw.CLOSE_POSITION
                        )
                ));
                break;
            case RIGHT:
                scheduleCommands(new SequentialCommandGroup(
                        new SuperStructureToPosition(
                                elevator,
                                manipulator,
                                1400 + 300,
                                1,
                                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                                Constants.Manipulator.Extender.MAX_POS,
                                Constants.Manipulator.Claw.CLOSE_POSITION
                        )
                ));
                break;
        }

        scheduleCommands(
                new SequentialCommandGroup(
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj1),
                        new ScoreGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj2),
                        new SpinDuckSpinner(duckSpinner, true, 0.2, 0.4),
                        new InstantCommand(() -> intake.setIntake(0.75)),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj3),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj4),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj5),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj6),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_trajfix),
                        new WaitCommand(500),
                        new InstantCommand(() -> manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION)),
                        new WaitCommand(100),
                        new ManualPickup(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj7),
                        new InstantCommand(() -> intake.setIntake(0)),
                        new SuperStructureToPosition(
                                elevator,
                                manipulator,
                                1400 + 300,
                                1,
                                Constants.Manipulator.Turret.RIGHT_MAXIMUM_POSITION,
                                Constants.Manipulator.Extender.MAX_POS,
                                Constants.Manipulator.Claw.CLOSE_POSITION
                        ),
                        new ScoreGamePiece(elevator, manipulator),
                        new FollowTrajectory(drive, Red_Bottom_Path.RB_traj8)
                )
        );

        if(!isStopRequested() && opModeIsActive())
        {
            getCommandScheduler().run();
        }
    }

    public CommandScheduler getCommandScheduler()
    {
        return CommandScheduler.getInstance();
    }

    public void register(Subsystem... subsystems)
    {
        getCommandScheduler().registerSubsystem(subsystems);
    }

    public void scheduleCommands(Command... commands)
    {
        getCommandScheduler().schedule(commands);
    }
}
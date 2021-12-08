package org.firstinspires.ftc.teamcode.OpModes.Autonomous.Red;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.AutoCommands.Red.RedTopAutoCommand;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Drive;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.Systems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Intake;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Systems.Vision.CapstoneDetectionCamera;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.firstinspires.ftc.teamcode.Util.HeadingStorage;

@Autonomous(name = "RED | Top Auto", group = "Red", preselectTeleOp = "RED | Tele-Op")
public class Red_Top_Auto extends LinearOpMode {

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
        capstoneDetectionCamera = new CapstoneDetectionCamera(hardwareMap, false);

        register(
                drive,
                elevator,
                manipulator,
                intake,
                duckSpinner
        );

        HeadingStorage.STORED_HEADING = 0;
        drive.setHeadingOffset(0);

        manipulator.setClawPosition(Constants.Manipulator.Claw.CLOSE_POSITION);
        duckSpinner.setRedDuckWall(Constants.DuckSpinner.RED_WALL_UP);

        while (!isStarted()) {
            capstonePosition = capstoneDetectionCamera.getPosition();

            telemetry.addData("Capstone Position", capstonePosition);
            telemetry.addData("Left Analysis", capstoneDetectionCamera.getAnalysis()[0]);
            telemetry.addData("Middle Analysis", capstoneDetectionCamera.getAnalysis()[1]);
            telemetry.addData("Right Analysis", capstoneDetectionCamera.getAnalysis()[2]);
            telemetry.update();
        }

        schedule(
                new RedTopAutoCommand(
                        drive,
                        elevator,
                        manipulator,
                        intake,
                        capstonePosition
                )
        );

        while (!isStopRequested() && opModeIsActive()) {
            getCommandScheduler().run();
        }

        getCommandScheduler().reset();
    }

    public CommandScheduler getCommandScheduler() {
        return CommandScheduler.getInstance();
    }

    public void register(Subsystem... subsystems) {
        getCommandScheduler().registerSubsystem(subsystems);
    }

    public void schedule(Command... commands) {
        getCommandScheduler().schedule(commands);
    }
}

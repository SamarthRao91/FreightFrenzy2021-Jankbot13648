package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.*;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
@TeleOp(name = "Elevator Check")
public class EncoderCheck extends LinearOpMode {
    //different subsystems
    //MecanumDrive drive;
    //Claw claw;
    //DuckSpinner spinner;
   // Extender extender;
    Elevator elevator;
    //Intake intake;
   // Turret turret;



    @Override
    public void runOpMode() {

        elevator = new Elevator(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive())
        {
            if(gamepad1.x) {
                elevator.toPosition(1200);
            }





        }
    }
}
